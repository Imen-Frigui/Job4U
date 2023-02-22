/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jobforu.interfaces;

import jobforu.troc.model.poste;
import java.util.List;

public interface InterfaceCRUD {

    public void ajouterposte(poste p);
   
    

    public void modifierposte(poste p);

   
    public void supprimerposte(int id);

    public List<poste> afficherposte();

}
