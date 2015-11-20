/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.controller.ejbs;

import edu.co.sena.santiago.modelo.entites.DomicilioProvee;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hernando
 */
@Local
public interface DomicilioProveeFacadeLocal {

    void create(DomicilioProvee domicilioProvee);

    void edit(DomicilioProvee domicilioProvee);

    void remove(DomicilioProvee domicilioProvee);

    DomicilioProvee find(Object id);

    List<DomicilioProvee> findAll();

    List<DomicilioProvee> findRange(int[] range);

    int count();
    
}
