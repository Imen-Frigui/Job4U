/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package job4u.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import job4u.entities.Reclamation;
import job4u.services.ServiceReclamation;
 
public class ModifierStatutReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    private TextField   statut;
    @FXML
    
    public void modifier  (ActionEvent event) { 
        ServiceReclamation b  = new ServiceReclamation(); 
        Reclamation recl = new Reclamation("reclamation", "testerStatu", "Non traitÃ©e",1);
        b.ajouter(recl);
    	if (statut.getText().isEmpty()) {
    	    Alert alert = new Alert(AlertType.ERROR);
    	    alert.setTitle("Erreur de saisie");
    	    alert.setHeaderText(null);
    	    alert.setContentText("Veuillez saisir un message valide.");
    	    alert.showAndWait();
    	}else {
         String message1 = statut.getText()  ; 
     
        

        
        b.modifierStatutReclamation(recl, message1, "admin"); 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Reclamation modifier avec succès!");
        alert.showAndWait();
    	}
        
    }
}
