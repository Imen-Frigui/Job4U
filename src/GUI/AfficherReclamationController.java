/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import entities.Reclamation;
import services.ServiceReclamation;
 
public class AfficherReclamationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private TableView<Reclamation> ReclamationTable;
  
    
    @FXML
    private TableColumn<Reclamation, String> colMessage;
    @FXML
    private TableColumn<Reclamation, String> colType;
    @FXML
    private TableColumn<Reclamation, String> colStatut;
    @FXML
    private TableColumn<Reclamation, String> colUser;
    
    @FXML
    private Button refreshButton;

    // la m�thode qui r�cup�re les donn�es et les affiche dans la table
  public void afficher() {
      ServiceReclamation b  = new ServiceReclamation(); 

List<Reclamation> reclamations =  b.afficherTous();
  

        // ajouter les donn�es dans la table
        ObservableList<Reclamation> ReclamationObservableList = FXCollections.observableArrayList(reclamations);
        ReclamationTable.setItems(ReclamationObservableList);

        // lier les colonnes aux propri�t�s de l'objet Categorie
         
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("Nom"));
    }

    // la m�thode qui r�cup�re les donn�es depuis la base de donn�es
  


    // la m�thode qui est appel�e quand on clique sur le bouton "Actualiser"
    @FXML
    private void handleRefreshButtonAction(ActionEvent event) {
        afficher();
    }
    
}
