/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.biblioteca.modelo;

/**
 *
 * @author hernando
 */
public class Prestamo {
    
    private int cantidad;
    private Libro libroPrestado;
    private double total;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Libro getLibroPrestado() {
        return libroPrestado;
    }

    public void setLibroPrestado(Libro libroPrestado) {
        this.libroPrestado = libroPrestado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
