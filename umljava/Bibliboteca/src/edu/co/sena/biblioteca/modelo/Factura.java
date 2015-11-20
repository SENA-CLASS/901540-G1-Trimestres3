/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.biblioteca.modelo;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hernando
 */
public class Factura {
    private int numeroFatura;
    private double total;
    private double impuesto;
    private Date fecha;
    private List<Prestamo> prestamos = new ArrayList<>();
    private String descripcion;

    public void agregarPrestamo(Prestamo p){
    prestamos.add(p);
    
    }
    
    public int getNumeroFatura() {
        return numeroFatura;
    }

    public void setNumeroFatura(int numeroFatura) {
        this.numeroFatura = numeroFatura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
