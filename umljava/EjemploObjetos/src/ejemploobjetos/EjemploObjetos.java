/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploobjetos;

import edu.co.sena.ejemploobjetos.A;
import edu.co.sena.ejemploobjetos.B;
import java.io.CharConversionException;

/**
 *
 * @author hernando
 */
public class EjemploObjetos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArithmeticException, CharConversionException{
        A a = new A();
        System.out.println(a.AA);
        
        System.out.println(a.BB);
        
        System.out.println(B.A);
        try {
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Throwable e){
            System.out.println(e.getMessage());
        }

         System.out.println(10/0);

        
        
        System.out.println("hola mundo");
    }
    
}
