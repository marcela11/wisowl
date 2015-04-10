/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.NotaDAO;
import dao.UsuarioDAO;
import dto.EpsDTO;
import dto.NotaDTO;
import dto.RolDTO;
import dto.TelefonoDTO;
import dto.UsuarioDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author negro
 */
public class ControlUsuarios extends HttpServlet {

    /*
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
        try (PrintWriter out = response.getWriter()) {
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

            } else if (request.getParameter("btnModificar") != null) {
                UsuarioDTO us = new UsuarioDTO();
                us.setIdUsuario(request.getParameter("Usuario"));
                us.setPrimerNombre(request.getParameter("Nombres"));
                us.setPrimerApellido(request.getParameter("Apellidos"));
                us.setEps(Integer.parseInt(request.getParameter("EPS")));
                us.setIdTelefono(Integer.parseInt(request.getParameter("Telefono")));
                us.setDireccion(request.getParameter("Direccion"));
               UsuarioDAO usudao=new UsuarioDAO();
//               String salida=usudao
               ;
                response.sendRedirect("paginas/reportedoce.jsp?sal");
            
            } else if (request.getParameter("btnRegistrar") != null) {
                EpsDTO eps = new EpsDTO();
                eps.setNombre(request.getParameter("EPS"));
                TelefonoDTO tel = new TelefonoDTO();
                tel.setTelefono(request.getParameter("Telefono"));
                RolDTO rol=new RolDTO();
                rol.setDescripcion(request.getParameter("Rol"));
                UsuarioDTO usu = new UsuarioDTO();
                UsuarioDAO usud = new UsuarioDAO();
                usu.setIdUsuario(request.getParameter("Documento"));
                usu.setPrimerNombre(request.getParameter("PNombre"));
                usu.setSegundoNombre(request.getParameter("SNombre"));
                usu.setPrimerApellido(request.getParameter("PApellido"));
                usu.setSegundoApellido(request.getParameter("SApellido"));
                usu.setIdEPS(eps);
                usu.setIdTelefonos(tel);
                usu.setDireccion(request.getParameter("Direccion"));
                usu.setEmail(request.getParameter("Correo"));
                usu.setIdrol(rol);
//                String mensaje = usud.registraUsuarios(usu);
                response.sendRedirect("registrarusuarioscoor.jsp=" + mensaje);
            }
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
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
