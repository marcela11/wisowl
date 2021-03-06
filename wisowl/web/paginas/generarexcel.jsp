<%-- 
    Document   : generarexcel
    Created on : 26-ago-2014, 9:27:18
    Author     : Aprendiz
--%>
<%@page import="java.util.LinkedList"%>
<%@page import="dto.NotaDTO"%>
<%@page import="dto.NotaDTO"%>
<%@page import="dao.NotaDAO"%>
<%@page import="java.util.Date"%>
<%@page contentType="application/vnd.ms-excel" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            NotaDAO notdao = new NotaDAO();
            NotaDTO noto = new NotaDTO();
            LinkedList<NotaDTO> listarP = notdao.listarReportePer(1001);
        %>
        <meta http-equiv="Content-Type" content="application/vnd.ms-excel; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
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
                <%                                                  for (NotaDTO not : listarP) {
                %>

                <%
                    String nombreArchivo = "Reporte Academico " + new Date() + ".xls";
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivo + "\"");

                    for (int i = 0; i < 1; i++) {
                %>
                <tr>
                <tr class="odd gradeX">
                    <td><%=not.getIdAsigna().getDescripcion()%></td>                                                        
                    <td> <%=not.getNota1()%></td>
                    <td ><%=not.getNota2()%></td>
                    <td ><%=not.getNota3()%></td>
                    <td ><%=not.getTotal()%> </td>
                    <td><%=not.getFechaNota()%> </td>
                    <td><%=not.getObservacion()%></td>
                </tr> 
                <% 
                    }
                %>
                <%

        out.write("\n");
    }

                %>  
            </tbody>
        </table> 
    </body>
</html>
