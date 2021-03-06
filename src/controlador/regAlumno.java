/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.util.Date;
import javax.swing.JOptionPane;

public class regAlumno {

    coneccion con=new coneccion();
    private String nom;
    private String apPat;
    private String apMat;
    private String dniAlumno;
    private String fechaNac;
    private String dniEmpleado;
    
    private String antiguoDniAlumno;
    
    CallableStatement cst;
     String query;
     
    public void registrarAlumno(){
        try {
            query="CALL registroAlumno(?,?,?,?,?,?);";
            cst=con.ObtenerConeccion().prepareCall(query);
            cst.setString(1, getNom());
            cst.setString(2, getApPat());
            cst.setString(3, getApMat());
            cst.setString(4, getDniAlumno());
            cst.setString(5,  getFechaNac());
            cst.setString(6, getDniEmpleado());
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alumno Registrado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de Registro");
            System.out.println("Error en controlador.regAlumno  registrarAlumno()..."+e);
        }
    }
    
    public void actualizarAlumno(){
     try {
            query="CALL actualizarAlumno(?,?,?,?,?,?);";
            cst=con.ObtenerConeccion().prepareCall(query);
            cst.setString(1, getNom());
            cst.setString(2, getApPat());
            cst.setString(3, getApMat());
            cst.setString(4, getDniAlumno());
            cst.setString(5,  getFechaNac());
            cst.setString(6, getAntiguoDniAlumno());
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion Completada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
            System.out.println("Error en controlador.regAlumno.actualizarAlumno()... "+e);
        }
    }
    
    

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the apPat
     */
    public String getApPat() {
        return apPat;
    }

    /**
     * @param apPat the apPat to set
     */
    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    /**
     * @return the apMat
     */
    public String getApMat() {
        return apMat;
    }

    /**
     * @param apMat the apMat to set
     */
    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    /**
     * @return the dniAlumno
     */
    public String getDniAlumno() {
        return dniAlumno;
    }

    /**
     * @param dniAlumno the dniAlumno to set
     */
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

   

    /**
     * @return the dniEmpleado
     */
    public String getDniEmpleado() {
        return dniEmpleado;
    }

    /**
     * @param dniEmpleado the dniEmpleado to set
     */
    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    /**
     * @return the fechaNac
     */
    public String getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the antiguoDniAlumno
     */
    public String getAntiguoDniAlumno() {
        return antiguoDniAlumno;
    }

    /**
     * @param antiguoDniAlumno the antiguoDniAlumno to set
     */
    public void setAntiguoDniAlumno(String antiguoDniAlumno) {
        this.antiguoDniAlumno = antiguoDniAlumno;
    }


 
}
