<%-- 
    Document   : recuperarcontraseña
    Created on : Mar 24, 2015, 2:43:56 PM
    Author     : negro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <label for="txtcorreo">Correo Electronico</label>
            <input type="text" name="txtcorreo" id="txtcorreo" value="" size="40" required="true"/>
            <br>
            <input type="hidden" name="btnEnviar" id="btnIng" value="" />
            <input type="submit" value="Enviar" name="btnEnviar" />
    </body>
</html>
