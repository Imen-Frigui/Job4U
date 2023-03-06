/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import entities.InformationsSupplementaires;
import entities.User;
import gui.ChatController;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceUser;
import services.InformationsSupplementairesService;
import utils.CryptagePwd;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CandiatHomeFrontController implements Initializable {

    @FXML
    private Hyperlink deconnecter;
    @FXML
    private Label id_ID;
    @FXML
    private AnchorPane home;
    @FXML
    private Hyperlink btn_entreprises;
    @FXML
    private Hyperlink btn_jobs;
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
    private ImageView imageFreelencer;
    @FXML
    private Hyperlink updateProfile;
    @FXML
    private Button btn_mofier_Profile;
    @FXML
    private AnchorPane MofierFormulaire;
    @FXML
    private TextField nomvalue1;
    @FXML
    private TextField prenomvalue1;
    @FXML
    private TextField mailvalue1;
    @FXML
    private TextField telvalue1;
    
    
    User U=new User();
    
    int IdGlobale;
    
       String nomM;
        String prenomM;
        String mailM;
        String telM;
    @FXML
    private Hyperlink btn_open_chat;
    @FXML
    private Hyperlink btn_reclamation;
  

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
    
    public User JibliBilMailCandidat(String mail){
        ServiceUser u_service = new ServiceUser();
        InformationsSupplementairesService infoUser= new InformationsSupplementairesService();
        User UserProfile=u_service.ChercherParMail(mail);
        int idUser=UserProfile.getId();
        IdGlobale=idUser;
        InformationsSupplementaires infoUserF= infoUser.chercherparid(idUser);
        
        
        
        System.out.println(UserProfile);
        
          mailvalue.setText(mail);
          nomvalue.setText(UserProfile.getNom());
          typevalue.setText(UserProfile.getRole());
          prenomvalue.setText(UserProfile.getPrenom());
          telvalue.setText(infoUserF.getTell());
          
              imageFreelencer.setImage(new Image(infoUserF.getLien_icon()));
              
              
          
        return null;
        
        
    }

    @FXML
    private void updateProfile(ActionEvent event) {
        MofierFormulaire.setDisable(false);
        MofierFormulaire.setOpacity(1);
        
        
  
        /*
        resetpasswordform.setOpacity(1);
        resetpasswordform.setLayoutX(cnxform.getLayoutX());

        resetpasswordform.setLayoutY(cnxform.getLayoutY());
        resetpasswordform.setDisable(false);
        */
    }

    @FXML
    private void ModifierProfile(ActionEvent event) {
        
         ServiceUser u_service = new ServiceUser();
        
           String nomM= nomvalue1.getText();
        String prenomM=prenomvalue1.getText();
        String mailM=mailvalue1.getText();
        String telM=telvalue1.getText();
        String Password = u_service.ChercherParId(IdGlobale).getPassword();
        String Role =u_service.ChercherParId(IdGlobale).getRole();
        
        InformationsSupplementaires p = new InformationsSupplementaires(IdGlobale, nomM, prenomM, telM);
        InformationsSupplementairesService servP = new InformationsSupplementairesService();
       
        System.out.println("El id el globale taa el user hedha"+IdGlobale);
        User userModif = new User(IdGlobale,nomM, prenomM, mailM,Password,Role);
        System.out.println("min annd EL profile taaa freelancer"+userModif);
        u_service.ModifierUserProfile(userModif);
        
        
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Modification du Profil");
            alert.setHeaderText("Votre profil a été bien modifié ");
            alert.setContentText("Veuillez vous reconnecter !");
            alert.showAndWait();
        
        
    }

    @FXML
    private void openChat(ActionEvent event) {
        
          try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ChatScreen.fxml"));
            Parent root = loader.load();
            ChatController c = new ChatController();
            c.jibliUserByIvate(IdGlobale);
            btn_open_chat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void reclamation(ActionEvent event) {
          try {
                // Load the Modif.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/UserMine.fxml"));
                Parent root = loader.load();

                // Show the Modif.fxml interface
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                
            }
 
    }
    
    
}
