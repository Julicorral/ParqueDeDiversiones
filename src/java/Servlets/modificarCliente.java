/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "modificarCliente", urlPatterns = {"/modificarCliente"})
public class modificarCliente extends HttpServlet {


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
            control.eliminarCliente(Integer.parseInt(id));
            response.sendRedirect("mostrarClientes.jsp");
        } else {
            response.sendRedirect("modificarCliente.jsp?id="+id);            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        String id = request.getParameter("id");
        String apellido = request.getParameter("apellido");
        String nombre = request.getParameter("nombre");
        String dni = request.getParameter("dni");
        String fechaNac = request.getParameter("fechaNac");

        Controladora control = new Controladora();
        
        control.modificarCliente(id, apellido, nombre, dni, fechaNac);
        
        response.sendRedirect("mostrarClientes.jsp");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
