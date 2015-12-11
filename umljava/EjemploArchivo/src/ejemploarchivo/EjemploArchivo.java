/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploarchivo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author hernando
 */
public class EjemploArchivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perro p1 = new Perro();
        p1.setNombre("rintintin");
        p1.setRaza("chiguagua");
        
        try (FileOutputStream fos = new FileOutputStream("ejemplo.txt");
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(p1);
            
            System.out.println ("el objeo fue guardado correctamente");
        } catch (IOException i) {
            System.out.println("error al guardar el archivo: " + i);
        }
        Perro p2 = new Perro();
        try (FileInputStream fis = new FileInputStream("ejemplo.txt");
                ObjectInputStream in = new ObjectInputStream(fis)) {
            p2 = (Perro) in.readObject();
            
            System.out.println ("el objeo fue leido correctamente");
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("error al abrir el archivo: " + i);
        }
        
        System.out.println(p2.getNombre());
        System.out.println(p2.getRaza());
        
        
    }
    
}
