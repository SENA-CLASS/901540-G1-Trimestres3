/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.asdf.asdf.asdf.eadd;

import edu.asdf.asdf.asdf.ItemCarrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hernando
 */
@Local
public interface ItemCarritoFacadeLocal {

    void create(ItemCarrito itemCarrito);

    void edit(ItemCarrito itemCarrito);

    void remove(ItemCarrito itemCarrito);

    ItemCarrito find(Object id);

    List<ItemCarrito> findAll();

    List<ItemCarrito> findRange(int[] range);

    int count();
    
}
