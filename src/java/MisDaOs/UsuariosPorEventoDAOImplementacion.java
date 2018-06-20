/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisDaOs;

import MisClases.Usuario;
import MisClases.Conexion;
import MisClases.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebai
 */
public class UsuariosPorEventoDAOImplementacion implements UsuariosPorEventoDAO{
    private final Connection conn;

    public UsuariosPorEventoDAOImplementacion() {
        Conexion con = new Conexion();
        this.conn = con.conectarBD("juntapiola");
    }
    
    @Override
    public boolean agregarAmigo(String correoAmigo, Evento evento) {
        boolean agregado = false;
        int idEvento = buscarEvento(evento);
        if(idEvento != 0){
            try {
                String query = "insert into evento_has_usuario values (?,?) ";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1,idEvento);
                stmt.setString(2,evento.getCorreoUsuario());           
                stmt.executeUpdate();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public int buscarEvento(Evento evento) {
        try {
            String query = "select idEvento from evento where nombreEvento=?";
            PreparedStatement stmt = null;
            stmt = conn.prepareStatement(query);
            stmt.setString(1,evento.getNombreEvento());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getInt("idEvento");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AmigoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }



    
}
