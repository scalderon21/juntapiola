/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClases;

/**
 *
 * @author yanis
 */
public class Amigo {
    private String correoAmigo, nombreAmigo, correoUsuario;

    public Amigo() {
    }

    public Amigo(String correoAmigo, String nombreAmigo, String correoUsuario) {
        this.correoAmigo = correoAmigo;
        this.nombreAmigo = nombreAmigo;
        this.correoUsuario = correoUsuario;
    }

    public String getCorreoAmigo() {
        return correoAmigo;
    }

    public void setCorreoAmigo(String correoAmigo) {
        this.correoAmigo = correoAmigo;
    }

    public String getNombreAmigo() {
        return nombreAmigo;
    }

    public void setNombreAmigo(String nombreAmigo) {
        this.nombreAmigo = nombreAmigo;
    }
    
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

}
