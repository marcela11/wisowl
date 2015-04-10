package controladores;

import ControCorreos.Mail;
import ControCorreos.newClass;
import dao.NotaDAO;
import dao.UsuarioDAO;
import dto.NotaDTO;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.EncoderException;

/**
 *
 * @author negro
 */
public class Controlador extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if (request.getParameter("btnIng") != null && (request.getParameter("btnIngresarUsuario") != null)) {
                String usu = request.getParameter("txtusuario");
                String cont = request.getParameter("txtcontraseña");
                UsuarioDAO usudo = new UsuarioDAO();
                UsuarioDTO usudto = new UsuarioDTO();
                String menu = "";
                HashMap<UsuarioDTO, String> mn = new HashMap<UsuarioDTO, String>();
//                mn=usudo.validarUsuario((usu), cont);
//                mn = usudo.validarUsuario(Integer.parseInt(usu), cont);
                for (Map.Entry<UsuarioDTO, String> registro : mn.entrySet()) {
                    usudto = registro.getKey();
                    menu = registro.getValue();
                }
                if (usudto.getIdUsuario() != null) {
                    HttpSession miSesion = request.getSession(true);
                    miSesion.setAttribute("usuar", usudto);
                    miSesion.setAttribute("menu", menu);
                    response.sendRedirect("paginas/ingreso.jsp");

                } else {
                    response.sendRedirect("index.jsp?salida= Usuario no existe");
                }

            }
            UsuarioDAO usudao = new UsuarioDAO();
            UsuarioDTO us = new UsuarioDTO();
            newClass nc = new newClass();
            String rol;
            HttpSession sesion = request.getSession(true);
            if (request.getParameter("recu") != null) {
                String asu = (request.getParameter("cedula"));
                if (usudao.obtenerUno(asu) != null) {
                    try {
                        us = usudao.obtenerUno(asu);
                        String doc = us.getIdUsuario();
                        String con = String.valueOf(doc);
                        String ced = nc.encode(con);
                        String url = "http://localhost:8080/RecuperarContraseña/nueva.jsp?id=" + (ced);
                        ControCorreos.Correo.sendMail("Recuperar Contraseña", url, us.getEmail());
                        response.sendRedirect("inicio.jsp?msg= correo enviado ");
                        // 
                    } catch (EncoderException ex) {
                        Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (request.getParameter("cambiar") != null) {
                String cedu = request.getParameter("ids").trim();
                String cla1 = (request.getParameter("cla1").trim());
                String cla2 = (request.getParameter("cla2").trim());
                if (cla1 == cla2) {
                    try {
                        String cod = nc.Decode(cedu);
                        String cedula = (cod);
                        usudao.modificarUsuMail(cla2, cedula);
                        response.sendRedirect("paginas/index.jsp?msg= LA CLAVE HA SIDO MODIFICADA ");
                    } catch (Exception ex) {
                        Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect("paginas/index.jsp?msg= CLAVES NO COINCIDEN");

            } 
             else if (request.getParameter("btnEditar") != null) {
                String salida = "";
                SimpleDateFormat fecham = new SimpleDateFormat("dd/mm/yyyy");
                UsuarioDTO usudto = new UsuarioDTO();
              
//                nodto.setNota1(Float.parseFloat(request.getParameter("Cognitivo").trim()));
//                nodto.setNota2(Float.parseFloat(request.getParameter("Procedimental").trim()));
//                nodto.setNota3(Float.parseFloat(request.getParameter("Actitudinal").trim()));
//                nodto.setFechaNota(request.getParameter("Fecha").trim());
//                nodto.setObservacion(request.getParameter("Observacion"));
//                notdao.modificarNota(nodto);
                if (request.getParameter("btnGuardar") != null) {
                    NotaDAO notdao = new NotaDAO();
                    String sa = notdao.insertarTotal((Float.parseFloat(request.getParameter("Nota1").trim())), (Float.parseFloat(request.getParameter("Nota2").trim())), (Float.parseFloat(request.getParameter("Nota3").trim())));
                    response.sendRedirect("reportedoce.jsp?fuera=Registro realizado exitosamente " + salida);

                }
            } else if (request.getParameter("btnDescargar") != null) {
                SimpleDateFormat fecham = new SimpleDateFormat("dd/mm/yyyy");
                NotaDTO nodto = new NotaDTO();
                NotaDAO notdao = new NotaDAO();

                nodto.setNota1(Float.parseFloat(request.getParameter("Cognitivo").trim()));
                nodto.setNota2(Float.parseFloat(request.getParameter("Procedimental").trim()));
                nodto.setNota3(Float.parseFloat(request.getParameter("Actitudinal").trim()));
                nodto.setFechaNota(request.getParameter("Fecha").trim());
                nodto.setObservacion(request.getParameter("Observacion"));

            } else {
                out.print("boton no validado");
            }

        } finally {

            out.close();
        }
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
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
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
