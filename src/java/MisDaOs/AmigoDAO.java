/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisDaOs;

import MisClases.Amigo;
import java.util.List;

/**
 *
 * @author yanis
 */
public interface AmigoDAO {
    boolean agregarAmigo(Amigo amigo);
    List <Amigo> obtenerAmigos(String correoUsuario);
    void eliminarAmigo( String correoAmigo, String correoUsuario);
    String burcarNombre(String correoAmigo,String correoUsuario);
    void modificarAmigo(Amigo amigo, String correo,String correoUsuario);
}
