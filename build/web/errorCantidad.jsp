<%@page import="Logica.Juego"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp" />

<body class="hold-transition sidebar-mini layout-fixed">
    
    <!-- Verifico que haya una sesión iniciada -->
    <% HttpSession misession = request.getSession();
        String usu = (String) request.getSession().getAttribute("usuario");
            if(usu == null) {
                response.sendRedirect("sinLogin.jsp");
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
          <section class="col-lg-7 connectedSortable">


              <h3>No hay m&aacute;s entradas disponibles para este juego</h3>
              <p>Por favor seleccione otro juego u horario</p>
              

            <!-- /.card -->
          </section>
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
      
<jsp:include page="footer.jsp" />

</body>
</html>

