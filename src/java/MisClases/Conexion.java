package MisClases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Conexion {
    public Connection conectarMiBD() throws NamingException, SQLException {
        InitialContext initctx = new InitialContext();
        DataSource ds = (DataSource)initctx.lookup("java:comp/env/jdbc/juntapiola");
        Connection conn = ds.getConnection();
        return conn;
    }
    public Connection conectarBD(String miBD) {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUri = "jdbc:mysql://localhost/"+miBD;
        String dbUser = "root";
        String dbPass = "";
        Connection conn=null;
        try {
            try {
                Class.forName(dbDriver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(dbUri,dbUser, dbPass);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
}

