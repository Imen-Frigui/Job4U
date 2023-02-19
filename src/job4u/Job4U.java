/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;

import Entities.Reclamation;
import Services.ServiceReclamation;
import Utils.MyDB;

/**
 *
 * @author mariem
 */
public class Job4U {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      MyDB db=MyDB.getInstance();
        Reclamation r = new Reclamation ("helpss","helpplzs", "12/12/2020");
      ServiceReclamation S=new ServiceReclamation ();
      // S.ajouter(r);
      S.modifier1(13, r);
       System.out.println(S.afficher());
      
      
    }
    
}
