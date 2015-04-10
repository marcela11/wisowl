<%-- 
    Document   : reportedoce
    Created on : 23/02/2015, 04:51:42 PM
    Author     : USER
--%>
<%@page import="dao.NotaDAO"%>
<%@page import="dto.NotaDTO"%>
<%@page import="java.util.LinkedList"%>
<%@page import="dto.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
    %>
    <head>
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
            if (request.getParameter("idEstudiante") != null) {

                String id = (request.getParameter("idEstudiante"));
                NotaDAO nodao = new NotaDAO();
                NotaDTO not = new NotaDTO();
                not = nodao.listarbyId(id);
                if (not != null) {
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
                     font-size: 16px;"> Ultimo ingreso : 05 Marzo 2015 &nbsp; <a href="#" class="btn btn-danger btn-lg  square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
            <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>

                        <li  >
                            <a   href="ingreso.jsp"><i class="fa fa-home fa-3x"></i> Inicio </a>
                        </li>	
                        <li  >
                            <a  href="perfilestu.jsp"><i class="fa fa-user fa-3x"></i> Perfil </a>
                        </li>
                        <li  >
                            <a  href="citasestu.jsp"><i class="fa fa-edit fa-3x"></i> Citas Academicas </a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-clipboard fa-3x"></i> Reporte(s) <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="reporteactestu.jsp">Reporte Actual<span class="fa arrow"></span></a>  
                                </li>
                                <li>
                                    <a href="#">Reporte por Periodos<span class="fa arrow"></span></a>  
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Primer Periodo</a>
                                        </li>
                                    </ul>
                                </li>
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
                            <h2>Docente</h2>   
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-success">
                                <div class="panel-heading" style="background:#4cae4c;  font-size: 22px; 
                                     color: #FFFFFF;
                                     font-family:OpenSans  ">
                                  Burscar Estudiante
                                </div>  
                                <br>
                                <!--div class="col-md-6" -->
                                <form class="form-horizontal"  style="position:relative; left: 200px;" role="form" action="../Filtro" method="post">
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input disabled="true" type="text" class="form-control" placeholder="Primer Nombre" name="pprimeN" value=" " />
                                    </div>
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa-file-text-o"></i></span>
                                        <input type="text"  class="form-control" placeholder="Primer Apellido" name="primerA" value=" "  />
                                    </div>    
                                    <div class="foot" style="  position:relative; left: 500px;">
                                        <input  type="submit" name="btnBuscar"   value="Buscar"  id="btnBuscar" />
                                    </div>  
                                </form> 
                                <%
                                } else if (request.getParameter("msg") != null) {
                                %>
                                <div class="confirmarOK"><%=request.getParameter("msg")%></div>        
                                <%
                                        } else {
                                            out.print("no llego nada");

                                        }
                                    }
                                %>
                                <!--/div-->
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
