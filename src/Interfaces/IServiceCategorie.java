/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entities.Categorie;
import java.util.ArrayList;

/**
 *
 * @author mariem
 */
public interface IServiceCategorie {
    public void ajouter(Categorie c);
     public void modifier(Categorie c );
     public void supprimer(Categorie c);
     public ArrayList<Categorie> afficher();
}
