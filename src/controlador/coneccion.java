
package controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class coneccion {
    
     public Connection ObtenerConeccion(){
    Connection cn=null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");            
            //cn= DriverManager.getConnection("jdbc:mysql://107.180.57.169/matriculaSAP","userMatricula","@erpMatricula");//Hosting Godaddy Economico    
            cn= DriverManager.getConnection("jdbc:mysql://107.180.48.91/matriculaSAP","userMatricula","@erpMatricula");//Hosting Godaddy Deluxe
            
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.out.println("error en coneccion.ObtenerConeccion()... "+e);
        }
    
    return cn;
    }
}
