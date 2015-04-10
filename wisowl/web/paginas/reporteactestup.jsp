<%-- 
    Document   : reporteactestu
    Created on : 23/02/2015, 05:57:46 PM
    Author     : USER
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="dto.NotaDTO"%>
<%@page import="dao.NotaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
    %>
    <head>
         <style type="text/css">    
            .pg-normal {
                color: black;
                font-weight: normal;
                text-decoration: none;    
                cursor: pointer;    
            }
            .pg-selected {
                color: black;
                font-weight: bold;        
                text-decoration: underline;
                cursor: pointer;
            }
        </style>
        <%
            NotaDAO notdao = new NotaDAO();
            NotaDTO noto = new NotaDTO();
            LinkedList<NotaDTO> listarA = notdao.listarReporteAct();


        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>W  i  s  O  w  l</title>
        <script type="text/javascript" href="assets/paging.js" src="paging.js"></script>
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
                     font-size: 16px;"> Ultimo ingreso : 03 Marzo 2015 &nbsp; <a href="#" class="btn btn-danger btn-lg  square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
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
                                    <a href="reporteactestu.jsp">Reporte(s) Actual</a>
                                </li>

                                <li>
                                    <a href="#">Reporte(s) por Periodo(s)<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="reporteprimeestu.jsp">Primer Periodo</a>
                                        </li>
                                        <li>
                                            <a href="reporteseguestu.jsp">Segundo Periodo</a>
                                        </li>
                                        <li>
                                            <a href="reporteterceestu.jsp">Tercer Periodo</a>
                                        </li>
                                        <li>
                                            <a href="reportecuartestu.jsp">Cuarto Periodo</a>
                                        </li>
                                    </ul>                              
                                </li>
                            </ul>
                        </li>  
                    </ul>

                    </ul>


                </div>
            </nav>  
            <!-- /. NAV SIDE  -->
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Bienvenido + nombre de usuario</h2>   
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
                                    Reporte Academico  
                                    <!-- <a href="#" class="btn btn-success square-btn-adjust fa fa-download fa-2x" style=" margin-left:90%; height:40px; width:5%" title="Descargar reporte"></a-->  
                                </div>
                                <div class="panel-body">                        
                                    <table class="table table-striped table-bordered table-hover"  >
                                        <thead style="font-size: 16px" >
                                            <tr>
                                                <th >Asignatura(s)</th>
                                                <th>Cognitivo</th>
                                                <th>Procedimental </th>
                                                <th>Actitudinal</th>
                                                <th>Total</th>
                                                <th >Fecha Registrada</th>
                                                <th >Observaciones</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%                                                  for (NotaDTO not : listarA) {
                                            %>
                                            <tr class="odd gradeX">
                                                <td ><%=not.getIdAsigna().getDescripcion()%></td>                                                        
                                                <td style="text-align: center "> <%=not.getNota1()%></td>
                                                <td style="text-align: center "><%=not.getNota2()%></td>
                                                <td style="text-align: center "><%=not.getNota3()%></td>
                                                <td style="text-align: center "><%=not.getTotal()%> </td>
                                                <td style="text-align: center "><%=not.getFechaNota()%> </td>
                                                <td ><%=not.getObservacion()%></td>


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
                    <div class="foot"><a href="generarexcelA.jsp" name="btnDescargar" class="btn btn-success square-btn-adjust fa fa-download fa-2x" style=" margin-left:90%; height:40px; width:5%" title="Descargar reporte"></a></div>
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

