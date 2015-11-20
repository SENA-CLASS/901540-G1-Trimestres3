/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.controller.ejbs;

import edu.co.sena.santiago.modelo.entites.ItemCarrito;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class ItemCarritoFacade extends AbstractFacade<ItemCarrito> implements ItemCarritoFacadeLocal {
    @PersistenceContext(unitName = "EjemploServiciosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItemCarritoFacade() {
        super(ItemCarrito.class);
    }
    
}
