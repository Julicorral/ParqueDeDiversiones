
<%@page import="Logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="Logica.Controladora"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  // Verifico que haya una sesión iniciada
    HttpSession misession = request.getSession();
    String usu = (String) request.getSession().getAttribute("usuario");
        if(usu == null) {
            response.sendRedirect("login.jsp");
        }

        Controladora control = new Controladora();
        misession.setAttribute("control", control);
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
                <h3>Registro de empleados</h3>
      
      
                <form action="altaEmpleado" method="POST">

                  <div class="form-group">
                    <label for="formGroupName">Nombre</label>
                    <input type="text" class="form-control" id="formGroupName"  name="nombre" />
                  </div>

                    <div class="form-group">
                    <label for="formGroupName">Apellido</label>
                    <input type="text" class="form-control" id="formGroupName" name="apellido" />
                  </div>

                  <div class="form-group">
                    <label for="formGroupName">DNI</label>
                    <input type="text" class="form-control" id="formGroupName"  name="dni" />
                  </div>

                  <div class="form-group">
                    <label for="formGroupName">Cargo</label>
                    <input type="text" class="form-control" id="formGroupName" name="cargo" />
                  </div>

                  <div class="form-group">
                      <label for="formGroupUsuario">Usuario</label>
                      <select name="usuario" id="formGroupUsuario">
                          <% List<Usuario> usuario = control.getListaUsuario();
                              for(Usuario u : usuario){ %>
                              <option value="<%=u.getId_usuario()%>"><%=u.getNombreUsuario()%></option>
                          <% } %>
                      </select>
                  </div>

                  <button type="submit" class="btn btn-primary">Aceptar</button>

                </form>  

            <!-- /.card -->
          </section>
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
      
<jsp:include page="footer.jsp" />
      
</body>
</html>

