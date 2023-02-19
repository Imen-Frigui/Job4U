/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entities.Reclamation;
import java.util.ArrayList;

/**
 *
 * @author mariem
 */
public interface IServiceReclamation {
     public void ajouter(Reclamation r);
     public void modifier(Reclamation r);
     public void supprimer(Reclamation r);
     public ArrayList<Reclamation> afficher();
}
