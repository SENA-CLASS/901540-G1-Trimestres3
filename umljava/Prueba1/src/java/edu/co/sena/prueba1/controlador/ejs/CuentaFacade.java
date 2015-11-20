/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.prueba1.controlador.ejs;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import edu.co.sena.prueba1.controlador.managerbeans.util.JsfUtil;
import edu.co.sena.prueba1.modelo.pojos.Cuenta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hernando
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {
    @PersistenceContext(unitName = "Prueba1PU")
    private EntityManager em;
    
    private static final String NOMBRE_ARCHIVO = "cuenta.txt";
    private List<Cuenta> cuentas = new ArrayList<>();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }

    @Override
    public void edit(Cuenta entity) {
        
        try {
            
            FileInputStream fis = new FileInputStream(CuentaFacade.NOMBRE_ARCHIVO);
           
            try {
                ObjectInputStream in = new ObjectInputStream(fis);
                this.cuentas = (List)in.readObject();
                cuentas.add(entity);
                
            } catch (ClassNotFoundException e) {
                JsfUtil.addSuccessMessage("no se pudo almacena"+e.getMessage());
            }
            
        } catch (IOException e) {
            try {
                
                FileOutputStream fos = new FileOutputStream(CuentaFacade.NOMBRE_ARCHIVO);
                JsfUtil.addSuccessMessage("se creo el archivo: "+ CuentaFacade.NOMBRE_ARCHIVO);
            } catch (FileNotFoundException ex) {
                 JsfUtil.addErrorMessage(ex, "no se pudo crear archivo");
            }
        }
        
        
      
    }
    
}
