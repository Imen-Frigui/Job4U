/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
//package GUI.PostulationController;c
package GUI;

import java.io.IOException;
import static java.time.Clock.system;
import static java.time.InstantSource.system;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class PostulationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
           Parent root= FXMLLoader.load(getClass().getResource("pos.fxml"));
  
           Scene scene =new Scene(root);
           primaryStage.setTitle("Formulaire");
           primaryStage.setScene(scene);
           primaryStage.show();
        } catch (IOException ex) {
            System.out.println("err"+ex.getLocalizedMessage());
        }   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
