/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package job4u.services;

/**
 *
  */
import java.util.List;

public interface IServiceReclamation<T> {
    void ajouter(T t);
    void supprimer(String c);
    void modifier(T t);
    List<T> afficherTous();
    List<T> afficherReclamationsParUser(String nom);
    void modifierStatutReclamation(T t, String nouveauStatut,String role );
    T rechercherReclamationParId(int id);
 
}

