/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebai
 */
@WebServlet(urlPatterns = {"/listarAmigoEventoServlet"})
public class listarAmigoEventoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
List <Amigo> misAmigosEvento = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String correoUsuario = request.getParameter("correoUsuario");
        String correoAmigo = request.getParameter("correoAmigo");
        String nombreAmigo = request.getParameter("nombreAmigo");
        Amigo amigo = new Amigo(correoAmigo, nombreAmigo, correoUsuario);
        
        //Crear lista de participantes, luego mandarla al evento
        
        
        misAmigosEvento.add(amigo);
        
        int cant = misAmigosEvento.size();
        if (cant > 0){
            request.setAttribute("listaAmigos", misAmigosEvento);                 
            request.setAttribute("cantidadAmigos", cant);
            String msjBorrado = request.getParameter("msj");
            if(msjBorrado != null){
                request.setAttribute("msjBorrado", msjBorrado);
            }
        }else{
            request.setAttribute("msj", "No se agrego amigo");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/crear_evento.jsp");
        rd.forward(request, response);
    }
}
