/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CandiatHomeFrontController implements Initializable {

    @FXML
    private MenuItem profil;
    @FXML
    private MenuItem deconnecter;
    @FXML
    private Label id_ID;
    @FXML
    private AnchorPane home;
    @FXML
    private Hyperlink btn_entreprises;
    @FXML
    private Hyperlink lien_postulation;
    @FXML
    private MenuButton menu_compte;
    @FXML
    private Hyperlink btn_jobs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void profil(ActionEvent event) {
    }

    @FXML
    private void deconnecter(ActionEvent event) {
    }

    @FXML
    private void viewEntreprises(ActionEvent event) {
    }

    @FXML
    private void GestionPostulation(ActionEvent event) {
    }

    @FXML
    private void view_jobs(ActionEvent event) {
    }
    
}
