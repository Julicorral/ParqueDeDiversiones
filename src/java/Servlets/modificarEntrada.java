
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "modificarEntrada", urlPatterns = {"/modificarEntrada"})
public class modificarEntrada extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String id = request.getParameter("id");
        String acc = request.getParameter("acc");
        Controladora control = new Controladora();

        if (acc.equals("del")) {
            control.eliminarEntrada(Integer.parseInt(id));
            response.sendRedirect("mostrarEntradas.jsp");
        } else {
            response.sendRedirect("modificarEntrada.jsp?id="+id);            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String id = request.getParameter("id");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        System.out.println(id + ", " + fecha + ", " + hora );
        
        Controladora control = new Controladora();
        
        control.modificarEntrada(id, fecha, hora);
        
        response.sendRedirect("mostrarEntradas.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
