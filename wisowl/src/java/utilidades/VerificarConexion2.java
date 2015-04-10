package utilidades;

import dao.NotaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarConexion2 {

     public static void main(String[] args) {
        Connection cnn = null;
        PreparedStatement pstmt;
        ResultSet rs = null;
        try {
            cnn = Conexion.getInstance();

            pstmt = cnn.prepareStatement("SELECT idUsuario, primerNombre FROM usuarios");
            rs = pstmt.executeQuery();

            System.out.println("Usuario " + " Nombre");
            while (rs.next()) {
                System.out.println(rs.getString("idUsuario") + "     " + rs.getString("primerNombre"));
            }
        } catch (SQLException sqle) {
            System.out.println("Error en la ejecución sqle:"
                    + sqle.getErrorCode() + " " + sqle.getMessage());
        } catch (Exception e) {
            System.out.println("Error en la ejecución e:"
                    + " " + e.getMessage());
        } finally {

        }
      
    }
}
