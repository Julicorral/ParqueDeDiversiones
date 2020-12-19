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
          <section class="col-lg-5 connectedSortable">


              
      <h3>Compra de entradas</h3>
      <form action="altaEntrada" method="POST">

        <div class="form-group">
            <label for="formGroupJuego">Juego</label>
            <select name="juego" id="formGroupJuego">
                <% List<Juego> juegos = control.getListaJuego();
                    for(Juego j : juegos){ %>
                    <option value="<%=j.getId_juego()%>"><%=j.getNombre()%></option>
                <% } %>
            </select>
        </div>
          
        <div class="form-group">
            <label for="formGroupFecha">Fecha</label>
            <div class="input-group date" data-target-input="nearest">
                <input type="date" class="form-control" id="formGroupFecha"  name="fecha" />
            </div>
        </div>

        <div class="form-group">
            <label for="formGroupHora">Hora</label>
            <select name="hora" id="formGroupHora">
                <% for(int i = 10; i<18; i++) {
                    for(int j = 0; j<59; j=j+15) { %>
                    <option value="<%=String.format("%02d:%02d",i,j)%>"><%=String.format("%02d:%02d",i,j)%></option>
                <%  }
                } %>
            </select>
        </div>

        <div class="form-group">
          <label for="formGroupId">N&uacute;mero de cliente</label>
          <input type="text" class="form-control" id="formGroupId" name="id_cliente" />
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

