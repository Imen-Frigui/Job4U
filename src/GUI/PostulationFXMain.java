/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;

import java.io.IOException;
import static java.time.Clock.system;
import static java.time.InstantSource.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class PostulationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
           Parent root=FXMLLoader.load(getClass().getResource("Postulation.fxml"));
           Scene scene =new Scene(root);
           primaryStage.setTitle("Formulaire");
           primaryStage.setScene(scene);
           primaryStage.show();
        } catch (IOException ex) {
            System.out.println("err"+ex.getMessage());
        
        
        }   
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
            
            
            
  
        
        
    }

    
}
