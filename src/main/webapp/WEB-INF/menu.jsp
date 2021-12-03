   <!-- Barra de navegación -->
    <header>
        <nav class="navbar-top">
 <!-- Buscador -->
            <ul class="navbar-top-ul">
                <li>
                    <form class="form-group " action="#">
                    <div class="form-group-container">
                        <span class="form-group-icon"><i class="zmdi zmdi-search"></i></span>
                        <input type="text" class="form-group-input" placeholder="Buscar...">
                    </div>
                </form>
                </li>
                <li class="navbar-top-item">
                    <a href="login.jsp" class="navbar-top-links">Registrarse</a>
                </li>
                <li class="navbar-top-item">
                    <a href="frmClientes.jsp" class="navbar-top-links">Iniciar sesión</a>
                </li>
                <li class="navbar-top-item">
                    <a href="#" class="navbar-top-links">
                        <i class="zmdi zmdi-shopping-cart"></i> Carrito
                        <!-- <i class="zmdi zmdi-chevron-down"></i> -->
                    </a>
                </li>
            </ul>
        </nav>
        <nav class="navbar">
            <header class="nabvar-mobile is-size-5-mobile">
                <a class="navbar-mobile-link has-text-white" href="#" id="btn-mobile"><i class="zmdi zmdi-menu"></i></a>
                <a class="navbar-mobile-link has-text-white" href="index.jsp">Tienda De Electrodomesticos</a>
            </header>
            <nav class="nav-menu" id="mySidenav">
                

                <a class="is-hidden-mobile brand is-uppercase has-text-weight-bold has-text-dark" href="index.jsp">Tienda De Electrodomesticos</a>
                <ul class="nav-menu-ul">
                    <li class="nav-menu-item" id="men">
                        <a class="nav-menu-link link-submenu active" href="">catalogo<i
                               class="zmdi zmdi-chevron-down"></i></a>
                       
                    </li>
                    
                    <li class="nav-menu-item"><a href="ClienteController" class="nav-menu-link">Cliente</a></li>
                    <li class="nav-menu-item"><a href="PagoControlador" class="nav-menu-link">Modo de Pago</a></li>
                    <li class="nav-menu-item"><a href="UsuarioControlador" class="nav-menu-link">Usuarios</a></li>
                    <li class="nav-menu-item"><a href="ProveedoresControlador" class="nav-menu-link">Proveedores</a></li>
                    <li class="nav-menu-item"><a href="index.jsp" class="nav-menu-link">Inicio</a></li>
                    <li class="nav-menu-item"><a href="promociones.jsp" class="nav-menu-link">Promociones</a></li>
                    <li class="nav-menu-item"><a href="carrito.jsp" class="nav-menu-link">carrito</a></li>
                    <li class="nav-menu-item"><a href="frmClientes.jsp" class="nav-menu-link">Registro</a></li>
                    <li class="nav-menu-item"><a href="login.jsp" class="nav-menu-link">Iniciar Sesión</a></li>
                </ul>
            </nav>
        </nav>
    </header>