/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.ws.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author hernando
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(edu.co.ws.service.CarritoComprasFacadeREST.class);
        resources.add(edu.co.ws.service.CatalogoFacadeREST.class);
        resources.add(edu.co.ws.service.CategoriaFacadeREST.class);
        resources.add(edu.co.ws.service.CuentaFacadeREST.class);
        resources.add(edu.co.ws.service.DepartamentoFacadeREST.class);
        resources.add(edu.co.ws.service.DomicilioCuentasFacadeREST.class);
        resources.add(edu.co.ws.service.DomicilioProveeFacadeREST.class);
        resources.add(edu.co.ws.service.FacturaFacadeREST.class);
        resources.add(edu.co.ws.service.InventarioComprasFacadeREST.class);
        resources.add(edu.co.ws.service.ItemCarritoFacadeREST.class);
        resources.add(edu.co.ws.service.ItemFacadeREST.class);
        resources.add(edu.co.ws.service.MunicipioFacadeREST.class);
        resources.add(edu.co.ws.service.PagoFacadeREST.class);
        resources.add(edu.co.ws.service.PedidoFacadeREST.class);
        resources.add(edu.co.ws.service.ProductoFacadeREST.class);
        resources.add(edu.co.ws.service.ProveedorFacadeREST.class);
        resources.add(edu.co.ws.service.TipoDocumentoFacadeREST.class);
        resources.add(edu.co.ws.service.UsuarioFacadeREST.class);
    }
    
}
