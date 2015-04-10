<%-- 
    Document   : horariodoce
    Created on : 16/03/2015, 09:42:47 PM
    Author     : Jose Castro
--%>

<%@page import="dto.UsuarioDTO"%>
<%@page import="dao.UsuarioDAO"%>
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
        <%
            UsuarioDTO usu = new UsuarioDTO();
            UsuarioDAO cidao = new UsuarioDAO();
           
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
                     font-size: 16px;"> <!--Last access : 30 May 2014 &nbsp; --> <a href="#" class="btn btn-danger square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
            </nav>   
            <!-- /. NAV TOP  -->
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
                        <li>
                            <a  href="perfildoce.jsp"><i class="fa fa-user fa-3x"></i> Perfil </a>
                        </li>
                        <li>
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
                    <div class="row">
                        <div class="col-md-12">
                            <!-- Advanced Tables -->
                            <div class="panel panel-success">
                                <div class="panel-heading" style="background:#4cae4c;  font-size: 22px; 
                                     color: #FFFFFF;
                                     font-family:OpenSans  ">
                              Horarios Asociados
                                </div>
                                <div class="panel-body">                        
                                    <table class="table table-striped table-bordered table-hover">
                                        <thead style="font-size: 16px" >
                                            <tr >
                                                <th style=" text-align: center" >Estudiante</th>
                                                <th style=" text-align: center">Curso</th>
                                                <th style=" text-align: center">Fecha</th>
                                                <th style=" text-align: center">Hora</th>
                                                <th style=" text-align: center">Motivo</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (CitaAcademicaDTO doce : var) {
                                            %>
                                            <tr class="odd gradeX">
                                                <th><%=doce.getIdUsuario().getPrimerApellido()%></th>   
                                                <th><%=doce.getIdCurso().getNombreCurso()%></th>  
                                                <th><%=doce.getFecha()%></th>  
                                                <th><%=doce.getHora()%></th>  
                                                <th><%=doce.getMotivo()%></th> 
                                                <th style="border:1; cellspacing:0; cellpadding:2 "> <a href="../ControlCita?a=1&idCitaAcademica=" name="btnCancelar"  style="width: 100%; margin:0" class="btn btn-success fa fa-check-circle-o " title="Aprobar"></a></th>
                                                <th style="border:1; cellspacing:0; cellpadding:2 "> <a href="../ControlCita?a=2&idCitaAcademica=" name="btnEliminar"  style="width: 100%; margin:0"  class="btn btn-danger fa fa-trash-o " title="Cancelar"></a></th>
                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>

                                    </table>
                                    <%
                                        if (request.getParameter("sal") != null) {
                                    %>

                                    <div>
                                        <b>Se ha eliminado exitosamente la cita</b>                                                                                        
                                    </div>

                                    <%
                                        }
                                    %>
                                </div>
                            </div>
                            <!--End Advanced Tables -->
                        </div>
                    </div>
                    <!-- /. ROW  -->
                    <div class="foot"><a href="generaexcel.jsp" name="btnHorario" class="btn btn-success square-btn-adjust fa fa-download fa-2x" style=" margin-left:90%; height:40px; width:5%" title="Consultar disponibilidad"></a></div>
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
