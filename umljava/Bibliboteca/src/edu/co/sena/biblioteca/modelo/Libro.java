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
public class Libro {
    private String idLibro;
    private String nombreLibro;
    private double precioPrestamo;
    private String descripcion;
    private String editorial;

    public String getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(String idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public double getPrecioPrestamo() {
        return precioPrestamo;
    }

    public void setPrecioPrestamo(double precioPrestamo) {
        this.precioPrestamo = precioPrestamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" + "idLibro=" + idLibro + ", nombreLibro=" + nombreLibro + ", precioPrestamo=" + precioPrestamo + ", descripcion=" + descripcion + ", editorial=" + editorial + '}';
    }
    
    
}
