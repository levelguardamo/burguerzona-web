package co.burguerzona.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Provee conexiones con la base de datos SQL Server de BurguerZona.
 * Cada llamada a obtenerConexion() abre una conexión nueva;
 * el llamador debe cerrarla usando try-with-resources.
 *
 * @author Equipo BurguerZona
 * @version 1.0
 */
public class ConexionDB {

    private static final String URL =
            "jdbc:sqlserver://localhost:1433;"
          + "databaseName=BurguerZona;"
          + "encrypt=false;"
          + "trustServerCertificate=true";

    private static final String USUARIO = "BZtest";
    private static final String CLAVE   = "BZtest"; 
    // ─────────────────────────────────────────────────────────────────

 
    private ConexionDB() {}

    /**
     * Abre y retorna una nueva conexión con la base de datos.
     *
     * @return objeto {@link Connection} activo
     * @throws SQLException si no se puede establecer la conexión
     */
    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
