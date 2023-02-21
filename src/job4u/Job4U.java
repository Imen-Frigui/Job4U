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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Job4U {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            MyDB db=MyDB.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date date = formatter.parse("02/20/2024");
            Postulation P = new Postulation(date,"1524","5");
            ServicePostulation S=new ServicePostulation ();
            /*S.ajouter(P);*/
            /*S.modifier(P);*/
            //S.supprimer(P);
            System.out.println(S.afficher());
            /*S.supprimer(P)*/
            Societe S1= new Societe("2023","152@h4","hjkfj");
            ServiceSociete Sos=new ServiceSociete ();
            /*Sos.ajouter(S1);*/
            /*System.out.println(Sos.afficher());*/
        } catch (ParseException ex) {
            Logger.getLogger(Job4U.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
      
      
       
       
      
      
    }
    
}
