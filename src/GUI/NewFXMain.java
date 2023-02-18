/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;

import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.MyDB;

/**
 *
 * @author GO BRO
 */
public class NewFXMain extends Application {
                MyDB db=MyDB.getInstance();

    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root =FXMLLoader.load(getClass().getResource("chatBox.fxml"));
            Scene scene =new Scene(root);
            
            primaryStage.setTitle("Workshop");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            //Stage
        } catch (IOException ex) {
            System.out.println("Err"+ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
