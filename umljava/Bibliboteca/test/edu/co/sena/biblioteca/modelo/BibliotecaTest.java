/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.biblioteca.modelo;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hernando
 */
public class BibliotecaTest {
    
    Libro l1;
    Prestamo p1;
    Factura f1;
    Persona persona1;
    
    public BibliotecaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    l1 = new Libro();
    l1.setIdLibro("3452352");
    l1.setNombreLibro("don quijote");
    l1.setEditorial("Anaya");
    l1.setDescripcion("libro xxx");
    l1.setPrecioPrestamo(1500);
    
    p1 = new Prestamo();
    p1.setCantidad(2);
    p1.setLibroPrestado(l1);
    p1.setTotal(p1.getLibroPrestado().getPrecioPrestamo()*p1.getCantidad());
    
    f1 = new Factura();
    f1.agregarPrestamo(p1);
    f1.agregarPrestamo(p1);
    f1.agregarPrestamo(p1);
    f1.agregarPrestamo(p1);
    f1.setFecha(new Date());
    f1.setNumeroFatura(1);
    
    persona1 = new Persona();
    persona1.agregarFactura(f1);
    persona1.setNumeroDocumento("3545345");
    persona1.setNombres("hernando");
    persona1.setApellidos("Moreno Moreno");
    persona1.setTipoDocumento("CC");
    
    
    
    
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void pruebaLibro() {
    Libro l1 = new Libro();
    l1.setIdLibro("3452352");
    l1.setNombreLibro("don quijote");
    l1.setEditorial("Anaya");
    l1.setDescripcion("libro xxx");
    l1.setPrecioPrestamo(1500);
    
    System.out.println(l1.toString());
    
    }
    
    @Test
    public void pruebaFinal(){
        System.out.println("Nombre Clinte "+ persona1.getNombres() );
        System.out.println("apellido Clinte "+ persona1.getApellidos() );
        List<Factura> fac = persona1.getFacturas();
        
        for (Factura fac1 : fac) {
            System.out.println("numero factura "+ fac1.getNumeroFatura());
            System.out.println("fecha factura "+ fac1.getFecha());
            System.out.println("total factura "+ fac1.getTotal());
            
            List<Prestamo> pre = fac1.getPrestamos();
            
            for (Prestamo pre1 : pre) {
                System.out.println(""+pre1.getLibroPrestado().getNombreLibro());
                System.out.println(""+pre1.getLibroPrestado().getIdLibro());
                System.out.println(""+pre1.getLibroPrestado().getEditorial());
                System.out.println("Cantidad "+pre1.getCantidad());
                System.out.println("total de este libro "+pre1.getTotal());
            }
            
        }
    
    }
    
    
}
