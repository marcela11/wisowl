<%-- 
    Document   : enviarcorreos
    Created on : 1/04/2015, 05:16:19 PM
    Author     : Jose Castro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <form  action="../Mail"  method="  POST"  class="formlogin"  id="form2"> 
                        <h1 class="h1-session">Smile System</h1>                            
                            <div class="formularrioodonto">
                                <label for ="cedula"> Numero de  Documento:</label>                          

                                <input type="text" name="cedula" id="cedula" class="mover" required  tabindex="2"  value=""  placeholder="***********"/>
                            </div>
                        <input type="submit" value="Enviar" name="recu" >

                    </form>
    </body>
</html>
