<%-- 
    Document   : reportedocee
    Created on : Feb 24, 2015, 1:55:13 AM
    Author     : negro
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
                     font-size: 16px;"><!--Last access : 30 May 2014 &nbsp; --><a href="#" class="btn btn-danger btn-lg  square-btn-adjust fa fa-sign-out"> Cerrar Sesion </a> </div>
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
                                    Reporte academico 
                                                                     
                                </div>  
                                <br>
                                <!--div class="col-md-6" -->
                                <form class="form-horizontal"  style="position:relative; left: 200px;" role="form" action="../ControlNota" method="post">
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <input   type="hidden" class="form-control" placeholder="Nota" name="num"  value="<%if (not != null) {
                                                out.print(not.getIdNota());
                                            }%>" />
                                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                                        <input type="date" class="form-control"  placeholder="Fecha de ingreso" name="Fecha" value="<%if (not != null) {
                                                out.print(not.getFechaNota());
                                            }  %>"/>
                                    </div> 
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <input   type="hidden" class="form-control" placeholder="Estudiante" name="idUsu"  disabled  value="<%if (not != null) {
                                                out.print(not.getIdEstudiante().getIdUsuario());
                                            }%> " /> 
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input disabled="true" type="text" class="form-control" placeholder="Estudiante" name="Usuario" value="<%if (not != null) {
                                                out.print(not.getIdEstudiante().getPrimerNombre());
                                            }%>" />
                                    </div>
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa fa-list-ol"></i></span>
                                        <input  type="text" class="form-control" placeholder="Cognitivo" name="Nota1" value="<%if (not != null) {
                                                out.print(not.getNota1());
                                            } %>" />
                                    </div>
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa fa-list-ol"></i></span>
                                        <input  type="text" class="form-control"  placeholder="Procedimental" name="Nota2" value="<%if (not != null) {
                                                out.print(not.getNota2());
                                            } %>"  />
                                    </div>   
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa fa-list-ol"></i></span>
                                        <input  type="text"  class="form-control" placeholder="Actitudinal"  name="Nota3" value="<%if (not != null) {
                                                out.print(not.getNota3());
                                            } %>" />
                                        <input   type="hidden" class="form-control" placeholder="total" name="txtTotal"  disabled  value="5" />
                                    </div>  
                                    <!--
                                    <div class=" form-group input-group input-group-lg">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="text" class="form-control" placeholder="Total" value="//if (not != null) {
                                            //out.print(not.getTotal());
                                            //}  "/>
                                    </div> 
                                    -->
                                    <div class=" form-group input-group input-group-lg" style="width: 600px;">
                                        <span class="input-group-addon"><i class="fa-file-text-o"></i></span>
                                        <input type="text"  class="form-control" placeholder="Observacion" name="Observacion" value="<%if (not != null) {
                                                out.print(not.getObservacion());
                                            }%>"  />
                                    </div>    
                                    <div class="foot" style="  position:relative; left: 500px;">
                                                                               <input  type="submit" name="btnModificar" class="btn btn-success"  value="Modificar"  id="btnModificar">
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
