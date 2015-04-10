/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.NotaDTO;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sena
 */
public class NotaDAOTest {
    
    public NotaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insertarTotal method, of class NotaDAO.
     */
//    @Test
//    public void testInsertarTotal() {
//        System.out.println("insertarTotal");
//        float nota1 = 0.0F;
//        float nota2 = 0.0F;
//        float nota3 = 0.0F;
//        NotaDAO instance = new NotaDAO();
//        String expResult = "";
//        String result = instance.insertarTotal(nota1, nota2, nota3);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarNotas method, of class NotaDAO.
//     */
//    @Test
//    public void testListarNotas() {
//        System.out.println("listarNotas");
//        NotaDAO instance = new NotaDAO();
//        LinkedList<NotaDTO> expResult = null;
//        LinkedList<NotaDTO> result = instance.listarNotas();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarbyId method, of class NotaDAO.
//     */
//    @Test
//    public void testListarbyId() {
//        System.out.println("listarbyId");
//        long idUsuario = 0L;
//        NotaDAO instance = new NotaDAO();
//        NotaDTO expResult = null;
//        NotaDTO result = instance.listarbyId(idUsuario);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarReportePer method, of class NotaDAO.
//     */
//    @Test
//    public void testListarReportePer() throws Exception {
//        System.out.println("listarReportePer");
//        int idPer = 0;
//        NotaDAO instance = new NotaDAO();
//        LinkedList<NotaDTO> expResult = null;
//        LinkedList<NotaDTO> result = instance.listarReportePer(idPer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarReporteAct method, of class NotaDAO.
//     */
//    @Test
//    public void testListarReporteAct() {
//        System.out.println("listarReporteAct");
//        NotaDAO instance = new NotaDAO();
//        LinkedList<NotaDTO> expResult = null;
//        LinkedList<NotaDTO> result = instance.listarReporteAct();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insertarNota method, of class NotaDAO.
//     */
//    @Test
//    public void testInsertarNota() {
//        System.out.println("insertarNota");
//        NotaDTO neNota = null;
//        NotaDAO instance = new NotaDAO();
//        String expResult = "";
//        String result = instance.insertarNota(neNota);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of modificarNota method, of class NotaDAO.
//     */
//    @Test
//    public void testModificarNota() throws Exception {
//        System.out.println("modificarNota");
//        NotaDTO newNota = null;
//        NotaDAO instance = new NotaDAO();
//        String expResult = "";
//        String result = instance.modificarNota(newNota);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarNota method, of class NotaDAO.
//     */
    @Test
    public void testEliminarNota() throws Exception {
        System.out.println("eliminarNota");
        int idNota = 2;
        NotaDAO instance = new NotaDAO();
        String expResult = "Nota eliminada";
        String result = instance.eliminarNota(idNota);
        assertEquals(null,expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
