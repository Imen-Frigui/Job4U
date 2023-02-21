/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Entities.Postulation;
import Services.ServicePostulation;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author user
 */
public class PostulationController implements Initializable {

@FXML
private TextField tfaffichage;
@FXML
private Label tfresultat;
TableView<Postulation> tableView = new TableView<>();






 
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void addPostulation(ActionEvent Event){
        
       Postulation p=new Postulation(tfdate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.ajouter(p);
    String value = tfDate.getText();
    if (value.isEmpty() ) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Date is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + value);
            }
    String val = tfSimpleUser.getText();
    if (value.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("SimpleUser is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + val);
            }
    String va_email=tfEmail.getText();
     if (value.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + va_email);
            }
    
    //System.out.println("parameters are not empty");

    
		
    }
     @FXML
    private void deletePostulation(ActionEvent Event){
        
       Postulation p=new Postulation(tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.supprimer(p);
    }
    /*private void modifierPostulation(ActionEvent Event){
        
       Postulation p=new Postulation(tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.modifier(p);
        
       
    }*/
    /* public void deletePerson(int id) throws SQLException {
        personService.deletePerson(id);
    }*/
     @FXML
    private void affichage(ActionEvent Event){
        
       Postulation p=new Postulation(tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
      
    System.out.println( S.afficher());
		
    }
     
}
