package MisDaOs;

import MisClases.Amigo;
import MisClases.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AmigoDAOImplementacion implements AmigoDAO{
    private final Connection conn;

    public AmigoDAOImplementacion() {
        Conexion con = new Conexion();
        this.conn = con.conectarBD("juntapiola");
    }
    
    @Override
    public boolean agregarAmigo(Amigo amigo) {
        boolean agregado = false;
        try {
            String query = "insert into amigo (correoAmigo,nombreAmigo,correoUsuario) values (?, ?, ?) ";
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1,amigo.getCorreoAmigo());
            stmt.setString(2,amigo.getNombreAmigo());
            stmt.setString(3,amigo.getCorreoUsuario());
            stmt.executeUpdate();
            agregado = true;
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agregado;
    }

    @Override
    public List<Amigo> obtenerAmigos(String correoUsuario) {
        List <Amigo> misAmigos = new  ArrayList<>();
        String query = "select correoAmigo, nombreAmigo, correoUsuario from amigo where correoUsuario = ?";
        try(PreparedStatement stmt=conn.prepareStatement(query)){
            stmt.setString(1, correoUsuario);
            try(ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    misAmigos.add(mapeo(rs));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misAmigos;
    }
    
    private static Amigo mapeo(ResultSet resultSet) throws SQLException {
        Amigo amigo = new Amigo();
        amigo.setCorreoAmigo(resultSet.getString("correoAmigo"));
        amigo.setNombreAmigo(resultSet.getString("nombreAmigo"));
        amigo.setCorreoUsuario(resultSet.getString("correoUsuario"));
        return amigo;
    }

    @Override
    public void eliminarAmigo(String correoAmigo) {
        String query = "delete from amigo where correoAmigo = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, correoAmigo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String burcarNombre(String correo) {
        String nombre =  null;
        String query = "select nombreAmigo from amigo where correoAmigo = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                nombre = rs.getString("nombreAmigo");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nombre;
    }

    @Override
    public void modificarAmigo(Amigo amigo, String correoAntiguo) {
        String query = "update amigo set correoAmigo= ?, nombreAmigo= ? where correoAmigo = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, amigo.getCorreoAmigo());
            stmt.setString(2, amigo.getNombreAmigo());
            stmt.setString(3,correoAntiguo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
