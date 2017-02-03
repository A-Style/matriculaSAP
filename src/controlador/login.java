package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class login {

    coneccion con = new coneccion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    private String user;
    private String pass;

    public Boolean ingresar() {
        Boolean rpt = false;
        try {
            sql = "SELECT idEmpleado FROM tEmpleado WHERE dni=? AND pass=?";
            pst = con.ObtenerConeccion().prepareStatement(sql);
            pst.setString(1, getUser());
            pst.setString(2, getPass());
            rs = pst.executeQuery();
            if (rs.next()) {
                rpt = true;
            } else {
                rpt = false;
            }
            return rpt;
        } catch (SQLException ex) {
            System.out.println("error en controlador.login.ingresar()... "+ex);
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rpt;
    }

    public String nomCompletoEmpleado() {
        String nom = "";
        try {
            sql = "select concat(nombre,' ',apPaterno,' ',apMaterno) from tEmpleado where dni=? and pass=? ";
            pst = con.ObtenerConeccion().prepareStatement(sql);
            pst.setString(1, getUser());
            pst.setString(2, getPass());
            rs = pst.executeQuery();
            while (rs.next()) {
                nom = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("Error en login.nomCompletoEmpleado()... "+ e);
        }
        return nom;
    }

    public String idEmpleado() {
        String id = "";
        try {
            sql = "select idEmpleado from tEmpleado where dni=? and pass=?";
            pst = con.ObtenerConeccion().prepareStatement(sql);
            pst.setString(1, getUser());
            pst.setString(2, getPass());
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("error en login.idEmpleado()... "+e);
        }
        return id;
    }

   

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

}
