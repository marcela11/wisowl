package dao;

import dto.AsignaturaDTO;
import dto.NotaDTO;
import dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import utilidades.Conexion;

/**
 *
 * @author negro
 */
public class NotaDAO {

    public NotaDAO() {
        cnn = Conexion.getInstance();
    }

    Connection cnn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    CallableStatement cllstmt;
    private int resultado = 0;

    public String insertarTotal(float nota1, float nota2, float nota3) {
        int salida = 0;

        String mensaje = " ";
        try {
            String procedureOrder = "{call sp_totalNota(?,?,?,?);}";
            cllstmt = cnn.prepareCall(procedureOrder);
            cllstmt.setFloat(1, nota1);
            cllstmt.setFloat(2, nota2);
            cllstmt.setFloat(3, nota3);
            cllstmt.registerOutParameter(4, java.sql.Types.INTEGER);
            cllstmt.execute();
            salida = cllstmt.getInt(4);
            if (salida == -1) {
                mensaje = "No ha ocurrido nada en la base de datos";
            } else if (salida == 1) {
                mensaje = "La base de datos obtuvo el registro sactisfactoriamente!";
            } else {
                mensaje = "Something was wrong!!";
            }
        } catch (SQLException sqle) {
            mensaje = "Ha ocurrido la siguiente excepción " + sqle.getMessage();
        }
        return mensaje;
    }

    public LinkedList<NotaDTO> listarNotas() {
        LinkedList<NotaDTO> resultadoNota = new LinkedList();
        try {
            String sql = " SELECT usuarios.idUsuario, concat(usuarios.primerApellido,' ',usuarios.segundoApellido,' '," +
"                     usuarios.primerNombre,' ',usuarios.segundoNombre) as Estudiante, notas.idnota, " +
"                     notas.nota1  , notas.nota2, notas.nota3,notas.fechaNota as FechaRegistro," +
"                     format(avg((notas.nota1*0.5) +(notas.nota2*0.3)+ (notas.nota3*0.2)/3),1) as total , notas.observacion as obs" +
"                     FROM usuarios inner join notas on usuarios.idUsuario=notas.idEstudiante" +
"                     GROUP BY  usuarios.idUsuario; ";
            pst = cnn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioDTO user = new UsuarioDTO();
                    user.setIdUsuario(rs.getString("idUsuario"));
                    user.setPrimerApellido(rs.getString("Estudiante"));
                    NotaDTO nodto = new NotaDTO();
                    nodto.setIdEstudiante(user);
                    nodto.setIdNota(rs.getInt("idnota"));
                    nodto.setNota1(rs.getFloat("nota1"));
                    nodto.setNota2(rs.getFloat("nota2"));
                    nodto.setNota3(rs.getFloat("nota3"));
                    nodto.setTotal(rs.getFloat("total"));
                    nodto.setFechaNota(rs.getString("FechaRegistro"));
                    nodto.setObservacion(rs.getString("obs"));
                    resultadoNota.add(nodto);
                }
            } else {
                System.out.println("No se encuetran registros ... ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultadoNota;
    }

    public NotaDTO listarbyId(long idUsuario) {
        NotaDTO not = null;
        try {
            String sqle = " SELECT idUsuario,concat(primerApellido,' ',segundoApellido,' ', "
                    + " primerNombre,' ',segundoNombre) as Estudiante, idnota,"
                    + " nota1, nota2, nota3, "
                    + " format (avg((nota1*0.5) +(nota2*0.3)+ (nota3*0.2)/3),2 ) as total, "
                    + " fechaNota, observacion "
                    + " FROM usuarios u inner join notas n on u.idUsuario=n.idEstudiante "
                    + " where u.idUsuario= ?;";
            pst = cnn.prepareStatement(sqle);
            pst.setLong(1, idUsuario);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    UsuarioDTO user = new UsuarioDTO(rs.getString("idUsuario"), rs.getString("Estudiante"));
                    not = new NotaDTO(user);
                    not.setIdNota(rs.getInt("idnota"));
                    not.setNota1(rs.getFloat("nota1"));
                    not.setNota2(rs.getFloat("nota2"));
                    not.setNota3(rs.getFloat("nota3"));
                    not.setTotal(rs.getFloat("total"));
                    not.setFechaNota(rs.getString("fechaNota"));
                    not.setObservacion(rs.getString("observacion"));
                }
            } else {
                System.out.println("No se encuetran registros ... ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return not;
    }

    public LinkedList<NotaDTO> listarReportePer(int idPer) throws SQLException {
        LinkedList<NotaDTO> notas = new LinkedList();
        try {
            String query = "SELECT asignaturas.Descripcion as Descripcion,"
                    + " notas.nota1  as Cognitivo, notas.nota2 as Procedimental, notas.nota3 as Actitudinal,notas.fechaNota as FechaRegistro,"
                    + " format(avg((notas.nota1*0.5) +(notas.nota2*0.3)+ (notas.nota3*0.2)/3),1 )as total , notas.observacion as obs"
                    + " FROM asignaturas inner join asig_per on asignaturas.idAsignatura=asig_per.idAsig inner join notas on asig_per.idAsigPer=notas.idAsigPe"
                    + " WHERE asig_per.idPer=? GROUP BY  asignaturas.idAsignatura ;";
            pst = cnn.prepareStatement(query);
            pst.setInt(1, idPer);
            rs = pst.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    AsignaturaDTO adto = new AsignaturaDTO();
                    adto.setDescripcion(rs.getString("Descripcion"));
                    NotaDTO ndto = new NotaDTO(adto);
                    ndto.setNota1(rs.getFloat("Cognitivo"));
                    ndto.setNota2(rs.getFloat("Procedimental"));
                    ndto.setNota3(rs.getFloat("Actitudinal"));
                    ndto.setTotal(rs.getFloat("Total"));
                    ndto.setFechaNota(rs.getString("FechaRegistro"));
                    ndto.setObservacion(rs.getString("obs"));
                    notas.add(ndto);
                }
            }
        } catch (SQLException re) {
            System.out.println("Ha ocurrido una excepcion" + re.getMessage() + "  " + re.getSQLState());
        }
        return notas;
    }

