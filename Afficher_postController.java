/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jobforu.gui;

import edu.jobforu.interfaces.InterfaceCRUD;
import jobforu.troc.model.poste;
import edu.jobforu.services.posteCRUD;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author wissal bahri
 */
public class Afficher_postController implements Initializable {

    @FXML
    private ListView<poste> afficherpost;
    @FXML
    private Button supprimer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListView<poste> list1 = afficherpost;
        InterfaceCRUD inter = new posteCRUD();
        List<poste> list2 = inter.afficherposte();
        for (int i = 0; i < list2.size(); i++) {
            poste p = list2.get(i);
            list1.getItems().add(p);

    }   
 } 

    @FXML
    private void supprimer_poste(ActionEvent event) {
        
         ListView<poste> list = afficherpost;
        InterfaceCRUD inter = new posteCRUD();
        int selectedIndex = list.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            poste p = list.getSelectionModel().getSelectedItem();
            System.out.println(p.getId_poste());
            inter.supprimerposte(p.getId_poste());
            list.getItems().remove(selectedIndex);
        } else {
            System.out.println("Veuillez sélectionner une poste  à supprimer.");
        }
    }
 } 
    

