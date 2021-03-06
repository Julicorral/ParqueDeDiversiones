
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "altaCliente", urlPatterns = {"/altaCliente"})
public class altaCliente extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");

        Controladora control = new Controladora();
        
        control.crearCliente(apellido, nombre, dni, fechaNac);
        
        response.sendRedirect("mostrarClientes.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
