/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entities.Societe;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IServiceSociete {
    public void ajouter(Societe s);
     public void modifier(Societe s );
     public void supprimer(Societe s);
     public ArrayList<Societe> afficher();
}
