import MisClases.Evento;
import MisClases.Usuario;
import MisDaOs.EventoDAO;
import MisDaOs.EventoDAOImplementacion;
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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/crearEventoServlet"})
public class crearEventoServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            HttpSession session = request.getSession();
            try (PrintWriter out = response.getWriter()) {
                response.setContentType("text/html;charset=UTF-8");
                String nombreEvento=request.getParameter("nombreEvento");
                String tipoEvento=request.getParameter("tipoEvento");
                int quorum =  Integer.parseInt(request.getParameter("quorum"));
                int total = Integer.parseInt(request.getParameter("total"));
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = (Date) formato.parse(request.getParameter("fecha"));
                String correoUsuario = request.getParameter("correoUsuario");
                Evento evento = new Evento(nombreEvento, tipoEvento, quorum, total, fecha, correoUsuario);
                EventoDAO eventoDao = new EventoDAOImplementacion();
                boolean eventoAgregado = eventoDao.agregarEvento(evento);
                if(eventoAgregado){
                    request.setAttribute("mensaje", "Evento Agregado");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }else{
                    request.setAttribute("mensajeError", "El evento no se ha agregado");
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                    rd.forward(request, response);
                }
                
            } catch (Exception ex) {
            Logger.getLogger(crearUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);

    }
    }
}


