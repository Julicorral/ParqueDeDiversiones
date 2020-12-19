
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
            <h1 class="m-0">Nuevo cliente</h1>
          </div><!-- /.col -->

        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    
          <!-- /.Left col -->
          <!-- right col (We are only adding the ID to make the widgets sortable)-->
          <section class="col-lg-5 connectedSortable">


        <table>
            <tr>
                <th>Id</th>
                <th>Apellido</th>
                <th>Nombre</th>
                <th>DNI</th>
                <th>Fecha Nac</th>
                <th></th>
                <th></th>                
            </tr>
            <% 
                List<Cliente> listaClientes = control.getListaCliente();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                for(Cliente cli : listaClientes) {
            %>
            <tr>
                <td id="<%=cli.getId_cliente()%>"><%=cli.getId_cliente()%></td>
                <td id="<%=cli.getApellido()%>"><%=cli.getApellido()%></td>
                <td id="<%=cli.getNombre()%>"><%=cli.getNombre()%></td>
                <td id="<%=cli.getDni()%>"><%=cli.getDni()%></td>
                <td id="<%=formatter.format(cli.getFechaNacimiento().getTime())%>"><%=formatter.format(cli.getFechaNacimiento().getTime())%></td>
                <td><a href="modificarCliente?id=<%=cli.getId_cliente()%>&acc=mod">mod</a></td>
                <td><a href="modificarCliente?id=<%=cli.getId_cliente()%>&acc=del">del</a></td>
            </tr>
            <% } %>
        </table>




            <!-- /.card -->
          </section>
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
      
<jsp:include page="footer.jsp" />
      
</body>
</html>
