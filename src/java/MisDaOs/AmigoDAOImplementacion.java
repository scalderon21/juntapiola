/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author yanis
 */
public class AmigoDAOImplementacion implements AmigoDAO{
    private final Connection conn;

    public AmigoDAOImplementacion() {
        Conexion con = new Conexion();
        this.conn = con.conectarBD("juntapiola");
    }
    
    @Override
    public boolean agregarAmigo(Amigo amigo) {
        boolean agregado = false;
        boolean encontrado = false;
        String query = "select * from usuario_amigo where correoUsuario = ? and correoAmigo = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, amigo.getCorreoUsuario());
            stmt.setString(2, amigo.getCorreoAmigo());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                encontrado = true;
            }
            if(!encontrado){
                String query2 = "select * from amigo where correoAmigo = ?";
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setString(1, amigo.getCorreoAmigo());
                ResultSet rs2 = stmt2.executeQuery();
                if(rs2.next()){
                    String query3 = "insert into usuario_amigo values (?, ?, ?) ";
                    PreparedStatement stmt3 = conn.prepareStatement(query3);
                    stmt3.setString(1,amigo.getCorreoUsuario());
                    stmt3.setString(2,amigo.getCorreoAmigo());
                    stmt3.setString(3, amigo.getNombreAmigo());
                    stmt3.executeUpdate();
                    agregado = true;
                }else{
                    String query4 = "insert into amigo values (?) ";
                    PreparedStatement stmt4 = conn.prepareStatement(query4);
                    stmt4.setString(1,amigo.getCorreoAmigo());
                    stmt4.executeUpdate();
                    String query3 = "insert into usuario_amigo values (?, ?, ?) ";
                    PreparedStatement stmt3 = conn.prepareStatement(query3);
                    stmt3.setString(1,amigo.getCorreoUsuario());
                    stmt3.setString(2,amigo.getCorreoAmigo());
                    stmt3.setString(3,amigo.getNombreAmigo());
                    stmt3.executeUpdate();
                    agregado = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agregado;
    }

    @Override
    public List<Amigo> obtenerAmigos(String correoUsuario) {
        List <Amigo> misAmigos = new  ArrayList<>();
        String query = "select correoUsuario, correoAmigo, nombreAmigo from usuario_amigo where correoUsuario = ?";
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
    public void eliminarAmigo(String correoAmigo, String correoUsuario) {
        String query = "delete from usuario_amigo where correoAmigo = ? and correoUsuario = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, correoAmigo);
            stmt.setString(2, correoUsuario);
            stmt.executeUpdate();
            String query2 = "select * from usuario_amigo where correoAmigo = ?";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setString(1, correoAmigo);
            ResultSet rs = stmt2.executeQuery();
            if(!rs.next()){
                String query3 = "delete from amigo where correoAmigo = ?";
                PreparedStatement stmt3 = conn.prepareStatement(query3);
                stmt3.setString(1, correoAmigo);
                stmt3.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String burcarNombre(String correo,String correoUsuario) {
        String nombre =  null;
        String query = "select nombreAmigo from usuario_amigo where correoAmigo = ? and correoUsuario = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, correo);
            stmt.setString(2, correoUsuario);
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
    public void modificarAmigo(Amigo amigo, String correoAntiguo, String correoUsuario) {
        String query = "update usuario_amigo set correoAmigo= ?, nombreAmigo= ? where correoAmigo = ? and correoUsuario = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, amigo.getCorreoAmigo());
            stmt.setString(2, amigo.getNombreAmigo());
            stmt.setString(3,correoAntiguo);
            stmt.setString(4,correoUsuario);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
