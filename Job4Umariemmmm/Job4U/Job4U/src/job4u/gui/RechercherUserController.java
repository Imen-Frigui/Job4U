/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package job4u.gui;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import job4u.entities.Reclamation;
import job4u.services.ServiceReclamation;


 
public class RechercherUserController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
@FXML
private TextField user;
@FXML
private TableView<Reclamation> tableView;
@FXML
private TableColumn<Reclamation, Integer> idCol;
@FXML
private TableColumn<Reclamation, String> messageCol;
@FXML
private TableColumn<Reclamation, String> typeCol;
@FXML
private TableColumn<Reclamation, String> statutCol;
 
@FXML
private Button searchBtn;
@FXML
public void initialize() {
   
}
@FXML
public void rechercher(ActionEvent event) {
    String idUserText = user.getText();
    if (idUserText == null || idUserText.trim().isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Champ vide");
        alert.setContentText("Veuillez saisir l'identifiant de l'utilisateur.");
        alert.showAndWait();
        return;
    }
    ServiceReclamation b= new ServiceReclamation(); 
      
    List<Reclamation> reclamations = b.afficherReclamationsParUser(idUserText);
    if (reclamations.isEmpty()) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Pas de réclamations");
        alert.setContentText("Il n'y a pas de réclamations pour cet utilisateur.");
        alert.showAndWait();
        return;
    }
    tableView.getItems().setAll(reclamations);
    idCol.setCellValueFactory(new PropertyValueFactory<>("id_reclamation"));
    messageCol.setCellValueFactory(new PropertyValueFactory<>("message"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    statutCol.setCellValueFactory(new PropertyValueFactory<>("statut"));
}
 

}
