package job4u.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import job4u.entities.Reponse;
import job4u.services.IServiceReponse;
import job4u.services.ServiceReponse;

public class TestReponse {
    public static void main(String[] args) {
    org.junit.runner.JUnitCore.main(TestReponse.class.getName());
}
    private IServiceReponse<Reponse> service;
    
    @Before
    public void setUp() throws Exception {
        service = new ServiceReponse();
    }

    @After
    public void tearDown() throws Exception {
        service = null;
    }

    @Test
    public void testAjouterReponse() {
        // Create a new Reponse object to add
        Reponse reponse = new Reponse(11, "Test message", "2023-02-26");
        
        // Call the service method to add the Reponse
        service.ajouterReponse(reponse,"dridimaryem124@gmail.com");
        
        // Retrieve the list of all Reponses
        List<Reponse> reponses = service.afficherTousReponses();
        reponse.setMessage_rep("Modified message");
        service.modifierReponse(reponse);
           // Create a new Reponse object to delete
           Reponse reponse1 = new Reponse( 10, "Test message", "2023-02-26");
//        
//        // Call the service method to add the Reponse
       service.ajouterReponse(reponse1,"dridimaryem124@gmail.com");
//        
//        // Call the service method to delete the Reponse
           service.supprimerReponse(reponse1);
//        
        // Check that the list contains the added Reponse
        //assertTrue(reponses.contains(reponse));
    }
//
//    @Test
//    public void testModifierReponse() {
//        // Create a new Reponse object to modify
//        Reponse reponse = new Reponse(1, 1, "Test message", "2023-02-26");
//        
//        // Call the service method to add the Reponse
//        service.ajouterReponse(reponse);
//        
//        // Modify the message
//        reponse.setMessage_rep("Modified message");
//        
//        // Call the service method to modify the Reponse
//        service.modifierReponse(reponse);
//        
//        // Retrieve the list of all Reponses
//        List<Reponse> reponses = service.afficherTousReponses();
//        
//        // Check that the modified Reponse is in the list
//        assertTrue(reponses.contains(reponse));
//        
//        // Check that the message has been modified in the list
//        for (Reponse r : reponses) {
//            if (r.equals(reponse)) {
//                assertEquals("Modified message", r.getMessage_rep());
//            }
//        }
//    }
//
//    @Test
//    public void testSupprimerReponse() {
//        // Create a new Reponse object to delete
//        Reponse reponse = new Reponse(1, 1, "Test message", "2023-02-26");
//        
//        // Call the service method to add the Reponse
//        service.ajouterReponse(reponse);
//        
//        // Call the service method to delete the Reponse
//        service.supprimerReponse(reponse);
//        
//        // Retrieve the list of all Reponses
//        List<Reponse> reponses = service.afficherTousReponses();
//        
//        // Check that the list doesn't contain the deleted Reponse
//        assertFalse(reponses.contains(reponse));
//    }
//
//    @Test
//    public void testAfficherReponsesParReclamation() {
//        // Create two new Reponse objects for the same reclamation
//        Reponse reponse1 = new Reponse(1, 1, "Test message 1", "2023-02-26");
//        Reponse reponse2 = new Reponse(2, 1, "Test message 2", "2023-02-26");
//        
//        // Call the service method to add the Reponses
//        service.ajouterReponse(reponse1);
//        service.ajouterReponse(reponse2);
//        
//        // Retrieve
//    }
}
     