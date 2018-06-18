import MisDaOs.UsuarioDAO;
import MisDaOs.UsuarioDAOImplementacion;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String correo=request.getParameter("correo");
        String clave=request.getParameter("clave");
        String claveMD5 = null; 
        try {
            claveMD5 = md5(clave);
        } catch (Exception ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsuarioDAO usuarioDAO = new UsuarioDAOImplementacion();
        String nombreUsuario = usuarioDAO.buscarUsuario(correo, claveMD5);
        if (nombreUsuario!=null){
            session.setAttribute("correoUsuario", correo);
            session.setAttribute("nombreUsuario", nombreUsuario);
            response.sendRedirect("index.jsp");
        } 
        else{
            request.setAttribute("mensajeError", "Correo y/o contraseña incorrectos");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    private String md5(String textoplano) throws  Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(textoplano.getBytes());

        int size = b.length;
        StringBuilder h = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255;
            if (u < 16) {
                h.append("0").append(Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }
}
