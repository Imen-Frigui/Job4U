/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import services.ServiceProject;
import entities.Project;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AjouterProjetController implements Initializable {

    @FXML
    private TextField nomProj;
    @FXML
    private TextField socProj;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addProjet(MouseEvent event) {
       
        ServiceProject sp = new ServiceProject();
         String nom = nomProj.getText();
         String soc = socProj.getText();
         if (nom.isEmpty() || soc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();}
            else {
       Project p = new Project(nom,soc);
       sp.ajouter(p);   
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }}
    

    @FXML
    private void projetClose(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    }
    
