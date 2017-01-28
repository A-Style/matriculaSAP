package controlador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class selDocumentos {

    private String dniAlumno;
    private int anioMatricula;

    coneccion con = new coneccion();
    PreparedStatement pst;
    CallableStatement cst;
    ResultSet rs;
    String query;

//    int reqDniAlu = 0;
//    int reqDniApo = 0;
//    int reqCert = 0;
//    int reqBoleta = 0;
//    int reqPartNacimiento = 0;
//    int reqFotos = 0;
//    int reqRecibos = 0;
    public void seleccionarFecha(JComboBox fecha) {
        try {
            query = "SELECT DISTINCT YEAR(fecha) FROM tMatricula WHERE idAlumno=(SELECT idAlumno FROM tAlumno WHERE dni=?)";
            pst = con.ObtenerConeccion().prepareStatement(query);
            pst.setString(1, getDniAlumno());
            rs = pst.executeQuery();
            fecha.removeAllItems();
            while (rs.next()) {
                fecha.addItem(rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println("error controlador.selDocumentos.seleccionarFecha()...  " + e);

        }
    }

    public void llenarTablaDocumentos(JTable tabla) {

        try {
            query = " select req.copiaDniAlu,req.copiaDniApo,req.certificadoEstudio,req.fichaBoleta,req.partNacimiento,req.fotos,req.recibos\n"
                    + "  from tRequisitos req inner join tMatricula mat \n"
                    + "  on req.idMatricula=mat.idMatricula where year(mat.fecha)=? and idAlumno=(SELECT idAlumno FROM tAlumno WHERE dni=?)";
            pst = con.ObtenerConeccion().prepareStatement(query);
            pst.setInt(1, getAnioMatricula());
            pst.setString(2, getDniAlumno());
            rs = pst.executeQuery();
            DefaultTableModel tab = new DefaultTableModel();
            tab.addColumn("DOCUMENTO");
            tab.addColumn("ESTADO");
            tab.addColumn("OBSERVACION");
            if (rs.next()) {

                Object v[] = new Object[3];

                //Fila 1---------------
                v[0] = "Copia DNI Alumno";
                if (rs.getInt(1) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 2---------------
                v[0] = "Copia DNI Apoderado";
                if (rs.getInt(2) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 3---------------
                v[0] = "Certificado de Estudios";
                if (rs.getInt(3) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 4---------------
                v[0] = "Ficha de Matricula / Boleta de Notas";
                if (rs.getInt(4) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 5---------------
                v[0] = "Partida de Nacimiento";
                if (rs.getInt(5) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 6---------------
                v[0] = "2 Fotos Tamaño Carnet";
                if (rs.getInt(6) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

                //Fila 7---------------
                v[0] = "Recibo de Luz o Agua";
                if (rs.getInt(7) == 1) {
                    v[1] = "Entregado";
                } else {
                    v[1] = "Falta";
                }
                v[2] = " - ";
                tab.addRow(v);

            }
            tabla.setModel(tab);

            tabla.getColumnModel().getColumn(0).setPreferredWidth(250);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
        } catch (Exception e) {
            System.out.println("error controlador.selDocumentos.llenarTablaDocumentos()..." + e);
        }

    }

    public void actualizarDocumentos(String dni,int anio,int requisito,int valor) {
        try {
            query = "call actualizarRequisitos(?,?,?,?)";
            cst = con.ObtenerConeccion().prepareCall(query);
            cst.setString(1, dni);
            cst.setInt(2, anio);
            cst.setInt(3, requisito);
            cst.setInt(4, valor);
            cst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Documento Actualizado");
        } catch (Exception e) {
            System.out.println("error controlador.selDocumentos.actualizarDocumentos()... " + e);
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
     * @return the anioMatricula
     */
    public int getAnioMatricula() {
        return anioMatricula;
    }

    /**
     * @param anioMatricula the anioMatricula to set
     */
    public void setAnioMatricula(int anioMatricula) {
        this.anioMatricula = anioMatricula;
    }

}
