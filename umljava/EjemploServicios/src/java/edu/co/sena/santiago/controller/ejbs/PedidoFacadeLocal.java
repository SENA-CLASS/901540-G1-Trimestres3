/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.santiago.controller.ejbs;

import edu.co.sena.santiago.modelo.entites.Pedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hernando
 */
@Local
public interface PedidoFacadeLocal {

    void create(Pedido pedido);

    void edit(Pedido pedido);

    void remove(Pedido pedido);

    Pedido find(Object id);

    List<Pedido> findAll();

    List<Pedido> findRange(int[] range);

    int count();
    
}
