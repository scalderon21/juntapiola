/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import MisClases.Amigo;
import MisDaOs.AmigoDAO;
import MisDaOs.AmigoDAOImplementacion;
import java.io.IOException;
import java.util.ArrayList;
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
public class invitarAmigosEventoServlet extends HttpServlet {
List <Amigo> misAmigosEvento = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        /*
        
        response.setContentType("text/html;charset=UTF-8");
        String correoUsuario = request.getParameter("correoUsuario");
        Amigo amigo = null;
        if(!misAmigosEvento.isEmpty()){
            String correoAmigo = request.getParameter("correoAmigo");
            String nombreAmigo = request.getParameter("nombreAmigo");
            amigo = new Amigo(correoAmigo, nombreAmigo, correoUsuario);
        }
        
        AmigoDAO DAO = new AmigoDAOImplementacion();
        List <Amigo> misAmigos = DAO.obtenerAmigos(correoUsuario);
        int cantAmigos = misAmigos.size();
               
        //misAmigosEvento.add(amigo);
        
        int cantAmigosEvento = misAmigosEvento.size();
        if (cantAmigos > 0){
            request.setAttribute("listaAmigos", misAmigos);                 
            request.setAttribute("cantidadAmigos", cantAmigos);
            request.setAttribute("listaAmigosEvento", misAmigosEvento);
            request.setAttribute("cantidadAmigosEvento", cantAmigosEvento);
            misAmigosEvento.add(amigo);
            String msjBorrado = request.getParameter("msj");
            if(msjBorrado != null){
                request.setAttribute("msjBorrado", msjBorrado);
            }
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/invitar_amigo_evento.jsp");
            rd.forward(request, response);
        }else{
            request.setAttribute("msj", "No se agrego amigo");
            RequestDispatcher rd= getServletContext().getRequestDispatcher("/invitar_amigo_evento.jsp");
            rd.forward(request, response);
        }
    */
    }
    
}