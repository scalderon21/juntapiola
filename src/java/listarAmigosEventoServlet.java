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
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 *
 * @author sebai
 */
@WebServlet(urlPatterns = {"/listarAmigosEventoServlet"})
public class listarAmigosEventoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
List <Amigo> misAmigosEvento = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String correoUsuario = request.getParameter("correoUsuario");
        String correoAmigo = request.getParameter("correoAmigo");
        String nombreAmigo = request.getParameter("nombreAmigo");
        AmigoDAO DAO = new AmigoDAOImplementacion();
        List <Amigo> misAmigos = DAO.obtenerAmigos(correoUsuario);
        
        
        if(correoAmigo!=null && nombreAmigo!=null){
            misAmigosEvento.add(new Amigo(correoAmigo, nombreAmigo, correoUsuario));
        }
        
                
        int cant = misAmigos.size();
        if (cant > 0){
            request.setAttribute("listaAmigos", misAmigos); 
            request.setAttribute("listaAmigosInvitados", misAmigosEvento);  
            request.setAttribute("cantidadAmigos", cant);
            request.setAttribute("correoUsuario", correoUsuario);
            
            session.setAttribute("misAmigosEvento", misAmigosEvento.toString());
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
