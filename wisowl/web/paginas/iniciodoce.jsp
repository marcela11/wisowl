<%-- 
    Document   : iniciodoce
    Created on : 09-abr-2015, 8:30:52
    Author     : Sena
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="dao.CitaDAO"%>
<%@page import="dto.CitaAcademicaDTO"%>
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
                     font-size: 16px;"> <!--Last access : 30 May 2014 &nbsp; --><a href="#" class="btn btn-danger square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
           <nav class="navbar-default navbar-side" role="navigation">
                <div class="sidebar-collapse">
                    <ul class="nav" id="main-menu">
                        <li class="text-center">
                            <img src="assets/img/find_user.png" class="user-image img-responsive"/>
                        </li>

                        <li  >
                            <a   href="ingresodoce.jsp"><i class="fa fa-home fa-3x"></i> Inicio </a>
                        </li>	
                        <li  >
                            <a  href="perfildoce.jsp"><i class="fa fa-user fa-3x"></i> Perfil </a>
                        </li>
                        <li  >
                            <a  href="citasdoce.jsp"><i class="fa fa-edit fa-3x"></i> Citas Academicas </a>
                        </li>
                        <li>
                            <a href="reportedoce.jsp"><i class="fa fa-clipboard fa-3x"></i> Reporte(s) <span class="fa arrow"></span></a>
                            
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

