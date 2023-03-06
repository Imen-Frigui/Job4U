/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author ILYESS LASS
 */
public class UserMineController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    private TextField user ; 
    @FXML
    void entrez (ActionEvent event ) {
	       ServiceReclamation b  = new ServiceReclamation(); 
	       
	          if (user.getText().isEmpty()) {
		            // Afficher un message d'erreur
		            Alert alert = new Alert(AlertType.ERROR);
		            alert.setTitle("Erreur");
		            alert.setHeaderText("Entrez un nom de User");
		            alert.setContentText("Veuillez entre un nom !!");
		            alert.showAndWait();
		        }
	          
	       String nom=user.getText();
	       List<Reclamation> r=b.afficherReclamationsParUser(nom);
	   	try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("UserInterface.fxml"));

			Parent page2 = loader.load();
			UserInterfaceController gbController = loader.getController();

			gbController.setReclamation(r);
			Scene scene = new Scene(page2);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	       

    	
    }
    
}
