
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "validarLogin", urlPatterns = {"/validarLogin"})
public class validarLogin extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        if (!request.getParameter("logout").equals("true")){
            response.sendRedirect("index.jsp");
            return;
        }
        
        HttpSession misession = request.getSession();
        misession.invalidate(); 
            
        response.sendRedirect("index.jsp");
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        Boolean okONo = false;
        
        Controladora control = new Controladora();
        okONo = control.comprobarIngreso(request.getParameter("nombreUsuario"), request.getParameter("pass"));
        
        if (okONo == true) {
            HttpSession misession = request.getSession(true);
            String usuario = request.getParameter("nombreUsuario");
            String pass = request.getParameter("pass");
            misession.setAttribute("loggeado", true);
            misession.setAttribute("usuario", usuario);
            misession.setAttribute("control", control);
            
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("loginError.jsp");
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
