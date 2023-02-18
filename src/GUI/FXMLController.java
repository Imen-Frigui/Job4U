/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import entities.Discussion;
import java.awt.Insets;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import services.ServiceDiscussion;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class FXMLController implements Initializable {
     @FXML
    private VBox inbox_list;
    
    @FXML
    private TextArea tlresultat;
    
    ServiceDiscussion p = new ServiceDiscussion();
    Discussion convv = new Discussion();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        // TODO
    }    


    @FXML
    private void afficher(ActionEvent event) {
        ServiceDiscussion p = new ServiceDiscussion();
        tlresultat.setText(p.afficher().toString());
        
        
        
    }
 
    
}
