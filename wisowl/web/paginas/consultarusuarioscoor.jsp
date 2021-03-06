<%-- 
    Document   : consultarusuarioscoor
    Created on : 23/02/2015, 04:51:42 PM
    Author     : USER
--%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>W  i  s  O  w  l</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link rel="shortcut icon" href="assets/img/favicon.ico.png"> 
        <!-- CUSTOM STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
        <!-- TABLE STYLES-->
        <link href="assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <%
            UsuarioDTO usudto = new UsuarioDTO();
            UsuarioDAO usudao = new UsuarioDAO();
            LinkedList<UsuarioDTO> var = usudao.listarUsuarios();
        %>
        <div id="wrapper">
            <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div style="color: white;
                     padding: 15px 50px 5px 50px;
                     float: right;
                     font-size: 16px;"> Ultimo ingreso : 03 Marzo 2015 &nbsp; <a href="#" class="btn btn-danger btn-lg  square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img  src="assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>

                        <li  >
                            <a   href="ingresocoor.jsp"><i class="fa fa-home fa-3x"></i> Inicio </a>
                        </li>	
                        <li  >
                            <a  href="perfilcoor.jsp"><i class="fa fa-user fa-3x"></i> Perfil </a>
                        </li>
                        <li  >
                            <a  href="horariosdocecoor.jsp.jsp"><i class="fa fa-times-circle-o fa-3x"></i> Horario(s)</a>
                        </li>
                        <li>
                            <a href="modificarusuarioscoor.jsp"><i class="fa fa-users fa-3x"></i> Usuario(s) <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">

                                <!--li>
                                    <a href="#">Reporte por Periodos<span class="fa arrow"></span></a>  
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Primer Periodo</a>
                                        </li>
                                    </ul>
                                </li-->
                            </ul>
                        </li>  
                    </ul> 
                </div>
            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Coordinador</h2>   
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    Usuarios Registrados                                    
                                </div>
                                <div class="panel-body">                        
                                    <table class="table table-bordered table-hover"  >
                                        <thead style="font-size: 16px" >
                                            <tr>
                                                <th>Apellidos</th>
                                                <th>Nombres</th>
                                                <th>Telefono</th>
                                                <th>EPS</th>
                                                <th>Direccion</th>
                                                <th>Correo Electronico</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (UsuarioDTO usu : var) {
                                            %>
                                            <tr>
                                                <th><%=usu.getPrimerApellido()%></th>
                                                <th><%=usu.getPrimerNombre()%></th>
                                                <th><%=usu.getIdTelefonos().getTelefono()%></th>
                                                <th><%=usu.getIdEPS().getNombre()%></th>
                                                <th><%=usu.getDireccion()%></th>
                                                <th><%=usu.getEmail()%></th>                                                                                         
                                                <th style="border:1; cellspacing:0; cellpadding:2 "><a href="modificarusuarioscoor.jsp?idUsuario=<%=usu.getIdUsuario()%>" name="btnEditar"  style="width: 100%; margin:0" class="btn btn-danger fa fa-pencil-square-o " title="Editar"></a></th>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div>
                    <!-- /. ROW  -->
                </div>
            </div>
            <!-- /. PAGE INNER  -->
        </div>
        <!-- /. PAGE WRAPPER  -->
        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="assets/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="assets/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="assets/js/jquery.metisMenu.js"></script>
        <!-- DATA TABLE SCRIPTS -->
        <script src="assets/js/dataTables/jquery.dataTables.js"></script>
        <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
        <!-- CUSTOM SCRIPTS -->
        <script src="assets/js/custom.js"></script>
    </body>
</html>

