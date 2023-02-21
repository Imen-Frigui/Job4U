/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxgestionuser;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import javafxgestionuser.InscriptionConnexionController;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import entities.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.ServiceUser;
import utils.MyConnection;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;



/**
 *
 * @author user
 */
public class JavaFXGestionUser extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GestionUsers.fxml"));
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("JobForYou");
        primaryStage.setScene(scene);
            primaryStage.show();
        
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
        
    }
    
}
