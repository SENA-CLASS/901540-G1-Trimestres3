package edu.co.sena.tiendasantiago.controller.managerbeans;

import edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentas;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil.PersistAction;
import edu.co.sena.tiendasantiago.controller.ejbs.DomicilioCuentasFacade;

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

@ManagedBean(name = "domicilioCuentasController")
@SessionScoped
public class DomicilioCuentasController implements Serializable {

    @EJB
    private edu.co.sena.tiendasantiago.controller.ejbs.DomicilioCuentasFacade ejbFacade;
    private List<DomicilioCuentas> items = null;
    private DomicilioCuentas selected;

    public DomicilioCuentasController() {
    }

    public DomicilioCuentas getSelected() {
        return selected;
    }

    public void setSelected(DomicilioCuentas selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getDomicilioCuentasPK().setCuentaNumeroDocumento(selected.getCuenta().getCuentaPK().getNumeroDocumento());
        selected.getDomicilioCuentasPK().setCuentaTipoDocumentoTipoDocumento(selected.getCuenta().getCuentaPK().getTipoDocumentoTipoDocumento());
    }

    protected void initializeEmbeddableKey() {
        selected.setDomicilioCuentasPK(new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentasPK());
    }

    private DomicilioCuentasFacade getFacade() {
        return ejbFacade;
    }

    public DomicilioCuentas prepareCreate() {
        selected = new DomicilioCuentas();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DomicilioCuentasCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DomicilioCuentasUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DomicilioCuentasDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DomicilioCuentas> getItems() {
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

    public List<DomicilioCuentas> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DomicilioCuentas> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DomicilioCuentas.class)
    public static class DomicilioCuentasControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DomicilioCuentasController controller = (DomicilioCuentasController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "domicilioCuentasController");
            return controller.getFacade().find(getKey(value));
        }

        edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentasPK getKey(String value) {
            edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentasPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentasPK();
            key.setCuentaTipoDocumentoTipoDocumento(values[0]);
            key.setCuentaNumeroDocumento(values[1]);
            return key;
        }

        String getStringKey(edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioCuentasPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCuentaTipoDocumentoTipoDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getCuentaNumeroDocumento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DomicilioCuentas) {
                DomicilioCuentas o = (DomicilioCuentas) object;
                return getStringKey(o.getDomicilioCuentasPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DomicilioCuentas.class.getName()});
                return null;
            }
        }

    }

}
