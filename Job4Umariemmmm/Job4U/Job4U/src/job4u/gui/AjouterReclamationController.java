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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import job4u.entities.Reclamation;
import job4u.services.ServiceReclamation;

 
public class AjouterReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private TextField message;
    @FXML
    private TextField type;
    @FXML
    private Button ajouter;
    @FXML
    private Button annulerButton;
    
    @FXML
    private void ajouter(ActionEvent event) { 
        
        //recuperation de donne dans interface
         
        if (message.getText().isEmpty() || type.getText().isEmpty()) {
        	// Affichage d'une alerte en cas de champ vide
        	Alert alert = new Alert(AlertType.ERROR);
        	alert.setTitle("Erreur de saisie");
        	alert.setHeaderText(null);
        	alert.setContentText("Veuillez remplir tous les champs!");
        	alert.showAndWait();
        	}
        else {
            String message1 = message.getText(); 
            String type1 = type.getText();

        //ala base statut est non traitee 
        String   statut = "non traitee" ; 
        //selon mon travaille je veux ajouter user statitc 
        int id =1; 
        Reclamation r = new Reclamation (message1 , type1 ,statut , id   );
        ServiceReclamation b  = new ServiceReclamation(); 
        b.ajouter(r);  
        // Affichage d'une alerte en cas d'ajout réussi
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Ajout réussi");
        alert.setHeaderText(null);
        alert.setContentText("La réclamation a été ajoutée avec succès!");
        alert.showAndWait();
       
    }
        // Clear the text fields
      
        }
    
 // Add an event handler for the "Annuler" button
 
}
 