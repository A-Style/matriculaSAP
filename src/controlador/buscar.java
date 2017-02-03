package controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jclist.jcList;

public class buscar {

    coneccion con = new coneccion();

    private String dniAlumno;
    private String parentesco;
    String query;

    PreparedStatement pst;
    ResultSet rs;

    public void buscarAlumno(JTextField nom, JTextField apPat, JTextField apMat, JTextField dni, JDateChooser fecha) {
        try {
            query = "SELECT nombre,apPaterno,apMaterno,dni,fecnacimiento FROM tAlumno WHERE dni=?";
            pst = con.ObtenerConeccion().prepareStatement(query);
            pst.setString(1, getDniAlumno());
            rs = pst.executeQuery();
            if (rs.next()) {
                //while (rs.next()) {
                nom.setText(rs.getString(1));
                nom.setForeground(Color.blue);
                apPat.setText(rs.getString(2));
                apPat.setForeground(Color.blue);
                apMat.setText(rs.getString(3));
                apMat.setForeground(Color.blue);
                dni.setText(rs.getString(4));
                dni.setForeground(Color.blue);
                fecha.setDate(rs.getDate(5));
                //}
            } else {
                nom.setText("No Registrado");
                nom.setForeground(Color.red);
                apPat.setText("No Registrado");
                apPat.setForeground(Color.red);
                apMat.setText("No Registrado");
                apMat.setForeground(Color.red);
                dni.setText("No Registrado");
                dni.setForeground(Color.red);

            }

        } catch (Exception e) {
            System.out.println("error en BuscarAlumno " + e);
        }
    }

    public void listaPadres(jcList lista) {
        try {
            query = "select parentesco from tParentesco where idAlumno=(SELECT idAlumno FROM tAlumno WHERE dni=?)";
            pst = con.ObtenerConeccion().prepareStatement(query);
            pst.setString(1, getDniAlumno());
            rs = pst.executeQuery();

            DefaultListModel lis = new DefaultListModel();

            while (rs.next()) {
                lis.addElement(rs.getString(1));
                
            }
            lista.setModel(lis);
        } catch (Exception e) {
            System.out.println("error en controlador.buscar.listaPadres()... " + e);
        }
    }

    public void datosPadres(JTextField nom, JTextField paterno, JTextField materno, JTextField dni, JDateChooser fecha,JTextField email,JTextField telFijo,JTextField cel,JTextField nEmergencia,JComboBox cboDepartamento,JComboBox cboDistrito,JTextField dir,JLabel apoderado) {
        try {
            query = "SELECT pa.nombre,pa.apPaterno,pa.apMaterno,pa.dni,pa.fecNacimiento,pa.email,pa.telFijo,pa.celular,pa.numEmergencia,dis.distrito,dep.departamento,pa.direccion,\n"
                    + "CASE  par.apoderado \n"
                    + "WHEN 1 THEN\n"
                    + "'Apoderado'\n"
                    + "WHEN 0 THEN\n"
                    + "'-'\n"
                    + "END 'apoderado'\n"
                    + " \n"
                    + " FROM tPadres pa INNER JOIN tParentesco par ON pa.idPadre=par.idPadre\n"
                    + " INNER JOIN tAlumno alu ON par.idAlumno=alu.idAlumno\n"
                    + " INNER JOIN tDistrito dis ON pa.idDistrito=dis.idDistrito\n"
                    + " INNER JOIN tDepartamento dep ON dis.idDepartamento=dep.idDepartamento\n"
                    + " WHERE alu.dni=? AND par.parentesco=?";
            pst = con.ObtenerConeccion().prepareStatement(query);
            pst.setString(1, getDniAlumno());
            pst.setString(2, getParentesco());
            rs = pst.executeQuery();
            while (rs.next()) {
                nom.setText(rs.getString(1));
                paterno.setText(rs.getString(2));
                materno.setText(rs.getString(3));
                dni.setText(rs.getString(4));                
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = rs.getDate(5);
                    fecha.setDate(date);
                } catch (Exception e) {
                    System.out.println("error en formato datosPadres" + e);
                }
                email.setText(rs.getString(6));
                telFijo.setText(rs.getString(7));
                cel.setText(rs.getString(8)); 
                nEmergencia.setText(rs.getString(9)); 
                cboDistrito.setSelectedItem(rs.getString(10));
                cboDepartamento.setSelectedItem(rs.getString(11));
                dir.setText(rs.getString(12));                
                apoderado.setText(rs.getString(13));                

            }

        } catch (Exception e) {
            System.out.println("error en controlador.buscar.datosPadres()... " + e);
        }
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
}
