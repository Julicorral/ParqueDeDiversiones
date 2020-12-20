<%
    String sbUsu = (String) request.getSession().getAttribute("usuario");
%>


<!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index.jsp" class="brand-link">
      <img src="dist/img/castle.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Diverland</span>
    </a>




    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <% if(sbUsu != null) { %>
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="dist/img/avatar3.png" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
            
          <a href="./" class="d-block"><%=sbUsu%></a>
        </div>
      </div>
      <% } %>
        <!-- Sidebar Menu -->
           <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="#" class="nav-link active">
              <i class="fas fa-bars"></i>

              <p>
                Menu
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <% if(sbUsu == null) { %>
              <li class="nav-item">
                <a href="./login.jsp" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Login</p>
                </a>
              </li>
              <% } else { %>
              <li class="nav-item">
                <a href="./nuevoCliente.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Crear cliente</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./mostrarClientes.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Mostrar clientes</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./comprarEntrada.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Obtener entrada</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./mostrarEntradas.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Mostrar entradas</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./nuevoEmpleado.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Crear empleado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./mostrarEmpleados.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Mostrar empleados</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="./validarLogin?logout=true" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Cerrar sesi&oacute;n</p>
                </a>
              </li>
              <% } %>
            </ul>
          </li>
  

      </nav>
      <!-- /.sidebar-menu -->
</div>
    <!-- /.sidebar -->
    
</aside>
