
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "modificarEmpleado", urlPatterns = {"/modificarEmpleado"})
public class modificarEmpleado extends HttpServlet {


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
            control.eliminarEmpleado(Integer.parseInt(id));
            response.sendRedirect("mostrarEmpleados.jsp");
        } else {
            response.sendRedirect("modificarEmpleado.jsp?id="+id);            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String cargo = request.getParameter("cargo");

        Controladora control = new Controladora();
        
        control.modificarEmpleado(id, apellido, nombre, dni, cargo);
        
        response.sendRedirect("mostrarEmpleados.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
