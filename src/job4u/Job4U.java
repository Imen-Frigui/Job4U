/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;

import Entities.Postulation;
import Entities.Societe;
import Services.ServicePostulation;
import Services.ServiceSociete;
import Utils.MyDB;

/**
 *
 * @author user
 */
public class Job4U {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      MyDB db=MyDB.getInstance();
      Postulation P = new Postulation(6,"2020","1524","5");
      ServicePostulation S=new ServicePostulation ();
      //S.ajouter(P);
      //S.modifier(P);
      //S.supprimer(P);
       System.out.println(S.afficher());
       /*S.supprimer(P)*/
      Societe S1= new Societe("2023","152@h4","hjkfj","rrrr","tttt");
      ServiceSociete Sos=new ServiceSociete ();
      //Sos.ajouter(S1);
      //Sos.modifier(S1);
      //Sos.supprimer(S1);
      //System.out.println(Sos.afficher());
     
      
      
      
       
       
      
      
    }
    
}
