package edu.co.sena.tiendasantiago.controller.managerbeans;

import edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProvee;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil.PersistAction;
import edu.co.sena.tiendasantiago.controller.ejbs.DomicilioProveeFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@ManagedBean(name = "domicilioProveeController")
@SessionScoped
public class DomicilioProveeController implements Serializable {

    @EJB
    private edu.co.sena.tiendasantiago.controller.ejbs.DomicilioProveeFacade ejbFacade;
    private List<DomicilioProvee> items = null;
    private DomicilioProvee selected;

    public DomicilioProveeController() {
    }

    public DomicilioProvee getSelected() {
        return selected;
    }

    public void setSelected(DomicilioProvee selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDomicilioProveePK().setProveedorTipoDocumentoTipoDocumento(selected.getProveedor().getProveedorPK().getTipoDocumentoTipoDocumento());
        selected.getDomicilioProveePK().setProveedorNumDocumento(selected.getProveedor().getProveedorPK().getNumDocumento());
    }

    protected void initializeEmbeddableKey() {
        selected.setDomicilioProveePK(new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProveePK());
    }

    private DomicilioProveeFacade getFacade() {
        return ejbFacade;
    }

    public DomicilioProvee prepareCreate() {
        selected = new DomicilioProvee();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DomicilioProveeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DomicilioProveeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DomicilioProveeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DomicilioProvee> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public List<DomicilioProvee> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DomicilioProvee> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DomicilioProvee.class)
    public static class DomicilioProveeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DomicilioProveeController controller = (DomicilioProveeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "domicilioProveeController");
            return controller.getFacade().find(getKey(value));
        }

        edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProveePK getKey(String value) {
            edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProveePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProveePK();
            key.setProveedorTipoDocumentoTipoDocumento(values[0]);
            key.setProveedorNumDocumento(values[1]);
            return key;
        }

        String getStringKey(edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProveePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getProveedorTipoDocumentoTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getProveedorNumDocumento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DomicilioProvee) {
                DomicilioProvee o = (DomicilioProvee) object;
                return getStringKey(o.getDomicilioProveePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DomicilioProvee.class.getName()});
                return null;
            }
        }

    }

}
