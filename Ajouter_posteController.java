/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jobforu.gui;

import jobforu.troc.model.poste;
import edu.jobforu.services.posteCRUD;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wissal bahri 
 */
public class Ajouter_posteController implements Initializable {

    @FXML
    private TextField fxdate_publication;
    
    @FXML
    private TextField fxregion;
    @FXML
    private TextField fxcategorie;
  
    
    @FXML
    private TextField fxtitre;
    @FXML
    private Button ajouter_post;
    @FXML
    private TextField fxcv;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter_post(ActionEvent event) {
        String date_publication = fxdate_publication.getText();
        
        String region = fxregion.getText();
        String categorie = fxcategorie.getText();
         String cv = fxcv.getText();
       
         String titre = fxtitre.getText();
        
         poste p = new poste(date_publication, region, categorie, cv , titre);
        posteCRUD post = new posteCRUD();
        post.ajouterposte(p);
        Alert alert = new Alert(AlertType.INFORMATION);

        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("poste insérée avec succés!");
        alert.show();
        String value=fxregion.getText();
                String value1=fxdate_publication.getText();
                String value2=fxcategorie.getText();
                String value3=fxcv.getText();
                String value4=fxtitre.getText();


        if (region.isEmpty() || region.isEmpty() || region.isEmpty()|| region.isEmpty()|| region.isEmpty()) {
                
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("id_pos is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + value);
            }
        String value5=fxdate_publication.getText();
        if (region.isEmpty() ) {
                
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("id_pos is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + value5);
            }
   
    
		
    }
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

/**
 *
 * @author user
 */


    
    
    
}
