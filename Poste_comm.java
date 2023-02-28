/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poste_comm;
import entite.Commentaire;
import entite.Domaine;
import entite.Poste;
import entite.User;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import service.ServiceCommentaire;
import service.ServicePoste;
import service.ServiceUser;
import service.ServiceDomaine;
import util.DataSource;


/**
 *
 * @author wissal
 */
public class Poste_comm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       LocalDate today = LocalDate.now();
       ServiceUser ss = new ServiceUser();
       ServiceCommentaire sc= new ServiceCommentaire();
       ServicePoste sp= new ServicePoste();
       ServiceDomaine sd = new ServiceDomaine();
       
       
      int s = sp.comments(1);
       int a = s+5;
       System.out.println(a);
        // TODO code application logic here
    }
    
}
