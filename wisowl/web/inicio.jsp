<%-- 
    Document   : inicio
    Created on : 25/02/2015, 08:47:59 PM
    Author     : Personal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
            </head>
    <body>
        <form action="Mail" method="POST">
            <input type="text" name="asunto" value="" placeholder="asunto"/>
            <input type="text" name="mensaje" value="" placeholder="mensaje" />
            <input type="submit" value="enviar" name="enviar" />
            <a href="recuperar.jsp"> Recuperar Contraseña</a>
        </form>
    </body>
</html>
