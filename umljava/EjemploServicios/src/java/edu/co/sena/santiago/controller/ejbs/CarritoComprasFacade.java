/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.controller.ejbs;

import edu.co.sena.santiago.modelo.entites.CarritoCompras;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class CarritoComprasFacade extends AbstractFacade<CarritoCompras> implements CarritoComprasFacadeLocal {
    @PersistenceContext(unitName = "EjemploServiciosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarritoComprasFacade() {
        super(CarritoCompras.class);
    }
    
}
