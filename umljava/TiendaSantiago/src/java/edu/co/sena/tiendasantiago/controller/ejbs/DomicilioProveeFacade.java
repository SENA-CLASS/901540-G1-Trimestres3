/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.tiendasantiago.controller.ejbs;

import edu.co.sena.tiendasantiago.modelo.entities.jpa.mysql.DomicilioProvee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class DomicilioProveeFacade extends AbstractFacade<DomicilioProvee> {
    @PersistenceContext(unitName = "TiendaSantiagoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DomicilioProveeFacade() {
        super(DomicilioProvee.class);
    }
    
}
