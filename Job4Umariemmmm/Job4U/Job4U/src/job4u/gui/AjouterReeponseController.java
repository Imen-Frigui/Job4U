/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package job4u.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

 import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
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
import job4u.entities.Reponse;
import job4u.services.ServiceReclamation;
import job4u.services.ServiceReponse;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
public class AjouterReeponseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
     private ComboBox<String> comboBoxReclamation;

    private ServiceReclamation serviceReclamation;
    private ObservableList<String> reclamationList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    	serviceReclamation = new ServiceReclamation();
        reclamationList = FXCollections.observableArrayList();
        setComboBoxItems();
    }    
  public void setComboBoxItems() {
            System.out.println("setComboBoxItems() method called");

    List<Reclamation> reponses = serviceReclamation.afficherTous();
    for (Reclamation r : reponses) {
        String statut = r.getStatut();
        if (!reclamationList.contains(statut)) {
            reclamationList.add(statut);
        }
    }
    comboBoxReclamation.setItems(reclamationList);

    System.out.println("Reclamation list size: " + reclamationList.size());
}
    
  @FXML
    private TextField date_rep;
    @FXML
    private TextField email;
    @FXML
    private TextArea message_rep;
    @FXML
    private Button btnajouter;
    
private static final String EMAIL_REGEX = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Za-z]{2,4}$";

    @FXML
    private void ajouter(ActionEvent event) throws SQLException { 
        String nom = comboBoxReclamation.getValue();
        //recuperation de donne dans interface
         if (date_rep.getText().isEmpty() || message_rep.getText().isEmpty()) {
        // Affichage d'une alerte en cas de champ vide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs!");
        alert.showAndWait();
    } else if (!isValidDate(date_rep.getText())) {
        // Affichage d'une alerte en cas de saisie de date invalide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez saisir une date valide (format : yyyy-mm-dd)!");
        alert.showAndWait();
    } else if (!isValidEmail(email.getText())) {
        // Affichage d'une alerte en cas de saisie d'email invalide
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez saisir une adresse email valide!");
        alert.showAndWait();
    } else {
        String type1 = date_rep.getText(); 
        String message1 = message_rep.getText();
        String mail=email.getText();
        ServiceReponse b=new ServiceReponse();
        Reponse r1=new Reponse(message1, type1);
        b.ajouterReponse(r1,mail);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("La réponse a été ajoutée avec succès !\nMail bien envoyé à " + mail);
        alert.showAndWait();
        
        // Traitement de la saisie valide
    }  
    }
     
private boolean isValidEmail(String email) {
    Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    return pattern.matcher(email).matches();
}

private boolean isValidDate(String date) {
    try {
        LocalDate.parse(date);
        return true;
    } catch (DateTimeParseException e) {
        return false;
    }
}  
}
