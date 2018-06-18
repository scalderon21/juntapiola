/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/modificarAmigosServlet"})
public class modificarAmigosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correoAntiguo = request.getParameter("correoAntiguo");
        String correoNuevo = request.getParameter("correo");
        String nombre = request.getParameter("nombre");
        Amigo a = new Amigo();
        a.setCorreoAmigo(correoNuevo);
        a.setNombreAmigo(nombre);
        AmigoDAO amigoDAO = null;
        amigoDAO = new AmigoDAOImplementacion();
        amigoDAO.modificarAmigo(a ,correoAntiguo);
        request.setAttribute("msj", "Amigo Modificado");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_amigo.jsp");
        rd.forward(request, response);
    }
}
