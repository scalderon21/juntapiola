package MisDaOs;

import MisClases.Conexion;
import MisClases.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOImplementacion implements EventoDAO{
    private final Connection conn;

    public EventoDAOImplementacion() {
        Conexion con = new Conexion();
        this.conn = con.conectarBD("juntapiola");
    }
    
    @Override
    public boolean agregarEvento(Evento evento) {
        boolean agregado = false;
        try {
            String query = "insert into evento (tipoEvento, nombreEvento, quorum, total, fecha, correoUsuario) values (?,?, ?, ?, ?, ?) ";
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1,evento.getTipoEvento());
            stmt.setString(2,evento.getNombreEvento());
            stmt.setInt(3,evento.getQuorum());
            stmt.setInt(4,evento.getTotal());
            java.util.Date fec = evento.getDate();
            java.sql.Date fecha = new java.sql.Date(fec.getTime());
            stmt.setDate(5, fecha);
            stmt.setString(6,evento.getCorreoUsuario());
            stmt.executeUpdate();
            agregado = true;
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agregado;
    }

    @Override
    public void eliminarEvento(String nombreEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String burcarEvento(String nombreEvento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
