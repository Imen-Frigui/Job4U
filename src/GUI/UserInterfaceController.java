/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

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
import utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * FXML Controller class
 *
  */
public class UserInterfaceController implements Initializable {
	 private Connection cnx = MyConnection.getInstance().getCnx();
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
	     
 	     ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();
	       ServiceReclamation b  = new ServiceReclamation(); 

	     public void show(){

	    
	         colMessage.setCellValueFactory(new PropertyValueFactory<>("message"));
	         colType.setCellValueFactory(new PropertyValueFactory<>("type"));
	         colStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
 	         ReclamationTable.setItems(reclamations);

	     }
	     //private List<Reclamation> reclamationss;
	     public void setReclamation(List<Reclamation> r) {
	    	 reclamations.addAll(r);
	         System.out.println("bouti"+r.toString());
	         ReclamationTable.setItems(reclamations);
	     }
	     
	     @FXML
	     void Modifier(MouseEvent event) {
                 /*
	      try {
	               Parent page1 =  FXMLLoader.load(getClass().getResource("ModifierReclamation.fxml"));
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
	     void AjouterReclamation (MouseEvent event) {
	         /*
	           try {
	               Parent page1 =  FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
	                 Scene scene = new Scene(page1);
	                 Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	                 stage.setScene(scene);
	                 stage.show();
	             } catch (IOException ex) {
	                 Logger.getLogger(DashboradAdminController.class.getName()).log(Level.SEVERE, null, ex);
	             }
*/
	     }
	     String nomUtilisateur;
	     @FXML
		   void Supprimer(MouseEvent event) {
	    	 Reclamation selectedLN =  ReclamationTable.getSelectionModel().getSelectedItem();
	    	 if (selectedLN == null) {
	    	     // Afficher un message d'erreur
	    	     Alert alert = new Alert(AlertType.ERROR);
	    	     alert.setTitle("Erreur");
	    	     alert.setHeaderText("Impossible de supprimer la reclamation ");
	    	     alert.setContentText("Veuillez sÃ©lectionner une reclamation à supprimer!");
	    	     alert.showAndWait();
	    	 } else {
	    	     ServiceReclamation bs = new ServiceReclamation();
	    	     String nomUtilisateur = null;

	    	     // Connexion à la base de données
	    	     try {
	    	         // Requête SQL pour récupérer le nom des utilisateurs ayant une réclamation correspondant à la condition spécifiée
	    	         String query = "SELECT u.Nom FROM reclamation r JOIN user u ON r.id_user = u.Id WHERE r.message = ?";
	    	         PreparedStatement statement = cnx.prepareStatement(query);
	    	         statement.setString(1, selectedLN.getMessage());
	    	         System.out.println(selectedLN.getMessage());
	    	         ResultSet resultSet = statement.executeQuery();

	    	         // Parcours des résultats pour afficher les noms des utilisateurs
	    	         while (resultSet.next()) {
	    	             nomUtilisateur = resultSet.getString("Nom");
	    	             System.out.println(nomUtilisateur);
	    	         }
	    	     } catch (Exception ex) {
	    	         Logger.getLogger(UserInterfaceController.class.getName()).log(Level.SEVERE, null, ex);
	    	     }

	    	     bs.supprimer(nomUtilisateur);

	    	     Alert alert = new Alert(Alert.AlertType.INFORMATION);
	    	     alert.setTitle("information");
	    	     alert.setHeaderText(null);
	    	     alert.setContentText("Reclamation Supprimer!");
	    	     alert.showAndWait();
	    	     ReclamationTable.getItems().remove(selectedLN);
	    	     show();
	    	 }
	     }
	         @FXML
	         private TextField filtree;
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
	                         if (b.getType().toLowerCase().contains(searchText.toLowerCase())) {
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
    
}
