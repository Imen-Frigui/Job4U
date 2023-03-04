/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbtest;

import Connn.MyDB;
import Services.ServiceOffre;
import Services.ServiceProject;
import entities.Project;
import entities.offre;
import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.Stage;


/**
 *
 * @author Ahmed
 */
public class DBTest extends Application {

    
    
     @Override
        public void start(Stage primaryStage) {
       try {
           Parent parent = FXMLLoader.load(getClass().getResource("/tableView/tableView1.fxml"));
           Scene scene = new Scene(parent);
          scene.setFill(Color.TRANSPARENT);
           primaryStage.setScene(scene);
           primaryStage.initStyle(StageStyle.TRANSPARENT);
           primaryStage.show();
       }
       catch (IOException ex){
        Logger.getLogger(DBTest.class.getName()).log(Level.SEVERE, null, ex);

       }
        }
    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) throws SQLException {
      /* MyDB db=MyDB.getInstance();
        Statement st;
        Connection con = MyDB.getInstance().getCon();
        try {/*
            DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
            java.sql.Date d1 = (java.sql.Date) df.parse("01-01-1900");
            java.sql.Date d2 = (java.sql.Date) df.parse("01-01-1920");
        offre o = new offre("oussama","touati","6 jour");
        ServiceOffre of = new ServiceOffre();
      //  of.ajouter(o);
       of.supprimer1(3);
        System.out.println(of.afficher());
             st =  con.createStatement();
        /*
        String sql= "Insert Into personne (nom,prenom,agae) "
                + "values ('"+t.getNom()+"','"+t.getPrenom()+"',"+t.getAgae()+");";
            
        */
       
       /* Project p = new Project("Oussama","Wakkad");
        Project p1 = new Project(2,"hamdi","Wakkad");
        System.out.println(p);
        ServiceProject sp = new ServiceProject();
        //String sql= "INSERT INTO `offre`(`nom`, `descrip`, `date_debut`, `date_fin`) VALUES ('oussama','touati','2000-07-20','2005-08-13');";
    //String sql = "INSERT INTO Personne (nom,prenom,age) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"',"+t.getAgae()+");";     
        //st.executeUpdate(sql);
         System.out.println(sp.afficher());
        sp.modifier(p1);
        System.out.println(sp.afficher());*/
        
     //   System.out.println("Insertion ...");
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          launch(args);
       }


}

