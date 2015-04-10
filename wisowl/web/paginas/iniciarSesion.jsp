<%-- 
    Document   : iniciarSesion
    Created on : 8/04/2015, 11:12:53 PM
    Author     : Jose Castro
--%>

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
     <div class="panel panel-default">
                                    <div class="panel-heading" style="background:#4cae4c;  font-size: 22px; 
                                         color: #FFFFFF;
                                         font-family:OpenSans  ">
                                        Datos Personales
                                    </div>
                                    <div class="panel-body">
                                        <div class="row">                               
                                            <div class="col-md-6">
                                                <form class="form-horizontal"  style="position:relative; left: 200px;" role="form" action="Controlador"> 
                                                    <fieldset>Iniciar Sesion</fieldset>
                                                    <div class=" form-group input-group input-group-lg">
                                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                        <input type="text" class="form-control" name="txtusuario" placeholder="Numero de documento"  value="" />
                                                    </div>
                                                    <div class=" form-group input-group input-group-lg">
                                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                        <input  type="password" class="form-control" placeholder="txtcontraseña" name="Contraseña" value="" />
                                                    </div>                                
                                                    <br>
                                                    <div class="foot" style="  position:relative; left: 500px;">
                                                        <input  type="submit" name="btnIngresarUsuario" class="btn btn-success"  value="Ingresar"  id="btnIngresarUsuario">
                                                        <input  type="hidden" name="btnIng" id="btnIng">
                                                    </div> 
                                                    <div class="foot" style="  position:relative; right: 250px;">
                                                        <input  type="submit" name="btnIngresarUsuario" class="btn btn-success"  value="Ingresar"  id="btnIngresarUsuario">
                                                        <input  type="hidden" name="btnIng" id="btnIng">
                                                    </div> 
                                                </form>                
                                            </div>  
                                        </div>  
                                    </div>
                                    <div class="right">
                                        <ul class="copyright" style="color: black; font-size: 16px">
                                            <a href="#" ><li style=" color: red;">Contactenos</li> </a><li>&copy; W i s O w l</li><li>Ficha: 626741</li>
                                        </ul>
                                    </div>
                                </div>
    </body>
</html>
