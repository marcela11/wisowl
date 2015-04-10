package dao;

import dto.AcudienteDTO;
import dto.CursoDTO;
import dto.EpsDTO;
import dto.RolDTO;
import dto.TelefonoDTO;
import dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import utilidades.Conexion;

public class UsuarioDAO {
    
    public UsuarioDAO() {
        cnn = Conexion.getInstance();
    }
    
    Connection cnn;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public HashMap<UsuarioDTO, String> validarUsuario(int usuario, String contraseña) {
        String menu = "<ul>";
        HashMap<UsuarioDTO, String> usuarioValidado = new HashMap<UsuarioDTO, String>();
        UsuarioDTO usudto = new UsuarioDTO();
        try {
            pst = cnn.prepareStatement("SELECT concat(usuarios.primerApellido as primApe,' ',"
                    + "usuarios.segundoApellido as seguApe,' ',usuarios.primerNombre as priNom,' ',"
                    + "usuarios.segundoNombre as seguNom),"
                    + "usuarios.idUsuario,"
                    + "usuarios.contraseña,roles.idRol as rol ,"
                    + "permisos.Descripcion "
                    + "FROM usuarios inner join"
                    + "usu_rol on Usuarios.idUsuario=usu_rol.idUsuario inner join roles"
                    + "on usu_rol.idRol=roles.idRol inner join rol_per on roles.idRol=rol_per.idRol inner join permisos"
                    + "on rol_per.idPer=permisos.idPer "
                    + "GROUP BY  roles.idRol,permisos.idPer, usuarios.idUsuario"
                    + "WHERE usuarios.idUsuario=? and contraseña=MD5(?)  ;");
            
            pst.setInt(1, usuario);
            pst.setString(2, contraseña);
            
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    
                    usudto.setPrimerApellido(rs.getString("primeApe"));
                    usudto.setSegundoApellido(rs.getString("seguApe"));
                    usudto.setPrimerNombre(rs.getString("priNom"));
                    usudto.setSegundoNombre(rs.getString("seguNom"));
                    usudto.setIdUsuario(rs.getString("id"));
                    usudto.setContraseña(rs.getString("contraseña"));
                    RolDTO rol = new RolDTO();
                    rol.setIdrol(Integer.parseInt("rol"));
                    usudto.setIdRol(0);
                    
                    menu += "<li>";
                    // menu+="<a href='"+rs.getString("url")+"'>"+rs.getString("descripcion")+"</a>";
                    menu += rs.getString("descripcion");
                    ResultSet rsSub = cnn.prepareStatement("SELECT usuarios.idUsuario as id, roles.idRol as rol ,"
                            + "                    permisos.Descripcion as per"
                            + "                    FROM usuarios inner join"
                            + "                    usu_rol on Usuarios.idUsuario=usu_rol.idUsuario inner join roles"
                            + "                    on usu_rol.idRol=roles.idRol inner join rol_per on roles.idRol=rol_per.idRol inner join permisos"
                            + "                    on rol_per.idPer=permisos.idPer"
                            + "                    GROUP BY  roles.idRol,permisos.idPer, usuarios.idUsuario "
                            + "WHERE usuarios.idUsuario=" + rs.getInt("id")
                            + "AND permisos.idPer=" + rs.getString("per")).executeQuery();
                    
                    menu += "<ul>";
                    while (rsSub.next()) {
                        menu += "<li>";
                        menu += "<a href='" + rsSub.getString("Descripcion") + "'>" + rsSub.getString("permisos.Descripcion") + "</a>";
                        menu += "</li>";
                    }
                    
                    menu += "</ul>";
                    menu += "</li>";
                    
                }
                menu += "</ul>";
            } else {
                menu = "";
            }
        } catch (SQLException sqle) {
            
            menu = " error " + sqle.getMessage();
            
        } finally {
        }
        usuarioValidado.put(usudto, menu);
        
        return usuarioValidado;
    }
    
    public LinkedList<UsuarioDTO> listarPerfilEstudiante(String idUsuario) {
        LinkedList<UsuarioDTO> resultado = new LinkedList();
        try {
            String sql = "SELECT roles.idRol as Rol,usuarios.idUsuario as Cedula, "
                    + "                    concat(usuarios.primerApellido, \"    \","
                    + "                    usuarios.segundoApellido) as Apellidos, "
                    + "                    concat(usuarios.primerNombre,\" \",usuarios.segundoNombre) as Nombres, "
                    + "                    usuarios.correo as Correo, usuarios.direccion as Direccion, "
                    + "                    usuarios.contraseña as Contraseña, "
                    + "                    eps.Descripcion as Eps, "
                    + "                    telefonos.telefono as Telefono, cursos.nombreCurso as Curso, "
                    + "                    acudientes.idAcudiente as Cedula, "
                    + "                    acudientes.nombreCompleto as Nombre, acudientes.correo as Correo, "
                    + "                    acudientes.parentesco as Parentesco"
                    + "                    FROM usuarios "
                    + "                    inner join rolasociado on usuarios.idUsuario=rolasociado.idUsuario"
                    + "                    inner join roles on rolasociado.idRol=roles.idRol"
                    + "                    inner join acudienteasociado on usuarios.idUsuario=acudienteasociado.idEstudiante"
                    + "                    inner join Acudientes on acudienteasociado.idAcudiente=Acudientes.idAcudiente"
                    + "                    inner join telefonos on usuarios.idUsuario=telefonos.idUsuario"
                    + "                    inner join eps on usuarios.idEPS=eps.idEPS"
                    + "                    inner join cursoAsociado on usuarios.idUsuario=cursoAsociado.idEstudiante"
                    + "                    inner join cursos on cursoAsociado.idCurso=cursos.idCurso"
                    + "                    WHERE usuarios.idUsuario=? AND  roles.idRol=3 "
                    + "                    GROUP BY acudientes.idAcudiente,telefonos.telefono;";
            pst = cnn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RolDTO roldto = new RolDTO();
                    roldto.setIdrol(rs.getInt("Rol"));
                    TelefonoDTO teldto = new TelefonoDTO();
                    teldto.setTelefono(rs.getString("Telefono"));
                    EpsDTO epsdto = new EpsDTO();
                    epsdto.setNombre(rs.getString("Eps"));
                    CursoDTO cursodto = new CursoDTO();
                    cursodto.setNombreCurso(rs.getString("Curso"));
                    AcudienteDTO acudto = new AcudienteDTO();
                    acudto.setIdAcudiente(rs.getInt("Cedula"));
                    acudto.setNombreCompleto(rs.getString("Nombre"));
                    acudto.setEmail(rs.getString("Correo"));
                    acudto.setParentesco(rs.getString("Parentesco"));
                    UsuarioDTO usudto = new UsuarioDTO();
                    usudto.setIdrol(roldto);
                    usudto.setIdUsuario(rs.getString("Cedula"));
                    usudto.setPrimerApellido(rs.getString("Apellidos"));
                    usudto.setPrimerNombre(rs.getString("Nombres "));
                    usudto.setEmail(rs.getString("Correo"));
                    usudto.setDireccion(rs.getString("Direccion"));
                    usudto.setContraseña(rs.getString("Contraseña"));
                    usudto.setIdEPS(epsdto);
                    usudto.setIdTelefonos(teldto);
                    usudto.setIdCurso(cursodto);   
                    usudto.setIdAcudiente(acudto);
                    resultado.add(usudto);
                }
            } else {
                System.out.println("NO SE HAN ENCONTRADO REGISTROS ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultado;
    }
    
    public LinkedList<UsuarioDTO> listarUsuarioById(String idUsuario) {
        LinkedList<UsuarioDTO> resultado = new LinkedList();
        try {
            String sql = "SELECT usuarios.idUsuario as Cedula, concat(usuarios.primerApellido, \"    \", usuarios.segundoApellido) as Apellidos, "
                    + "concat(usuarios.primerNombre,\"  \",usuarios.segundoNombre) as Nombres, usuarios.correo as Correo, usuarios.direccion as Direccion, "
                    + "usuarios.contraseña as Contraseña,"
                    + " eps.Descripcion as Eps, "
                    + "telefonos.telefono as Telefono "
                    + "FROM usuarios inner join telefonos "
                    + "on usuarios.idUsuario=telefonos.idUsuario"
                    + "inner join eps on usuarios.idEPS=eps.idEPS where usuarios.idUsuario=? group by telefonos.telefono;";
            pst = cnn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    TelefonoDTO teldto = new TelefonoDTO();
                    teldto.setTelefono(rs.getString("Telefono"));
                    EpsDTO epsdto = new EpsDTO();
                    epsdto.setNombre(rs.getString("Eps"));
                    UsuarioDTO usudto = new UsuarioDTO();
                    usudto.setIdUsuario(rs.getString("Cedula"));
                    usudto.setPrimerApellido(rs.getString("Apellidos"));
                    usudto.setPrimerNombre(rs.getString("Nombres "));
                    usudto.setEmail(rs.getString("Correo"));
                    usudto.setDireccion(rs.getString("Direccion"));
                    usudto.setContraseña(rs.getString("Contraseña"));
                    usudto.setIdTelefonos(teldto);
                    usudto.setIdEPS(epsdto);
                    resultado.add(usudto);
                }
            } else {
                System.out.println("NO SE HAN ENCONTRADO REGISTROS ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultado;
    }
    
    public LinkedList<UsuarioDTO> listarUsuarioFiltro() {
        LinkedList<UsuarioDTO> resultado = new LinkedList();
        try {
            String sql = "select idUsuario, primerNombre, segundoNombre, primerApellido, segundoApellido,correo, direccion from usuarios;";
            pst = cnn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    
                    UsuarioDTO usudto = new UsuarioDTO();
                    usudto.setIdUsuario(rs.getString("idUsuario"));
                    usudto.setPrimerNombre(rs.getString("primerNombre"));
                    usudto.setSegundoNombre(rs.getString("segundoNombre"));
                    usudto.setPrimerApellido(rs.getString("primerApellido"));
                    usudto.setSegundoApellido(rs.getString("segundoApellido"));
                    usudto.setEmail(rs.getString("correo"));
                    usudto.setDireccion(rs.getString("direccion"));
                    resultado.add(usudto);
                }
            } else {
                System.out.println("No se encuentran los registros ");
            }
        } catch (SQLException ex) {
            System.out.println("Error al listar los elementos " + ex.getSQLState() + " - " + ex.getMessage());
        }
        return resultado;
    }
    
}
