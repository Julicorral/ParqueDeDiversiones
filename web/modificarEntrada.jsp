
<%@page import="Logica.Entrada"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Logica.Cliente"%>
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
               

      <% int id = Integer.parseInt(request.getParameter("id"));
        Entrada entra = control.getEntrada(id);
        SimpleDateFormat formatterFecha = new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm");
        String fecha = formatterFecha.format(entra.getFecha().getTime());
        String hora = formatterHora.format(entra.getHora().getTime());
        String h;
      %>
 
      <h3>Modificar entrada n&uacute;mero <%=request.getParameter("id")%></h3>
      <form action="modificarEntrada" method="POST">
          
        <input type="hidden" id="id" name="id" value="<%=id%>">

        <div class="form-group">
            <label>Fecha</label>
            <div class="input-group date" data-target-input="nearest">
                <input type="date" class="form-control" id="formGroupFecha"  name="fecha" value="<%=fecha%>" />
            </div>
        </div>
        
        <div class="form-group">
            <label for="formGroupHora">Hora</label>
            <select name="hora" id="formGroupHora">
                <% for(int i = 10; i<18; i++) {
                    for(int j = 0; j<59; j=j+15) { 
                        h = String.format("%02d:%02d",i,j); %>
                    <option value="<%=h%>"<%=hora.equals(h)?" selected":""%>><%=h%></option>
                <%  }
                } %>
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

