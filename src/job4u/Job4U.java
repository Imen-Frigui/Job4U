/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package job4u;


import entities.Discussion;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.ServiceDiscussion;
import utils.MyDB;


/**
 *
 * @author Imen Frigui
 */
public class Job4U extends Application{
    

    @Override
    public void start(Stage primaryStage)  {
        try {
            primaryStage.initStyle(StageStyle.DECORATED);
            URL fxURL = getClass().getResource("../gui/ChatScreen.fxml");
            FXMLLoader loader = new FXMLLoader(fxURL);
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
        
       // ServiceDiscussion s = new ServiceDiscussion();
       
        //System.out.println(s.Search("ah"));
        
    }

    
}