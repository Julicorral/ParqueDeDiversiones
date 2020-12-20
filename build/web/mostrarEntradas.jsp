
<%@page import="Logica.Entrada"%>
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
            <h1 class="m-0">Entradas compradas</h1>
          </div><!-- /.col -->

        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    
          <!-- /.Left col -->
          <!-- right col (We are only adding the ID to make the widgets sortable)-->
          <section class="col-lg-5 connectedSortable">

              <div id="page-wrap">
        <table>
            <tr>
                <th>Id</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th></th>
                <th></th>                
            </tr>
            <% 
                List<Entrada> listaEntradas = control.getListaEntrada();
                SimpleDateFormat formatterFecha = new SimpleDateFormat("dd/MM/yyyy");  
                SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm:SS"); 
                for(Entrada entra : listaEntradas) {
            %>
            <tr>
                <td id="<%=entra.getId_entrada()%>"><%=entra.getId_entrada()%></td>
                <td id="<%=formatterFecha.format(entra.getFecha().getTime())%>"><%=formatterFecha.format(entra.getFecha().getTime())%></td>
                <td id="<%=formatterHora.format(entra.getHora().getTime())%>"><%=formatterHora.format(entra.getHora().getTime())%></td>
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

