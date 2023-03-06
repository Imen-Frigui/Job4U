/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.image.ImageView;
import entities.Reclamation;
import services.ServiceReclamation;
/**
 * FXML Controller class
  
 * @author 
 */
public class DashboradAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
       
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
    private TextField filtree;
     //   ObservableList<Reclamation> ReclamationObservableList = FXCollections.observableArrayList(reclamations);
        
     ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();

    public void show(){
      ServiceReclamation b  = new ServiceReclamation(); 

  reclamations =b.afficherTous();
   
        colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        ReclamationTable.setItems(reclamations);

    }
     @FXML
    void Modifier(MouseEvent event) {
        
     try {
              Parent page1 =  FXMLLoader.load(getClass().getResource("ModifierStatutReclamation.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DashboradAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
   
    
    }
    
    @FXML
    void AjouterReponse (MouseEvent event) {
        
          try {
              Parent page1 =  FXMLLoader.load(getClass().getResource("AjouterReeponse.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DashboradAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
        @FXML
    void AfficherReponse (MouseEvent event) {
        /*
          try {
              Parent page1 =  FXMLLoader.load(getClass().getResource("AfficherReponse.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(DashboradAdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
*/

    }
    
        @FXML
    void Supprimer(MouseEvent event) {
        
       Reclamation selectedLN =  ReclamationTable.getSelectionModel().getSelectedItem();
         if (selectedLN == null) {
        // Afficher un message d'erreur
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Impossible de supprimer la reclamation ");
        alert.setContentText("Veuillez selectionner une reclaamtion � supprimer !");
        alert.showAndWait();
    }
              //System.out.println(selectedLN.getId_b());
      ServiceReclamation bs  = new ServiceReclamation(); 
        bs.supprimer(selectedLN.getNom());
     
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("Reclamation Supprimer!");
        alert.showAndWait();
         alert.showAndWait();
         show();
    }

       

    
     @FXML
    public void handleSearch(KeyEvent event) {
        
        if (event.getCode() == KeyCode.ENTER) {
            String searchText = filtree.getText().trim();
            System.out.println(searchText);
            if (searchText.isEmpty()) {
                ReclamationTable.setItems(reclamations);
            } else {
                ObservableList<Reclamation> filteredList = FXCollections.observableArrayList();
                for (Reclamation b : reclamations) {
                    if (b.getType().toLowerCase().contains(searchText.toLowerCase())||(b.getNom().toLowerCase().contains(searchText.toLowerCase()))) {
                        System.out.println(b.getType());

                        filteredList.add(b);
                    }
                }
                System.out.println(filteredList.toString());
                 ReclamationTable.setItems(filteredList);
            }
        }

    }
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            show();
    }

    @FXML
    private void Stat(MouseEvent event) {
           try {
               	
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("Chart.fxml"));
                   Parent root = loader.load();

                   // Show the Modif.fxml interface
                   Scene scene = new Scene(root);
                   Stage stage = new Stage();
                   stage.setScene(scene);
                   stage.show();
                   } catch (IOException ex) {
                       ex.printStackTrace();

                    }
    }
}
