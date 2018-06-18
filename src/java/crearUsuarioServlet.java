/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisDaOs.UsuarioDAO;
import MisDaOs.UsuarioDAOImplementacion;
import MisClases.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yanis
 */
@WebServlet(urlPatterns = {"/crearUsuarioServlet"})
public class crearUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            try (PrintWriter out = response.getWriter()) {
                String correo=request.getParameter("correo");
                String nombre = request.getParameter("nombre");
                String clave=request.getParameter("clave");
                String claveMD5 = md5(clave);
                Usuario usuario = new Usuario(correo, nombre, claveMD5);
                UsuarioDAO usuarioDao = new UsuarioDAOImplementacion();
                boolean usuarioAgregado = usuarioDao.agregarUsuario(usuario);
                if(usuarioAgregado){
                    request.setAttribute("mensaje", "Usuario creado, ingrese sesion");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "El correo ya ha sido registrado");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/registrar.jsp");
                    rd.forward(request, response);
                }
                
            } catch (Exception ex) {
            Logger.getLogger(crearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String md5(String textoplano) throws  Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(textoplano.getBytes());

        int size = b.length;
        StringBuilder h = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0").append(Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }

}
