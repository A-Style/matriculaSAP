
package controlador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class regPadres {
    
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String dniPadre;
    private String fechaNac;
    private String direccion;
    private String telFijo;
    private String celular;
    private String nEmergencia;
    private String email;
    
    private String dniEmpleado;
    
    private String departamento;
    private String distrito;
    private String parentesco;
    private String dniAlumno;
    private int apoderado;
    
    private String dniAntiguoPadre;
    
    PreparedStatement pst;
    CallableStatement cst;
    
    String query;
    
    coneccion con=new coneccion();
    public void registroPadres(){
        try {
            query="call registroPadres(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            cst=con.ObtenerConeccion().prepareCall(query);
            cst.setString(1, getNombre());
            cst.setString(2, getApPaterno());
            cst.setString(3, getApMaterno());
            cst.setString(4, getDniPadre());
            cst.setString(5, getFechaNac());
            cst.setString(6, getDireccion());
            cst.setString(7, getTelFijo());
            cst.setString(8, getCelular());
            cst.setString(9, getnEmergencia());
            cst.setString(10, getEmail());
            cst.setString(11, getDniEmpleado());
            cst.setString(12, getDepartamento());
            cst.setString(13, getDistrito());
            cst.setString(14, getParentesco());
            cst.setString(15, getDniAlumno());
            cst.setInt(16, getApoderado());
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Completado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo Registrar, porfavor comuniquese con su proveedor");
            System.out.println("Error en controlador.regPadres.registroPadres()..."+e);
        }
    }
    
      public void actualizarPadres(){
     try {
            query="CALL actualizarPadres(?,?,?,?,?,?,?,?,?,?,?);";
            cst=con.ObtenerConeccion().prepareCall(query);
            cst.setString(1, getNombre());
            cst.setString(2, getApPaterno());
            cst.setString(3, getApMaterno());
            cst.setString(4, getDniPadre());
            cst.setString(5, getFechaNac());
            cst.setString(6, getDireccion());
            cst.setString(7, getTelFijo());
            cst.setString(8, getCelular());
            cst.setString(9, getnEmergencia());
            cst.setString(10, getEmail());
            cst.setString(11, getDniAntiguoPadre());
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Actualizacion Completada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
            System.out.println("Error en controlador.regAlumno.actualizarAlumno()... "+e);
        }
    }
    
    
    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apPaterno
     */
    public String getApPaterno() {
        return apPaterno;
    }

    /**
     * @param apPaterno the apPaterno to set
     */
    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    /**
     * @return the apMaterno
     */
    public String getApMaterno() {
        return apMaterno;
    }

    /**
     * @param apMaterno the apMaterno to set
     */
    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    /**
     * @return the dniPadre
     */
    public String getDniPadre() {
        return dniPadre;
    }

    /**
     * @param dniPadre the dniPadre to set
     */
    public void setDniPadre(String dniPadre) {
        this.dniPadre = dniPadre;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telFijo
     */
    public String getTelFijo() {
        return telFijo;
    }

    /**
     * @param telFijo the telFijo to set
     */
    public void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * @return the distrito
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @param distrito the distrito to set
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     * @return the parentesco
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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
     * @return the apoderado
     */
    public int getApoderado() {
        return apoderado;
    }

    /**
     * @param apoderado the apoderado to set
     */
    public void setApoderado(int apoderado) {
        this.apoderado = apoderado;
    }

    /**
     * @return the nEmergencia
     */
    public String getnEmergencia() {
        return nEmergencia;
    }

    /**
     * @param nEmergencia the nEmergencia to set
     */
    public void setnEmergencia(String nEmergencia) {
        this.nEmergencia = nEmergencia;
    }

    /**
     * @return the dniAntiguoPadre
     */
    public String getDniAntiguoPadre() {
        return dniAntiguoPadre;
    }

    /**
     * @param dniAntiguoPadre the dniAntiguoPadre to set
     */
    public void setDniAntiguoPadre(String dniAntiguoPadre) {
        this.dniAntiguoPadre = dniAntiguoPadre;
    }

   
}
