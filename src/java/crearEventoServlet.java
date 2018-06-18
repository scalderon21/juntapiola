/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Usuario;
import MisDaOs.UsuarioDAO;
import MisDaOs.UsuarioDAOImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/crearEventoServlet"})
public class crearEventoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            try (PrintWriter out = response.getWriter()) {
                String nombreEvento=request.getParameter("nombreEvento");
                String tipoEvento=request.getParameter("tipoEvento");
                int quorum =  request.getIntHeader("quorum");
                int total = request.getIntHeader("total");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = (Date) formato.parse(request.getParameter("fecha"));
                String correoUsuario = request.getParameter("correoUsuario");
                
                
                /*
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
                */
            } catch (Exception ex) {
            Logger.getLogger(crearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
}


