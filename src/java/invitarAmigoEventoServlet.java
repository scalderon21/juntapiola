/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import java.util.List;
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
@WebServlet(urlPatterns = {"/invitarAmigoEventoServlet"})
public class invitarAmigoEventoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correoUsuario = request.getParameter("correoUsuario");
        AmigoDAO DAO = new AmigoDAOImplementacion();
        List <Amigo> misAmigos = DAO.obtenerAmigos(correoUsuario);
        int cant = misAmigos.size();
        if (cant > 0){
            request.setAttribute("listaAmigos", misAmigos);                 
            request.setAttribute("cantidadAmigos", cant);
            String msjBorrado = request.getParameter("msj");
            if(msjBorrado != null){
                request.setAttribute("msjBorrado", msjBorrado);
            }
        }else{
            request.setAttribute("msj", "No tienes amigos agregados");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/invitar_amigo_evento.jsp");
        rd.forward(request, response);
    }

}