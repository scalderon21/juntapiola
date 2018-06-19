/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yanis
 */
@WebServlet(urlPatterns = {"/agregarAmigosServlet"})
public class agregarAmigosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correo =request.getParameter("correo");
        String nombre =request.getParameter("nombre");
        String correoUsuario = request.getParameter("correoUsuario");
        if(!correoUsuario.equalsIgnoreCase(correo)){
            Amigo amigo=new Amigo(correo, nombre,correoUsuario);
            AmigoDAO amigoDAO = new AmigoDAOImplementacion();
            if(amigoDAO.agregarAmigo(amigo)){
                request.setAttribute("msj", "Amigo agregado");
            }else{
                request.setAttribute("msj", "Amigo ya existe");
            }
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/agregar_amigo.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("msj", "No puede agregarse como amigo");
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/agregar_amigo.jsp");
            rd.forward(request, response);
        }
        
    }

}
