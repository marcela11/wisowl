/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.NotaDTO;
import dto.UsuarioDTO;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author negro
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
     UsuarioDTO usu = new UsuarioDTO();

//         NotaDTO n = new NotaDTO();
//        n.setFechaNota("2015-02-12");
//        n.setNota1(4.5f);
//        n.setNota2(5f);
//        n.setNota3(3.7f);
////        n.setIdEstu(23232233238);
//        n.setObservacion("cjdhvjbedvjb");
//        NotaDAO nr = new NotaDAO();
//        System.out.println(nr.insertarNota(n));
     
     
     NotaDAO n = new NotaDAO();
        System.out.println(n.eliminarNota(3));
       
    }
    
}
