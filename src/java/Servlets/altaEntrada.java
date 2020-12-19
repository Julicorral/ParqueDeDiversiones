
package Servlets;

import Logica.Controladora;
import Logica.Juego;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "altaEntrada", urlPatterns = {"/altaEntrada"})
public class altaEntrada extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        Controladora control = new Controladora();

        String juego = request.getParameter("juego");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        String id_cliente = request.getParameter("id_cliente");
        
        if (!control.comprobarHorarioJuego(hora, juego)) {
            response.sendRedirect("errorHorario.jsp");
            return;
        }
        
        if (!control.comprobarCantidadEntradas(hora, juego)) {
            response.sendRedirect("errorCantidad.jsp");
            return;            
        }
        
        control.crearEntrada(juego, fecha, hora, id_cliente);
        
        response.sendRedirect("comprarEntrada.jsp");
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
