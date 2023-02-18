/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;


import entities.Discussion;
import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ServiceDiscussion;
import utils.MyDB;


/**
 *
 * @author Imen Frigui
 */
public class Job4U {
    

    public static void main(String[] args) throws SQLException {
        
            MyDB db=MyDB.getInstance();
     
            //ServiceUsers sp = new ServiceUsers();
            
            //Discussion di = new Discussion(2,3);
            Discussion di1 = new Discussion(1,3);
            
           // Message m = new Message(18,1,"ok");
            //Message m1 = new Message(17,2,"HI");
            
            ServiceDiscussion sd =new ServiceDiscussion();
           //ServiceMessages sm =new ServiceMessages();
            
//System.out.println(sd.Search("Ch"));
            sd.Add(di1);
           // sm.Add(m);
           //sm.Add(m1);
           //System.out.println(sd.AfficherMessageDiscussion(17));
           //System.out.println(sd.AfficherDernierMess(17));
            //System.out.println(di1.getId_disc());

              
  //      Message m1 = new Message(10,17,3,"Bye");
//System.out.println(m1.getId_mesg());
        //sm.Edit(m1);
    
        System.out.println(sd.afficher());
        //System.out.println(di.getId_disc());
        //System.out.println(di1.getId_disc());

        //System.out.println(sp.afficher());
        
       // launch(args);

    }
    
}