package controladores;

import dao.NotaDAO;
import dao.UsuarioDAO;
import dto.NotaDTO;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Jose Castro
 */
public class connectionPoolWisowl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet connectionPoolWisowl</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet connectionPoolWisowl at " + request.getContextPath() + "</h1>");
            out.println("<h1> Resultado de la conexion"+ getConnection()+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public static String getConnection() throws NamingException, SQLException{
    Connection cnn=null;
    String retorno="";
    Context ctx;
    try {
    ctx = new InitialContext();
    DataSource ds=(DataSource) ctx.lookup("jdbc/wisowl");
    cnn=ds.getConnection();
    if(cnn!=null){
        NotaDTO  no=new NotaDTO();
        no.setFechaNota(Integer.toString(1));
        no.setNota1(2);
            no.setNota2(3);
            no.setNota3(4);
            NotaDAO nodao=new NotaDAO();
                   
 } else{
    retorno="Ha ocurrido un error";
    }
    }catch (NamingException ex) {
            retorno += " naming "+ex.getMessage();
        } catch (SQLException sqle) {
            retorno +=" sqle "+ sqle.getMessage();
        }
        return retorno;


    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(connectionPoolWisowl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(connectionPoolWisowl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(connectionPoolWisowl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(connectionPoolWisowl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
