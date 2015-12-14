/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carguearchivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hernando
 */
public class CargueArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         FileReader archivo = null;
         BufferedReader br = null;
            
        try {
            archivo = new FileReader("ejemplo.txt");
            br = new BufferedReader(archivo);
            String linea ;
            while((linea= br.readLine())!=null) {
                StringTokenizer tokens = new StringTokenizer(linea, "|");
                int con =1;
                Persona pt = new Persona();
                while (tokens.hasMoreTokens()) {
                    String t = tokens.nextToken();
                    if(t.equals("null")){
                        t=null;
                    }
                    
                   
                   switch(con){
                       case 1:
                       pt.setPrimerNombre(t);
                       break;
                       case 2:
                       pt.setSegundoNombre(t);
                       break;
                       case 3:
                       pt.setPrimerApellido(t);
                       break;
                       case 4:
                       pt.setSegundoApellido(t);
                       break;
                       case 5:
                       pt.setTipoDocumento(t);
                       break;
                       case 6:
                       pt.setNumeroDocumento(t);
                       break;
                      
                           
                   
                   
                   }
                    con++;
                }
                System.out.println(pt.toString());
            }
            
        } catch (FileNotFoundException   ex) {
            System.out.println(ex);
        } catch (IOException e2){
            System.out.println(e2);
        }
            
    }
    
}
