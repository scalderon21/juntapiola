/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisDaOs;

import MisClases.Usuario;

/**
 *
 * @author yanis
 */
public interface UsuarioDAO {
    String buscarUsuario(String correo, String claveMD5);
    //List <Usuario> obtenerUsuarios();
    boolean agregarUsuario(Usuario usuario);
}
