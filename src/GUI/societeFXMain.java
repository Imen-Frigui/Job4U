/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;

import entities.Societe;
import services.ServiceSociete;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.MyConnection;

/**
 *
 * @author user
 */
public class societeFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
            Parent root= FXMLLoader.load(getClass().getResource("societe.fxml"));
            Scene scene =new Scene(root);
            primaryStage.setTitle("Liste des societes");
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