    public LinkedList<NotaDTO> listarReporteAct() {
        LinkedList<NotaDTO> resultado = new LinkedList();
        try {
            String sql = "   SELECT asignaturas.Descripcion as Descripcion,\n"
                    + "                      notas.nota1  as Cognitivo, notas.nota2 as Procedimental, notas.nota3 as Actitudinal,notas.fechaNota as FechaRegistro,\n"
                    + "                      avg((notas.nota1*0.5) +(notas.nota2*0.3)+ (notas.nota3*0.2)/3) as total , notas.observacion as obs\n"
                    + "                     FROM  asignaturas inner join asig_per on asignaturas.idAsignatura=asig_per.idAsig inner join notas on asig_per.idAsigPer=notas.idAsigPe\n"
                    + "                     GROUP BY  asignaturas.idAsignatura ;";
            pst = cnn.prepareStatement(sql);
//            pst.setDate(1, fechaNota);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    AsignaturaDTO asig = new AsignaturaDTO();
                    NotaDTO nodto = new NotaDTO();
                    asig.setDescripcion(rs.getString("Descripcion"));
                    nodto.setIdAsigna(asig);
                    nodto.setNota1(rs.getFloat("Cognitivo"));
                    nodto.setNota2(rs.getFloat("Procedimental"));
                    nodto.setNota3(rs.getFloat("Actitudinal"));
                    nodto.setFechaNota(rs.getString("FechaRegistro"));
                    nodto.setTotal(rs.getFloat("total"));
                    resultado.add(nodto);
                }
            } else {
                System.out.println("No se encuentran los registros ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultado;
    }

    public String insertarNota(NotaDTO neNota) {
        String sal = "";
        int res = 0;
        try {

            pst = cnn.prepareStatement("INSERT INTO notas VALUES (null,?,?,?,?,?,4,null,?);");
            pst.setString(1, neNota.getFechaNota());
            pst.setFloat(2, neNota.getNota1());
            pst.setFloat(3, neNota.getNota2());
            pst.setFloat(4, neNota.getNota3());
            pst.setString(5, neNota.getIdEstu());
            pst.setString(6, neNota.getObservacion());
            res = pst.executeUpdate();
            if (res != 0) {
                sal = "Nota registrada exitosamente" + resultado + "filas afectadas";
            } else {
                sal = "Ha ocurrido un problema ";
            }
        } catch (SQLException sql) {
            sal = "Ha ocurrido lo sig.. " + sql.getMessage();
        }
        return sal;
    }

    public String modificarNota(NotaDTO newNota) throws SQLException {
        String fuera = "";
        int res = 0;
        try {
            pst = cnn.prepareStatement("UPDATE notas SET fechaNota=?,nota1=?, nota2=?,nota3=?,observacion=? where idNota=?;");
            pst.setString(1, newNota.getFechaNota());
            pst.setFloat(2, newNota.getNota1());
            pst.setFloat(3, newNota.getNota2());
            pst.setFloat(4, newNota.getNota3());
//            pst.setFloat(5, 23);
            pst.setString(5, newNota.getObservacion());
            pst.setInt(6, newNota.getIdNota());

            res = pst.executeUpdate();
            if (res != 0) {
                fuera = "Nota actualizada";
            } else {
                fuera = "Error al actualizar la nota";
            }

        } catch (SQLException sqle) {
            System.out.println("Error en la base de datos" + sqle.getSQLState() + "y" + sqle.getMessage());
        }
        return fuera;

    }

//    public String eliminarNota(int idNota, Date fechaNota) throws SQLException {
//        String salida = "";
//        int po = 0;
//        try {
//            pst = cnn.prepareStatement("DELETE FROM notas where idNota=? AND fechaNota='?';");
//            pst.setInt(1, idNota);
//            pst.setDate(2, fechaNota);
//            po = pst.executeUpdate();
//            if (po != 0) {
//                salida = "Registro " + po + "eliminado exitosamente";
//            }
//        } catch (SQLException ex) {
//            salida = "Ha ocurrido una excepcion" + ex.getMessage();
//        }
//        return salida;
//
//    }
    
    
     public String eliminarNota(int idNota) throws SQLException {
        String salida = "";
        int po = 0;
        try {
            pst = cnn.prepareStatement("DELETE FROM notas where idNota=?;");
            pst.setInt(1, idNota);
            po = pst.executeUpdate();
            if (po != 0) {
                salida = "Nota eliminada";
            }else{
                salida="no se pudo eliminar";
            }
        } catch (SQLException ex) {
            salida = "Ha ocurrido una excepcion" + ex.getMessage();
        }
        return salida;

    }
}
