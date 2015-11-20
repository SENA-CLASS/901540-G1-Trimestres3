/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.prueba1.controlador.ejs;

import edu.co.sena.prueba1.modelo.pojos.Cliente;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {
    @PersistenceContext(unitName = "Prueba1PU")
    
    private EntityManager em;

    private static final String NOMBRE_ARCHIVO = "cliente.txt";
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public void edit(Cliente entity) {
        try (FileOutputStream fos = new FileOutputStream(ClienteFacade.NOMBRE_ARCHIVO);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(entity);
            
            System.out.println ("Successfully wrote Portfolio as an object");
        } catch (IOException i) {
            System.out.println("Exception writing out Portfolio: " + i);
        }
    }
    
}
