/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import com.sun.scenario.effect.impl.prism.PrFilterContext;
import javafxgestionuser.FXMLDocumentController;
import entities.InformationsSupplementaires;
import entities.User;
import services.InformationsSupplementairesService;
import services.ServiceUser;
import utils.CryptagePwd;
import utils.Session;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class AfficherUser1Controller {

    @FXML
    private AnchorPane profildata;

    @FXML
    private ImageView profilimage;

    @FXML
    private Label mailvalue;

    @FXML
    private Label motdepassevalue;

    @FXML
    private Label typevalue;

    @FXML
    private Label nomvalue;

    @FXML
    private Label prenomvalue;

    @FXML
    private Label telvalue;
    @FXML
    private Hyperlink hyperlink_modifier;

    public AfficherUser1Controller() {

    }

    @FXML
    void modifierlink(ActionEvent event) {
    //  profilimage.setImage(new Image("C:\\Users\\user\\Documents\\NetBeansProjects\\JavaFXGestionUser\\src\\Images\\userr.jfif"));
        mailvalue.setOpacity(0);
        TextField mailvalueinput = new TextField();
        mailvalueinput.setLayoutX(mailvalue.getLayoutX());
        mailvalueinput.setLayoutY(mailvalue.getLayoutY());
        mailvalueinput.setText(mailvalue.getText());
        motdepassevalue.setOpacity(0);
        PasswordField motdepasseinput = new PasswordField();
        motdepasseinput.setLayoutX(motdepassevalue.getLayoutX());
        motdepasseinput.setLayoutY(motdepassevalue.getLayoutY());
        nomvalue.setOpacity(0);
        TextField nomvalueinput = new TextField();
        nomvalueinput.setLayoutX(nomvalue.getLayoutX());
        nomvalueinput.setLayoutY(nomvalue.getLayoutY());
        nomvalueinput.setText(nomvalue.getText());
        prenomvalue.setOpacity(0);
        TextField prenomvalueinput = new TextField();
        prenomvalueinput.setLayoutX(prenomvalue.getLayoutX());
        prenomvalueinput.setLayoutY(prenomvalue.getLayoutY());
        prenomvalueinput.setText(prenomvalue.getText());
        telvalue.setOpacity(0);
        TextField telvalueinput = new TextField();
        telvalueinput.setLayoutX(telvalue.getLayoutX());
        telvalueinput.setLayoutY(telvalue.getLayoutY());
        telvalueinput.setText(telvalue.getText());
        profildata.getChildren().addAll(mailvalueinput, motdepasseinput, nomvalueinput, prenomvalueinput, telvalueinput);
        Button modifierbutton = new Button("modifier votre compte");
        modifierbutton.setLayoutX(600);
        modifierbutton.setLayoutY(400);

        profildata.getChildren().add(modifierbutton);
        /////
      
        String Mail = mailvalueinput.getText();
        String MotdePasse = motdepasseinput.getText();
        String Nom = nomvalueinput.getText();
        String Prenom = prenomvalueinput.getText();
        String Tell = telvalueinput.getText();
        String role=typevalue.getText();
        ServiceUser us = new ServiceUser();
        int Id = us.ChercherParMail(Mail).getId();
     
        ////
        modifierbutton.setOnAction((ActionEvent actionEvent) -> {
            if (motdepasseinput.getText().compareTo("") == 0 || mailvalueinput.getText().compareTo("") == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("un ou plusieurs champs sont manquants");
                alert.setHeaderText("un ou plusieurs champs sont manquants ");
                alert.setContentText("les champs e-mail et mot de passe sont obligatoires !");
                alert.showAndWait();
            }
            //int user_id, String nom, String prenom, String tell

            else{
            InformationsSupplementaires infoedit = new InformationsSupplementaires(Id, Nom, Prenom, Tell);
            User useredit = new User(Id,nomvalueinput.getText(), prenomvalueinput.getText(), mailvalueinput.getText(), motdepasseinput.getText(), role);
                System.out.println("min aand el afficherUSer1 Modifier"+useredit);
                System.out.println("min aand el afficherUSer1 Modifier"+useredit);
           
            useredit.setMail(mailvalueinput.getText());
           
            ServiceUser u_service = new ServiceUser();
            InformationsSupplementairesService i_service = new InformationsSupplementairesService();
                System.out.println("el user mdofiéé"+useredit);
             System.out.println("el user mdofiéé"+useredit);
            u_service.ModifierUser(useredit);
            i_service.update2(infoedit);
            System.out.println(useredit);
                System.out.println("min aand el afficherUSer1 Modifier"+useredit);
            System.out.println(infoedit.toString());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Profil modifié");
            alert.setHeaderText("Profil modifié");
            alert.setContentText("Profil modifié");
            alert.showAndWait();
            }
        });
}
    

    void MyFunction(String nom, String prenom, String Tell, String mail, String password, String role , String lien_icon ) {

        mailvalue.setText(mail);
        motdepassevalue.setText(password);
        typevalue.setText(role);

        nomvalue.setText(nom);

        prenomvalue.setText(prenom);

        telvalue.setText(Tell);
        System.out.println("min aand afficher1Users"+lien_icon);
        System.out.println(lien_icon);
        System.out.println(lien_icon);
        //profilimage.setImage(new Image(getClass().getResourceAsStream(lien_icon)));
     //    profilimage.setImage(new Image(String.valueOf(new File(lien_icon))));
       profilimage.setImage(new Image(lien_icon));

    }
/*
    User JibliUser(String nom, String prenom, String mail, String password, String role) {
        ServiceUser us = new ServiceUser();

        User u = us.ChercherParMail(mail);

        return u;

    }
*/
    public void initialize(URL url, ResourceBundle rb) {

    }

}
