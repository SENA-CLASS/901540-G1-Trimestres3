/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wawa;

import edu.asdf.asdf.asdf.Cuenta;
import edu.asdf.asdf.asdf.eadd.CuentaFacadeLocal;
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
@WebService(serviceName = "NewWebService")
public class NewWebService {

    @EJB
    private CuentaFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "cuenta") Cuenta cuenta) {
        ejbRef.create(cuenta);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "cuenta") Cuenta cuenta) {
        ejbRef.edit(cuenta);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "cuenta") Cuenta cuenta) {
        ejbRef.remove(cuenta);
    }

    @WebMethod(operationName = "find")
    public Cuenta find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Cuenta> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Cuenta> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
