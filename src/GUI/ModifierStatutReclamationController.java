/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import entities.Reclamation;
import services.ServiceReclamation;
 
public class ModifierStatutReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
	private ServiceReclamation serviceReclamation;
	private ObservableList<String> ReclamtionList;
	 @FXML
	    private ComboBox<String> comboBoxReclamation;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     statut.getItems().addAll("Encours" , "Traitee" , "NonTraitee");
     serviceReclamation = new ServiceReclamation();
     ReclamtionList = FXCollections.observableArrayList();
     setComboBoxItems();
    }    
    private void setComboBoxItems() {
        // Retrieve all reclamations and their corresponding users
        List<Reclamation> reclamations = serviceReclamation.afficherTous();
        
        // Add the user names to the list
        for (Reclamation r : reclamations) {
            String nom = r.getNom();
            if (!ReclamtionList.contains(nom)) {
            	ReclamtionList.add(nom);
            }
        }
        System.out.println(ReclamtionList);
        // Set the items of the combo box
        comboBoxReclamation.setItems(ReclamtionList);
    }
      @FXML
    private ComboBox<String> statut;
    
    
    public void modifier  (ActionEvent event) { 
        ServiceReclamation b  = new ServiceReclamation(); 
        Reclamation recl = new Reclamation("reclamation", "testerStatu", "Non traitée",1);
        b.ajouter(recl);
    	if (statut.getSelectionModel().getSelectedItem().isEmpty() ) {
    	    Alert alert = new Alert(AlertType.ERROR);
    	    alert.setTitle("Erreur de saisie");
    	    alert.setHeaderText(null);
    	    alert.setContentText("Veuillez saisir un message valide.");
    	    alert.showAndWait();
    	}else {
         String message1 = statut.getSelectionModel().getSelectedItem()  ; 
         String message2 = comboBoxReclamation.getSelectionModel().getSelectedItem();
         System.out.println(message2);
        b.modifierStatutReclamation(message2, message1, "admin"); 
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Reclamation modifier avec success!");
        alert.showAndWait();
    	}
        
    }
}
