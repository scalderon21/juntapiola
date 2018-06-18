/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisDaOs;

import MisClases.Conexion;
import MisClases.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yanis
 */
public class UsuarioDAOImplementacion implements UsuarioDAO{
    private final Connection conn;

    public UsuarioDAOImplementacion() {
        Conexion con = new Conexion();
        this.conn = con.conectarBD("juntapiola");
    }
    
    @Override
    public boolean agregarUsuario(Usuario usuario) {
        boolean insercion = false;
        boolean correoEncontrado = false;
        String query = "SELECT * FROM USUARIO";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                if (rs.getString("correo").equals(usuario.getCorreo()))
                    correoEncontrado = true;
            }
            if (!correoEncontrado)
            {
                String query2 = "insert into usuario (correo,nombre,contraseña) values (?, ?, ?) ";
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setString(1,usuario.getCorreo());
                stmt2.setString(2,usuario.getNombre());
                stmt2.setString(3,usuario.getClave());
                stmt2.executeUpdate();
                insercion = true;
            }
        }catch (SQLException ex) 
        {
            Logger.getLogger(UsuarioDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insercion;
    }
    
    @Override
    public String buscarUsuario(String correo, String claveMD5) {
        String query = "select nombre from usuario where correo = ? and contraseña = ?";
        try(PreparedStatement stmt = conn.prepareStatement(query)){
            stmt.setString(1, correo);
            stmt.setString(2, claveMD5);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                return rs.getString("nombre");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
    @Override
    public List<Usuario> obtenerUsuarios() {
        List <Usuario> misUsuarios = new ArrayList<>();
        String query = "SELECT * FROM USUARIO";
        try(Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                misUsuarios.add(mapeo(rs)); //crea usuario y lo agrega a la lista misUsuarios
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(ProductoDAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return misUsuarios;
    }

    

    private Usuario mapeo(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setUsuario(rs.getString("usuario"));
        usuario.setClave(rs.getString("clave"));
        usuario.setNombre(rs.getString("nombre"));
        return usuario;
    }
**/
}
