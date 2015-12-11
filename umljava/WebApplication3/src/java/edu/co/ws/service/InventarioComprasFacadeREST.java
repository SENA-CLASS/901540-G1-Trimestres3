/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.ws.service;

import edu.co.ws.InventarioCompras;
import edu.co.ws.InventarioComprasPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author hernando
 */
@Stateless
@Path("edu.co.ws.inventariocompras")
public class InventarioComprasFacadeREST extends AbstractFacade<InventarioCompras> {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    private InventarioComprasPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idInventario=idInventarioValue;productoIdProducto=productoIdProductoValue;proveedorTipoDocumentoTipoDocumento=proveedorTipoDocumentoTipoDocumentoValue;proveedorNumDocumento=proveedorNumDocumentoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        edu.co.ws.InventarioComprasPK key = new edu.co.ws.InventarioComprasPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idInventario = map.get("idInventario");
        if (idInventario != null && !idInventario.isEmpty()) {
            key.setIdInventario(new java.lang.Integer(idInventario.get(0)));
        }
        java.util.List<String> productoIdProducto = map.get("productoIdProducto");
        if (productoIdProducto != null && !productoIdProducto.isEmpty()) {
            key.setProductoIdProducto(productoIdProducto.get(0));
        }
        java.util.List<String> proveedorTipoDocumentoTipoDocumento = map.get("proveedorTipoDocumentoTipoDocumento");
        if (proveedorTipoDocumentoTipoDocumento != null && !proveedorTipoDocumentoTipoDocumento.isEmpty()) {
            key.setProveedorTipoDocumentoTipoDocumento(proveedorTipoDocumentoTipoDocumento.get(0));
        }
        java.util.List<String> proveedorNumDocumento = map.get("proveedorNumDocumento");
        if (proveedorNumDocumento != null && !proveedorNumDocumento.isEmpty()) {
            key.setProveedorNumDocumento(proveedorNumDocumento.get(0));
        }
        return key;
    }

    public InventarioComprasFacadeREST() {
        super(InventarioCompras.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(InventarioCompras entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, InventarioCompras entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        edu.co.ws.InventarioComprasPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public InventarioCompras find(@PathParam("id") PathSegment id) {
        edu.co.ws.InventarioComprasPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<InventarioCompras> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<InventarioCompras> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
