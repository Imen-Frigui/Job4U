/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package job4u.services;
 
import java.util.List;
public interface IServiceReponse<R> {
    // Ajouter une réponse à la base de données
    public void ajouterReponse(R reponse,String email);

    // Supprimer une réponse de la base de données
    public void supprimerReponse(R reponse);

    // Modifier une réponse dans la base de données
    public void modifierReponse(R reponse);

    // Récupérer toutes les réponses de la base de données
    public List<R> afficherTousReponses();

    // Récupérer toutes les réponses associées à une réclamation donnée
    public List<R> afficherReponsesParReclamation(int id_reclamation);
}

