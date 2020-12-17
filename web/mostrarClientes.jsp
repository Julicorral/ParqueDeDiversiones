<%-- 
    Document   : mostrarClientes
    Created on : 17-dic-2020, 14:30:30
    Author     : Admin
--%>

<%@page import="Logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
    
    <table>
        <th>
            <td>Id</td>
            <td>Apellido</td>
            <td>Nombre</td>
            <td>DNI</td>
            <td>Fecha Nac</td>
        </th>
        <tr>
            <%
                //Controladora control = misession.getAtribute("control");
                //List<Cliente> listaClientes = control.getListaClientes();
                %>
        </tr>
    </table>
</html>
