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
import entities.Reponse;
import services.ServiceReclamation;
import services.ServiceReponse;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
/*import edu.pidev.entities.Categorie;
import edu.pidev.entities.Reclamation;
import edu.pidev.serices.ServiceCategorie;
import edu.pidev.serices.Servicereclamation;*/
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
 
public class AfficherReponseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private TableView<Reponse> ReponseTable;
  
    @FXML
    private TableColumn<Reponse, String> colId;
    @FXML
    private TableColumn<Reponse, String> colMessage;
    @FXML
    private TableColumn<Reponse, String> colDate;
    @FXML
    private TableColumn<Reponse, String> colReclamation;
     
    
    @FXML
    private Button refreshButton;
 
    public void afficher() {
        ServiceReponse b  = new ServiceReponse(); 

  List<Reponse> reponses =  b.afficherTousReponses();
    

          // ajouter les donn�es dans la table
          ObservableList<Reponse> ReclamationObservableList = FXCollections.observableArrayList(reponses);
          ReponseTable.setItems(ReclamationObservableList);

          // lier les colonnes aux propri�t�s de l'objet Categorie
          colId.setCellValueFactory(new PropertyValueFactory<>("id_reponse"));
          colMessage.setCellValueFactory(new PropertyValueFactory<>("message_rep"));
          colDate.setCellValueFactory(new PropertyValueFactory<>("date_rep"));
           
          colReclamation.setCellValueFactory(new PropertyValueFactory<>("statut"));
      }

    
      @FXML
      private void handleRefreshButtonAction(ActionEvent event) {
          afficher();
      }
}
