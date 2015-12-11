/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiui;

import edu.asdf.asdf.asdf.Categoria;
import edu.asdf.asdf.asdf.eadd.CategoriaFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author hernando
 */
@WebService(serviceName = "NewWebService1")
public class NewWebService1 {

    @EJB
    private CategoriaFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.create(categoria);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.edit(categoria);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "categoria") Categoria categoria) {
        ejbRef.remove(categoria);
    }

    @WebMethod(operationName = "find")
    public Categoria find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Categoria> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Categoria> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
