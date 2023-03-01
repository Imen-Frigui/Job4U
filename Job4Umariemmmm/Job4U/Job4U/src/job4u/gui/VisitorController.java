/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package job4u.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class VisitorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    @FXML
    public void openModifInterface1(ActionEvent event) {
        try {
            // Load the Modif.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterReclamation.fxml"));
            Parent root = loader.load();

            // Show the Modif.fxml interface
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openModifInterface2(ActionEvent event) {
        try {
            // Load the Modif.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherReclamation.fxml"));
            Parent root = loader.load();

            // Show the Modif.fxml interface
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openModifInterface3(ActionEvent event) {
        try {
            // Load the Modif.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RechercherUser.fxml"));
            Parent root = loader.load();

            // Show the Modif.fxml interface
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openModifInterface4(ActionEvent event) {
        try {
            // Load the Modif.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerReclamation.fxml"));
            Parent root = loader.load();

            // Show the Modif.fxml interface
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void openModifInterface5(ActionEvent event) {
        try {
            // Load the Modif.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReclamation.fxml"));
            Parent root = loader.load();

            // Show the Modif.fxml interface
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
