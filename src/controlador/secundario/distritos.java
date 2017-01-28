package controlador.secundario;

import controlador.coneccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class distritos {

    coneccion con = new coneccion();
    PreparedStatement pst;
    ResultSet rs;
    String sql;

    private String departamento;
    
    public void llenarDistrito(JComboBox dis) {
        try {
            sql = "SELECT distrito FROM tDistrito WHERE idDepartamento=\n"
                    + "(SELECT idDepartamento FROM tDepartamento WHERE departamento=?)\n"
                    + "ORDER BY distrito";
            pst = con.ObtenerConeccion().prepareStatement(sql);
            pst.setString(1, getDepartamento());
            rs = pst.executeQuery();
            dis.removeAllItems();
            while (rs.next()) {
                dis.addItem(rs.getString("distrito"));              
            }            
        } catch (Exception e) {
            System.out.println("error en controlador.secundario.distrito.llenarDistrito()... "+e);

        }
    }

    public void llenarDepartamento(JComboBox dep) {

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
}
