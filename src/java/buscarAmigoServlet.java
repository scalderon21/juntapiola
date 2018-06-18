/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/buscarAmigoServlet"})
public class buscarAmigoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correoAmigo = request.getParameter("correo");
        AmigoDAO amigoDAO = null;
        amigoDAO = new AmigoDAOImplementacion();
        String nombreAmigo = amigoDAO.burcarNombre(correoAmigo);
        if(nombreAmigo != null){
            Amigo a = new Amigo();
            a.setCorreoAmigo(correoAmigo);
            a.setNombreAmigo(nombreAmigo);
            request.setAttribute("a", a);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificar_amigo.jsp");
            rd.forward(request, response);
        }
    }


}
