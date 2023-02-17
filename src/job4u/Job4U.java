/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;

import entities.Discussion;
import entities.Message;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceDiscussion;
import services.ServiceMessages;
import services.ServiceUsers;
import utils.MyDB;

/**
 *
 * @author 
 */
public class Job4U {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
            MyDB db=MyDB.getInstance();
     
            ServiceUsers sp = new ServiceUsers();
            
            Discussion di = new Discussion(2,3);
            //Discussion di1 = new Discussion(1,3);
            
            Message m = new Message(17,3,"Hello");
            Message m1 = new Message(17,2,"HI");
            
           ServiceDiscussion sd =new ServiceDiscussion();
            ServiceMessages sm =new ServiceMessages();

            //sd.Add(di);
            sm.Add(m);
           sm.Add(m1);
            //System.out.println(di1.getId_disc());

        
        //sd.Delete(di);
    
        System.out.println(sd.afficher());
        //System.out.println(di.getId_disc());
        //System.out.println(di1.getId_disc());

        System.out.println(sp.afficher());
    }
    
}