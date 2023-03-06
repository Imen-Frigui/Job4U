 
package gui;

import java.net.URL;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import entities.Reclamation;
import services.ServiceReclamation;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import entities.Reclamation;
public class SupprimerReclamationController implements Initializable {
    
	@FXML
	private ComboBox<String> comboBoxUtilisateurs;

	private ServiceReclamation serviceReclamation;
	private ObservableList<String> userList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	serviceReclamation = new ServiceReclamation();
        userList = FXCollections.observableArrayList();
        
        setComboBoxItems();
    }    
    
    private void setComboBoxItems() {
        // Retrieve all reclamations and their corresponding users
        List<Reclamation> reclamations = serviceReclamation.afficherTous();
        
        // Add the user names to the list
        for (Reclamation r : reclamations) {
            String nom = r.getNom();
            if (!userList.contains(nom)) {
                userList.add(nom);
            }
        }
        System.out.println(userList);
        // Set the items of the combo box
        comboBoxUtilisateurs.setItems(userList);
    }
 




    
    @FXML
    private void supprimerReclamation(ActionEvent event) throws SQLException {
        String nom = comboBoxUtilisateurs.getValue();
        
        if (nom == null || nom.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Avertissement");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez s�lectionner un utilisateur pour supprimer ses r�clamations.");
            alert.showAndWait();
            return;
        }
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous vraiment supprimer toutes les r�clamations de l'utilisateur " + nom + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
            serviceReclamation.supprimer(nom);
            userList.remove(nom);
            
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Succ�s");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Toutes les r�clamations de l'utilisateur " + nom + " ont �t� supprim�es avec succ�s.");
            successAlert.showAndWait();
        }
    }
}
