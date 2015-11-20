package edu.co.sena.ceetregistro.controller.manaerenas;

import edu.co.sena.ceetregistro.model.entiies.Propietario;
import edu.co.sena.ceetregistro.controller.manaerenas.util.JsfUtil;
import edu.co.sena.ceetregistro.controller.manaerenas.util.JsfUtil.PersistAction;
import edu.co.sena.ceetregistro.controller.ejbs.PropietarioFacade;

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

@ManagedBean(name = "propietarioController")
@SessionScoped
public class PropietarioController implements Serializable {

    @EJB
    private edu.co.sena.ceetregistro.controller.ejbs.PropietarioFacade ejbFacade;
    private List<Propietario> items = null;
    private Propietario selected;

    public PropietarioController() {
    }

    public Propietario getSelected() {
        return selected;
    }

    public void setSelected(Propietario selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getPropietarioPK().setCuentanumeroDocumento(selected.getCuenta().getCuentaPK().getNumeroDocumento());
        selected.getPropietarioPK().setCuentaTipoDocumentotipodocumento(selected.getCuenta().getCuentaPK().getTipoDocumentotipodocumento());
        selected.getPropietarioPK().setEquipoSerial(selected.getEquipo().getSerial());
    }

    protected void initializeEmbeddableKey() {
        selected.setPropietarioPK(new edu.co.sena.ceetregistro.model.entiies.PropietarioPK());
    }

    private PropietarioFacade getFacade() {
        return ejbFacade;
    }

    public Propietario prepareCreate() {
        selected = new Propietario();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PropietarioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PropietarioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PropietarioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Propietario> getItems() {
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

    public List<Propietario> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Propietario> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Propietario.class)
    public static class PropietarioControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PropietarioController controller = (PropietarioController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "propietarioController");
            return controller.getFacade().find(getKey(value));
        }

        edu.co.sena.ceetregistro.model.entiies.PropietarioPK getKey(String value) {
            edu.co.sena.ceetregistro.model.entiies.PropietarioPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.co.sena.ceetregistro.model.entiies.PropietarioPK();
            key.setEquipoSerial(values[0]);
            key.setCuentaTipoDocumentotipodocumento(values[1]);
            key.setCuentanumeroDocumento(values[2]);
            return key;
        }

        String getStringKey(edu.co.sena.ceetregistro.model.entiies.PropietarioPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getEquipoSerial());
            sb.append(SEPARATOR);
            sb.append(value.getCuentaTipoDocumentotipodocumento());
            sb.append(SEPARATOR);
            sb.append(value.getCuentanumeroDocumento());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Propietario) {
                Propietario o = (Propietario) object;
                return getStringKey(o.getPropietarioPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Propietario.class.getName()});
                return null;
            }
        }

    }

}
