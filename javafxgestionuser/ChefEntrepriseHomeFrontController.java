/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import entities.InformationsSupplementaires;
import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.InformationsSupplementairesService;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ChefEntrepriseHomeFrontController implements Initializable {

    @FXML
    private Hyperlink btn_entreprises;
    @FXML
    private Hyperlink lien_postulation;
    @FXML
    private Hyperlink deconnecter;
    @FXML
    private Hyperlink btn_jobs;
    @FXML
    private Hyperlink lien_postulation1;
    @FXML
    private Label id_ID;
    @FXML
    private AnchorPane home;
    @FXML
    private Label mailvalue;
    @FXML
    private Label nomvalue;
    @FXML
    private Label typevalue;
    @FXML
    private Label prenomvalue;
    @FXML
    private Label telvalue;
    @FXML
    private ImageView imageChefEntreprise;
    @FXML
    private Hyperlink updateProfile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void Lien_Logout(ActionEvent event) {
        
          try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InscriptionConnexion.fxml"));
            Parent root = loader.load();
            deconnecter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public User JibliBilMailChefEntreprise(String mail){
        ServiceUser u_service = new ServiceUser();
        InformationsSupplementairesService infoUser= new InformationsSupplementairesService();
        User UserProfile=u_service.ChercherParMail(mail);
        int idUser=UserProfile.getId();
        InformationsSupplementaires infoUserF= infoUser.chercherparid(idUser);
        
        
        System.out.println(UserProfile);
        
          mailvalue.setText(mail);
          nomvalue.setText(UserProfile.getNom());
          typevalue.setText(UserProfile.getRole());
          prenomvalue.setText(UserProfile.getPrenom());
          telvalue.setText(infoUserF.getTell());
          
          imageChefEntreprise.setImage(new Image(infoUserF.getLien_icon()));
        return null;
        
        
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        
    }

  
    
}
