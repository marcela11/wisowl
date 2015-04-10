
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    protected static Connection cnn = null;

    private static void conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wisowl", "root", "");
        } catch (SQLException e) {
            System.out.println("Error en la base de datos" + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error inesperado" + e.getMessage());
        }

    }

    private Conexion() {
    }

    public static Connection getInstance() {
        if (cnn == null) {
            conectar();
        }
        return cnn;
    }
}
