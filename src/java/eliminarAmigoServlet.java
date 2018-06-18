/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yanis
 */
@WebServlet(urlPatterns = {"/eliminarAmigoServlet"})
public class eliminarAmigoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            String correoAmigo = request.getParameter("correoAmigo");
            String correoUsuario = request.getParameter("correoUsuario");
            AmigoDAO DAO = new AmigoDAOImplementacion();
            DAO.eliminarAmigo(correoAmigo, correoUsuario);
            String msj = "Se ha eliminado un amigo";
            response.sendRedirect("listarAmigosServlet?msj="+msj+"&correoUsuario="+correoUsuario);
        }
    }
}
