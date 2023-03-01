/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.test;

import java.util.List;
import job4u.entities.Reclamation;
import job4u.services.IServiceReclamation;
import job4u.services.ServiceReclamation;

/**
 *
 */
public class TestReclamation {
    public static void main(String[] args) {
        IServiceReclamation<Reclamation> service = new ServiceReclamation();
        int id_user = 1;

        // Ajouter une nouvelle réclamation
        Reclamation recl = new Reclamation("Message de test", "Type de test", "Non traitée", id_user);
        service.ajouter(recl);
        System.out.println("Réclamation ajoutée : " + recl);
        int id_user1 = 2;
        Reclamation rec2 = new Reclamation("Erreur ", "Type 3", "Non traitée", id_user1);
        service.ajouter(rec2);

        // Modifier le statut d'une réclamation
         service.modifierStatutReclamation(rec2,"Traitée","admin");
 
        // Afficher toutes les réclamations
        List<Reclamation> reclamations = service.afficherTous();
        System.out.println("Toutes les réclamations : " + reclamations.toString());

        // Afficher les réclamations associées à un utilisateur donné
        List<Reclamation> reclamationsUser = service.afficherReclamationsParUser("Doe");
        System.out.println("Réclamations \n" +
"        System.out.println(\"Réclamatiode l'utilisateur " + id_user + " : " + reclamationsUser);

        // Supprimer une réclamation
         service.supprimer("Doe");
        System.out.println("Réclamation supprimée avec succès !");
    }
}

