

package controlador;

import java.sql.CallableStatement;
import javax.swing.JOptionPane;


public class regMatricula {
    coneccion con=new coneccion();
    
    private int nivel;
    private int anio;
    private String seccion;
    private String procedencia;
    private String dniEmpleado;
    private String dniAlumno;
    
    private int reqDniAlu;
    private int reqDniApo;
    private int reqCert;
    private int reqBoleta;
    private int reqPartida;
    private int reqFotos;
    private int reqRecibos;
    
    
    CallableStatement cst;
    String query;
    
    public void regMatricular(){
        try {
            query="call Matricula(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            cst=con.ObtenerConeccion().prepareCall(query);
            cst.setInt(1, getNivel());
            cst.setInt(2, getAnio());
            cst.setString(3, getSeccion());
            cst.setString(4, getProcedencia());
            cst.setString(5, getDniEmpleado());
            cst.setString(6, getDniAlumno());
            cst.setInt(7, getReqDniAlu());
            cst.setInt(8, getReqDniApo());
            cst.setInt(9, getReqCert());
            cst.setInt(10, getReqBoleta());
            cst.setInt(11, getReqPartida());
            cst.setInt(12, getReqFotos());
            cst.setInt(13, getReqRecibos());
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Matricula Completa");
        } catch (Exception e) {            
            JOptionPane.showMessageDialog(null, "No se Pudo Matricular");
            System.out.println("error en controlador.matricula.regMatricular()... "+e);
        }
    }

    
    
    
    
    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the anio
     */
    public int getAnio() {
        return anio;
    }

    /**
     * @param anio the anio to set
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    
    /**
     * @return the procedencia
     */
    public String getProcedencia() {
        return procedencia;
    }

    /**
     * @param procedencia the procedencia to set
     */
    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
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
     * @return the reqDniAlu
     */
    public int getReqDniAlu() {
        return reqDniAlu;
    }

    /**
     * @param reqDniAlu the reqDniAlu to set
     */
    public void setReqDniAlu(int reqDniAlu) {
        this.reqDniAlu = reqDniAlu;
    }

    /**
     * @return the reqDniApo
     */
    public int getReqDniApo() {
        return reqDniApo;
    }

    /**
     * @param reqDniApo the reqDniApo to set
     */
    public void setReqDniApo(int reqDniApo) {
        this.reqDniApo = reqDniApo;
    }

    /**
     * @return the reqCert
     */
    public int getReqCert() {
        return reqCert;
    }

    /**
     * @param reqCert the reqCert to set
     */
    public void setReqCert(int reqCert) {
        this.reqCert = reqCert;
    }

    /**
     * @return the reqBoleta
     */
    public int getReqBoleta() {
        return reqBoleta;
    }

    /**
     * @param reqBoleta the reqBoleta to set
     */
    public void setReqBoleta(int reqBoleta) {
        this.reqBoleta = reqBoleta;
    }

    /**
     * @return the reqPartida
     */
    public int getReqPartida() {
        return reqPartida;
    }

    /**
     * @param reqPartida the reqPartida to set
     */
    public void setReqPartida(int reqPartida) {
        this.reqPartida = reqPartida;
    }

    /**
     * @return the reqFotos
     */
    public int getReqFotos() {
        return reqFotos;
    }

    /**
     * @param reqFotos the reqFotos to set
     */
    public void setReqFotos(int reqFotos) {
        this.reqFotos = reqFotos;
    }

    /**
     * @return the reqRecibos
     */
    public int getReqRecibos() {
        return reqRecibos;
    }

    /**
     * @param reqRecibos the reqRecibos to set
     */
    public void setReqRecibos(int reqRecibos) {
        this.reqRecibos = reqRecibos;
    }

    /**
     * @return the seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion the seccion to set
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
