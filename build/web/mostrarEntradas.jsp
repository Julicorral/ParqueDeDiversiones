
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
            <h3>Ver entradas</h3>
            
            <div id="page-wrap">
                
                <table>
                    <tr>
                        <th>Id</th>
                        <th>Fecha</th>
                        <th>Hora</th>
                        <th>Juego</th>
                        <th></th>
                        <th></th>

                    </tr>
                    <% 
                        List<Entrada> listaEntradas;
                        if (request.getParameter("fecha") == null) {
                            listaEntradas = control.getListaEntrada();
                        } else {
                            listaEntradas = control.getListaEntrada(request.getParameter("fecha"));
                        }
                         
                        SimpleDateFormat formatterFecha = new SimpleDateFormat("dd/MM/yyyy");  
                        SimpleDateFormat formatterHora = new SimpleDateFormat("HH:mm"); 
                        for(Entrada entra : listaEntradas) {
                    %>
                    <tr>
                        <td><%=entra.getId_entrada()%></td>
                        <td><%=formatterFecha.format(entra.getFecha().getTime())%></td>
                        <td><%=formatterHora.format(entra.getHora().getTime())%></td>
                        <td><%=control.getJuego(entra).getNombre()%></td>

                    
                        <td><a href="modificarEntrada?id=<%=entra.getId_entrada()%>&acc=mod"><i class="fas fa-edit"></i></a></td>
                        <td><a href="modificarEntrada?id=<%=entra.getId_entrada()%>&acc=del"><i class="far fa-trash-alt"></i></a></td>
                    </tr>
                    <% } %>
                </table>
                
                <form action="mostrarEntradas.jsp" method="GET">
        
                    <div class="form-group">
                        <label for="formGroupFecha">Fecha</label>
                        <div class="input-group date" data-target-input="nearest">
                            <input type="date" class="form-control" id="formGroupFecha" name="fecha" value="<%=request.getParameter("fecha")%>"/>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-primary">Aceptar</button>
 
                </form>
            </div>

            <!-- /.card -->
         
          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
      
<jsp:include page="footer.jsp" />
      
</body>
</html>

