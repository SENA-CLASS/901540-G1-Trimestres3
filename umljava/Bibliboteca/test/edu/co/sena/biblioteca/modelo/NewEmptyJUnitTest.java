/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.biblioteca.modelo;

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
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("se ejecuto el beforeClass");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("se ejecuto el afterclass");
    }
    
    @Before
    public void setUp() {
        System.out.println("se ejecuto el before");
    }
    
    @After
    public void tearDown() {
        System.out.println("se ejcuto el after");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void prueba1(){
        System.out.println("se ejecuto la prueba 1");
    
    }
    
    @Test
    public void prueba2(){
        System.out.println("se ejecuto la prueba 2");
    
    }
    
}
