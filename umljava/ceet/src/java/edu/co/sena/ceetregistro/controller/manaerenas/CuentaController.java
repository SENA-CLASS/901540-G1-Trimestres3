package edu.co.sena.ceetregistro.controller.manaerenas;

import edu.co.sena.ceetregistro.model.entiies.Cuenta;
import edu.co.sena.ceetregistro.controller.manaerenas.util.JsfUtil;
import edu.co.sena.ceetregistro.controller.manaerenas.util.JsfUtil.PersistAction;
import edu.co.sena.ceetregistro.controller.ejbs.CuentaFacade;

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
import javax.faces.view.ViewScoped;

@ManagedBean(name = "cuentaController")
@ViewScoped
public class CuentaController implements Serializable {

    @EJB
    private edu.co.sena.ceetregistro.controller.ejbs.CuentaFacade ejbFacade;
    private List<Cuenta> items = null;
    private Cuenta selected;

    public CuentaController() {
    }

    public Cuenta getSelected() {
        return selected;
    }

    public void setSelected(Cuenta selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCuentaPK().setTipoDocumentotipodocumento(selected.getTipoDocumento().getTipoDocumento());
    }

    protected void initializeEmbeddableKey() {
        selected.setCuentaPK(new edu.co.sena.ceetregistro.model.entiies.CuentaPK());
    }

    private CuentaFacade getFacade() {
        return ejbFacade;
    }

    public Cuenta prepareCreate() {
        selected = new Cuenta();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CuentaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CuentaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CuentaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Cuenta> getItems() {
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

    public List<Cuenta> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cuenta> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Cuenta.class)
    public static class CuentaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CuentaController controller = (CuentaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cuentaController");
            return controller.getFacade().find(getKey(value));
        }

        edu.co.sena.ceetregistro.model.entiies.CuentaPK getKey(String value) {
            edu.co.sena.ceetregistro.model.entiies.CuentaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.co.sena.ceetregistro.model.entiies.CuentaPK();
            key.setTipoDocumentotipodocumento(values[0]);
            key.setNumeroDocumento(values[1]);
            return key;
        }

        String getStringKey(edu.co.sena.ceetregistro.model.entiies.CuentaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTipoDocumentotipodocumento());
            sb.append(SEPARATOR);
            sb.append(value.getNumeroDocumento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cuenta) {
                Cuenta o = (Cuenta) object;
                return getStringKey(o.getCuentaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cuenta.class.getName()});
                return null;
            }
        }

    }

}
