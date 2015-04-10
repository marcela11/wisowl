<%-- 
    Document   : recuperar
    Created on : 04-mar-2015, 7:28:35
    Author     : Sena
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar contraseña</title>
    </head>
    <body>
        
          <form action="Mail" method="POST">              
              <label>Numero de cedula</label> 
            <input type="text" name="cedula" placeholder="cedula"/>
                      <input type="submit" value="recuperar" name="recu" />
        </form>
    </body>
</html>
