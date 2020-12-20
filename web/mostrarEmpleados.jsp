
<%@page import="Logica.Empleado"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Cliente"%>
<%@page import="Logica.Cliente"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<body class="hold-transition sidebar-mini layout-fixed">


    <!-- Verifico que haya una sesión iniciada -->
    <% HttpSession misession = request.getSession();
        String usu = (String) request.getSession().getAttribute("usuario");
            if(usu == null) {
                response.sendRedirect("login.jsp");
            }
            
            Controladora control = new Controladora();
            misession.setAttribute("control", control);
    %>
    
    
<div class="wrapper">

<jsp:include page="sidebar.jsp" />


  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Diverland</h1>
          </div><!-- /.col -->

        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    
          <!-- /.Left col -->
          <!-- right col (We are only adding the ID to make the widgets sortable)-->
          <section class="col-lg-8 connectedSortable">
              <h3>Ver empleados</h3>
                <div id="page-wrap">
                  
                   
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Cargo</th>
                            <th>Usuario</th> 
                            <th></th>
                            <th></th>
                        </tr>
                        <% 
                            List<Empleado> listaEmpleados = control.getListaEmpleado();
                            for(Empleado emple : listaEmpleados) {
                        %>
                        <tr>
                            <td id="<%=emple.getId_empleado()%>"><%=emple.getId_empleado()%></td>
                            <td id="<%=emple.getNombre()%>"><%=emple.getNombre()%></td>
                            <td id="<%=emple.getApellido()%>"><%=emple.getApellido()%></td>
                            <td id="<%=emple.getDni()%>"><%=emple.getDni()%></td>
                            <td id="<%=emple.getCargo()%>"><%=emple.getCargo()%></td>
                            <td id="<%=emple.getUnUsuario().getNombreUsuario()%>"><%=emple.getUnUsuario().getNombreUsuario()%></td>

                            <td><a href="modificarEmpleado?id=<%=emple.getId_empleado()%>&acc=mod"><i class="fas fa-edit"></i></a></td>
                            <td><a href="modificarEmpleado?id=<%=emple.getId_empleado()%>&acc=del"><i class="far fa-trash-alt"></i></a></td>
                        </tr>
                        <% } %>
                    </table>
                </div>

            <!-- /.card -->
          </section>
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
      
<jsp:include page="footer.jsp" />
      
</body>
</html>

