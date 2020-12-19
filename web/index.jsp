
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  // Verifico que haya un usuario
        Controladora control = new Controladora();
        if (control.getListaUsuario() == null || control.getListaUsuario().isEmpty()){
            response.sendRedirect("nuevoUsuario.jsp");
        }
%>

<jsp:include page="header.jsp" />

<body class="hold-transition sidebar-mini layout-fixed">
    
    
    
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
          <section class="col-lg-5 connectedSortable">

              <h1>Bienvenido</h1>
              


            <!-- /.card -->
          </section>
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
<jsp:include page="footer.jsp" />

</body>
</html>

