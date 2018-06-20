/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisDaOs;

import MisClases.Usuario;
import MisClases.Evento;

/**
 *
 * @author sebai
 */
public interface UsuariosPorEventoDAO {
    boolean agregarAmigo(String correoAmigo, Evento evento);
    int buscarEvento(Evento evento);
}
