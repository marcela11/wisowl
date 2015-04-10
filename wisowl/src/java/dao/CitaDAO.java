/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CitaAcademicaDTO;
import dto.NotaDTO;
import dto.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import utilidades.Conexion;

/**
 *
 * @author negro
 */
public class CitaDAO {
    
    public CitaDAO(){
    cnn=Conexion.getInstance();
    }
    
    Connection cnn;
    ResultSet rs = null;
    PreparedStatement pst = null;
   
    private int resultado = 0;
    public LinkedList<CitaAcademicaDTO> listarCitas(){
       LinkedList<CitaAcademicaDTO> citasDocentes=new LinkedList();      
       String sql="" ;
        return null;
    }
            
}
