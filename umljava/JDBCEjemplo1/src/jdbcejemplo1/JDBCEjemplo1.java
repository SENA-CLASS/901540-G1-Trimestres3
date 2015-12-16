/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcejemplo1;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hernando
 */
public class JDBCEjemplo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
       java.sql.Connection conexion = null;
       
       
        String urlServidor = "jdbc:mysql://localhost:3306/tienda_online2";
            String usuarioDB="root";
            String passwordDB="123456789";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion= DriverManager.getConnection(urlServidor,usuarioDB,passwordDB);
            System.out.println("se conecto");
            conexion.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e.toString());
        }finally{
            if (conexion!=null) {
                conexion.close();
                System.out.println("se cerro la conexion correctamente");
            }
        
        }
        
        
    }
    
}
