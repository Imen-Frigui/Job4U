/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entities.Postulation;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IServicePostulation {
     public void ajouter(Postulation p);
     public void modifier(Postulation p);
     public void supprimer(Postulation p);
     public ArrayList<Postulation> afficher();
     public void supprimer1(int id_pos);
     public void Modifier(Postulation p);
}
