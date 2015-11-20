package edu.co.sena.tiendasantiago.controller.managerbeans;

import edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarrito;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil;
import edu.co.sena.tiendasantiago.controller.managerbeans.util.JsfUtil.PersistAction;
import edu.co.sena.tiendasantiago.controller.ejbs.ItemCarritoFacade;

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

@ManagedBean(name = "itemCarritoController")
@SessionScoped
public class ItemCarritoController implements Serializable {

    @EJB
    private edu.co.sena.tiendasantiago.controller.ejbs.ItemCarritoFacade ejbFacade;
    private List<ItemCarrito> items = null;
    private ItemCarrito selected;

    public ItemCarritoController() {
    }

    public ItemCarrito getSelected() {
        return selected;
    }

    public void setSelected(ItemCarrito selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getItemCarritoPK().setProductoIdProducto(selected.getProducto().getIdProducto());
        selected.getItemCarritoPK().setCarritoComprasIdCarrito(selected.getCarritoCompras().getIdCarrito());
    }

    protected void initializeEmbeddableKey() {
        selected.setItemCarritoPK(new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarritoPK());
    }

    private ItemCarritoFacade getFacade() {
        return ejbFacade;
    }

    public ItemCarrito prepareCreate() {
        selected = new ItemCarrito();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ItemCarritoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ItemCarritoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ItemCarritoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ItemCarrito> getItems() {
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

    public List<ItemCarrito> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ItemCarrito> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ItemCarrito.class)
    public static class ItemCarritoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ItemCarritoController controller = (ItemCarritoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "itemCarritoController");
            return controller.getFacade().find(getKey(value));
        }

        edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarritoPK getKey(String value) {
            edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarritoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarritoPK();
            key.setCarritoComprasIdCarrito(values[0]);
            key.setProductoIdProducto(values[1]);
            return key;
        }

        String getStringKey(edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.ItemCarritoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCarritoComprasIdCarrito());
            sb.append(SEPARATOR);
            sb.append(value.getProductoIdProducto());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ItemCarrito) {
                ItemCarrito o = (ItemCarrito) object;
                return getStringKey(o.getItemCarritoPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ItemCarrito.class.getName()});
                return null;
            }
        }

    }

}
