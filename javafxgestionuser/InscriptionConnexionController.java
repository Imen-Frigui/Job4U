/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import entities.InformationsSupplementaires;
import entities.User;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;
import utils.CryptagePwd;
import org.apache.commons.validator.routines.EmailValidator;
import services.InformationsSupplementairesService;
import utils.MailAPI3;
import javafxgestionuser.PageAcceuilController;
import javafxgestionuser.CandiatHomeFrontController;

/**
 * FXML Controller class
 *
 * @author user
 */
public class InscriptionConnexionController implements Initializable {

    @FXML
    private TextField inscription_email;
    @FXML
    private PasswordField inscription_mot_de_passe;
    @FXML
    private PasswordField inscription_repeter_mot_de_passe;
    @FXML
    private AnchorPane cnxform;
    @FXML
    private TextField connexion_email;
    @FXML
    private PasswordField connexion_mot_de_passe;
    @FXML
    private Button cnxbutton;
    private int falsepassword = 3;
    @FXML
    private Text passwordfalsemessage;
    @FXML
    private Hyperlink resetpassword;
    @FXML
    private AnchorPane resetpasswordform;
    @FXML
    private Button btn_crea_co;
    @FXML
    private TextField emailresetvalue;
    @FXML
    private AnchorPane doublepasswordform;
    @FXML
    private Button btn_crea_co1;
    @FXML
    private PasswordField resetpasswordvalue1;
    @FXML
    private PasswordField resetpasswordvalue2;
    @FXML
    private AnchorPane codeveirform;
    @FXML
    private Button btn_crea_co2;
    String code = genererCode();
    @FXML
    private TextField codealpha;
    @FXML
    private Button btn_inscrire;
    private User resetUser;
    @FXML
    private TextField tfTell;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private ImageView User_image;
    InformationsSupplementaires c = new InformationsSupplementaires();
    @FXML
    private Button btn_image;
    @FXML
    private Label lbl_code;
    private String ImagePath;
    private String NameImage;
 
    InformationsSupplementaires p = new InformationsSupplementaires();

    /**
     * Initializes the controller class.
     */
    @FXML
    private void inscription(ActionEvent event) {
        //email validator hiya library hadhra bech bich testi les emails est ce que s7a7 wella 8Altine
        //fil inscription naayto lel service
        //idheken el email eli da5lo el user vide ou bien le mot de passe vide ==> to5rjelna Alert
        //el Alert hiya widget feha titre,ou Header text et le contenue textuel
        //kelmet shoew and wait maaneha odhherli ou stanani hata line el user yanzal 3al OK
        EmailValidator validator = EmailValidator.getInstance();
        ServiceUser us = new ServiceUser();
        if (inscription_email.getText().compareTo("") == 0 || inscription_mot_de_passe.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("un ou plusieurs champs sont manquants");
            alert.setHeaderText("un ou plusieurs champs sont manquants ");
            alert.setContentText("les champs e-mail et mot de passe sont obligatoires !");
            alert.showAndWait();
        } else if (validator.isValid(inscription_email.getText()) == false) {
            //idheken hat el email bil 8alat ou mahouch mawjoud deja fil base de donnes
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adresse mail non valid ");
            alert.setHeaderText("Adresse mail non valid ");
            alert.setContentText("");
            alert.showAndWait();
            inscription_email.clear();

        } else if (inscription_mot_de_passe.getText().compareTo(inscription_repeter_mot_de_passe.getText()) != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            //idhakan les mot de passses ezouz mahoumch kifkif
            alert.setTitle("probleme de verification de mot de passe");
            alert.setHeaderText("probleme de verification de mot de passe");
            alert.setContentText("les champs ''mot de passe'' et ''repeter votre mot de passe'' doivent être identiques  !");
            alert.showAndWait();
            //clear maaneha fasa5 eli ken ketbo el user
            inscription_mot_de_passe.clear();
            inscription_repeter_mot_de_passe.clear();
        } else {
            String hashedPassword = CryptagePwd.hashpw(inscription_mot_de_passe.getText(), CryptagePwd.gensalt());

            String Nom = tfNom.getText();
            String Prenom = tfPrenom.getText();
            String Email = inscription_email.getText();
            String Password = inscription_mot_de_passe.getText();
            String Role22 = "none";
            User u2 = new User(Nom, Prenom, Email, Password, Role22);

            //lawajna 3al user bil email ou iraja3li user objet keemel bil les attributs ta3o el kooll
            InformationsSupplementairesService information_ss = new InformationsSupplementairesService();
            //3ayatna lel info sups services
            //information_ss.AjouterInformation(new InformationsSupplementaires(userforInformation.getId()));
            us.ajouter2(u2);
            //ajoutina el user fil info_supp b7okem da5al el image ou noumro el telifoun
            //ki naamlo inscrption raho mayatzedech fil table user 5ater howa deja mawjoud min 3and el admine
            //raho yetzed fil table infos_supps
            //el user inajam yaamal inscrption fi ey lahdha ou ibadal ismo ou la9abo amma el id yo93ed howa bido (The NickName Law)
            int id = us.ChercherParMail(Email).getId();
            System.out.println(id);
            System.out.println(id);
            System.out.println(id);
            System.out.println(id);
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
            String tell = tfTell.getText();

            InformationsSupplementaires IS = new InformationsSupplementaires(id, nom, prenom, tell, "/Images/"+NameImage);
            information_ss.AjouterInformation(IS);
            //alert de confirmation eli el user jawo behi
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inscription terminée  ");
            alert.setHeaderText("Bienvenue dans notre application ");
            alert.setContentText("Bienvenue dans notre application, vous pouvez maintenant vous connecter");
            alert.showAndWait();

            connexion_email.setText(inscription_email.getText());
            connexion_mot_de_passe.setText(inscription_mot_de_passe.getText());
            inscription_email.clear();
            inscription_mot_de_passe.clear();
            inscription_repeter_mot_de_passe.clear();
        }
    }

    @FXML
    private void connecter(ActionEvent event) {
        ServiceUser us = new ServiceUser();
//el logine
        if (connexion_email.getText().compareTo("") == 0 || connexion_mot_de_passe.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("un ou plusieurs champs sont manquants");
            alert.setHeaderText("un ou plusieurs champs sont manquants ");
            alert.setContentText("les champs e-mail et mot de passe sont obligatoires !");
            alert.showAndWait();
            return;
//el admine aando deja el email ou pwd b7okm howa aabed barka
        } else if (connexion_email.getText().equals("hamzaAdmine@gmail.com") && connexion_mot_de_passe.getText().equals("admine123")) {

            try {
                //ki nda5al bes7i7 el email wel pwd ihezeni lel dashboard ta3o
                FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionUsers.fxml"));
                Parent root = loader.load();
                cnxbutton.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (us.ChercherParMail(connexion_email.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("compte introuvable");
            alert.setHeaderText("votre adresse mail est introuvable");
            alert.setContentText("merci de remplir notre formulaire d'inscription ");
            alert.showAndWait();
            return;
        }

        User u = us.ChercherParMail(connexion_email.getText());

        if (!connexion_mot_de_passe.getText().equals(u.getPassword())) {
//hedheya systeme de suspension (suspendre fi wa9t mou3ayan) tsir wa9telli le mot de passe 8alat
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("compte introuvable");
            alert.setHeaderText("mot de passe incorrect");
            alert.setContentText("mot de passe incorrect \n nombre des essais : " + falsepassword);
            alert.showAndWait();
            falsepassword--;
            if (falsepassword == 0) {
                cnxbutton.setDisable(true);
                Timer chrono = new Timer();

                chrono.schedule(new TimerTask() {
                    int time = 60;

                    @Override
                    public void run() {

                        passwordfalsemessage.setText("Compte Verrouillé , \n Réessayez dans " + time + "s");

                        time--;
                        if (time == 0) {
                            cnxbutton.setDisable(false);
                            passwordfalsemessage.setText("");
                            chrono.cancel();
                            falsepassword = 3;
                        }
                    }

                }, new Date(), 1000);
            }

        } else if (u.getRole().equals("none")) {
            try {
                //hedhi tsir wa9t el intergation
                boolean test;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PageAcceuil.fxml"));
                Parent root = loader.load();
                connexion_email.getScene().setRoot(root);

                PageAcceuilController ctrl = loader.getController();

                ctrl.setEmail(u.getMail());
                User Ualpha = ctrl.JibliUser2(u.getMail());
                us.ModifierUser(Ualpha);
                System.out.println("Min 3and el login" + Ualpha);
            } catch (IOException ex) {
                Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (u.getRole().compareTo("Candidat") == 0) {
            try {
                //hedhi tsir wa9t el intergation
                FXMLLoader loader = new FXMLLoader(getClass().getResource("CandiatHomeFront.fxml"));
                Parent root = loader.load();
                connexion_email.getScene().setRoot(root);

                CandiatHomeFrontController ctrl = loader.getController();
                User Ubeta = ctrl.JibliBilMailCandidat(u.getMail());

            } catch (IOException ex) {
                Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (u.getRole().compareTo("Chef Entreprise") == 0) {
            try {
                //hedhi tsir wa9t el intergation
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefEntrepriseHomeFront.fxml"));
                Parent root = loader.load();
                connexion_email.getScene().setRoot(root);

                ChefEntrepriseHomeFrontController ctrl = loader.getController();
                User UGamma = ctrl.JibliBilMailChefEntreprise(u.getMail());
            } catch (IOException ex) {
                Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @FXML
    private void resetpassword(ActionEvent event) {

        cnxform.setDisable(true);
        cnxform.setOpacity(0);
        resetpasswordform.setOpacity(1);
        resetpasswordform.setLayoutX(cnxform.getLayoutX());

        resetpasswordform.setLayoutY(cnxform.getLayoutY());
        resetpasswordform.setDisable(false);
    }

    @FXML
    private void RécuprationPwdUser(ActionEvent event) {
        //idhakan el user nezel 3al forgot pwd 
        ServiceUser us = new ServiceUser();
        if (us.ChercherParMail(emailresetvalue.getText()) == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("compte introuvable");
            alert.setHeaderText("votre adresse mail est introuvable");
            alert.setContentText("merci de remplir notre formulaire d'inscription ");
            alert.showAndWait();

        } else {

            String message = code;
            lbl_code.setText(message);

            try {
//temchi bes7i7 ou jawha behi

                String subject = "Votre code est :  ";
                //  to subject body
                String messagecode = "Votre code de récupération est " + code;

                MailAPI3 mailing = new MailAPI3();

                mailing.sendEmail(emailresetvalue.getText(), subject, messagecode.toString());  
             
                lbl_code.setText(messagecode);
                codeveirform.setDisable(false);
                codeveirform.setOpacity(1);
                resetpasswordform.setOpacity(0);
                resetpasswordform.setDisable(true);
                codeveirform.setLayoutX(resetpasswordform.getLayoutX());

                codeveirform.setLayoutY(resetpasswordform.getLayoutY());
                resetUser = us.ChercherParMail(emailresetvalue.getText());
                lbl_code.setText(message);
            } catch (Exception ex) {
                Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    String genererCode() {

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 7;
        Random random = new Random();
//generation d'un code aleatoire
        String code = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return code;

    }

    @FXML
    private void verifcode(ActionEvent event) {
        System.out.println("le code est :" + code);
        System.out.println("le code est :" + code);
        System.out.println("le code est :" + code);

        if (codealpha.getText().compareTo(code) != 0) {
            System.out.println(code);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("code invalid");
            alert.setHeaderText("code non valid ");
            alert.setContentText(" ");
            alert.showAndWait();

        } else {
            System.out.println(code);
            codeveirform.setDisable(true);
            codeveirform.setOpacity(0);
            doublepasswordform.setLayoutX(codeveirform.getLayoutX());

            doublepasswordform.setLayoutY(codeveirform.getLayoutY());
            doublepasswordform.setOpacity(1);
            doublepasswordform.setDisable(false);
        }
    }

    @FXML
    private void updatemotdepasse(ActionEvent event) {
        if (resetpasswordvalue1.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("probleme de verification de mot de passe");
            alert.setHeaderText("probleme de verification de mot de passe");
            alert.setContentText("le champs mot de passe est obligatoire !");
            alert.showAndWait();

        } else if (resetpasswordvalue1.getText().compareTo(resetpasswordvalue2.getText()) != 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("probleme de verification de mot de passe");
            alert.setHeaderText("probleme de verification de mot de passe");
            alert.setContentText("les champs ''mot de passe'' et ''repeter votre mot de passe'' doivent être identiques  !");
            alert.showAndWait();
            resetpasswordvalue1.clear();
            resetpasswordvalue2.clear();
        } else {
            ServiceUser us = new ServiceUser();
            resetUser.setPassword(CryptagePwd.hashpw(resetpasswordvalue1.getText(), CryptagePwd.gensalt()));
            us.ModifierUser(resetUser);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("mot de passe modifié ");
            alert.setHeaderText("mot de passe modifié ");
            alert.setContentText("mot de passe modifié  !");
            alert.showAndWait();
            connexion_email.setText(resetUser.getMail());
            resetUser = new User();

            doublepasswordform.setDisable(true);
            doublepasswordform.setOpacity(0);
            cnxform.setDisable(false);
            cnxform.setOpacity(1);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    @FXML
    private void insert_image(ActionEvent event) {

        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            User_image.setImage(image);
            String uniqueid = UUID.randomUUID().toString();
            System.out.println("\n" + uniqueid);

            System.out.println(selectedFile.getPath());
            String extension = FilenameUtils.getExtension(selectedFile.getAbsolutePath());

            Path tmp = Files.move(Paths.get(selectedFile.getPath()),
                    Paths.get("C:/Utilisateurs/user/Documents/NetBeansProjects/JavaFXGestionUser/src/Images " + uniqueid + "." + extension));
            System.out.print(tmp);

            c.setLien_icon( uniqueid + "." + extension);

        } catch (IOException ex) {
            System.out.print(ex.getMessage());

        }
    }
     */
    
    /*
    
       FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            ImagePath = "src/resources/"+SelectedFile.getName();
            
            image_link.setText(ImagePath);
            
            tfimage.setImage(new Image(new File(ImagePath).toURI().toString()));
        } else {

            ImagePath = "C:/Users/Firas/Desktop/profile.jpg";
            image_link.setText("C:/Users/Firas/Desktop/profile.jpg");
            tfimage.setImage(new Image(new File(ImagePath).toString()));

        }
    */

    @FXML
    private void insert_image(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Ajouter une Image");
      
        File SelectedFile = fc.showOpenDialog(null);
       
       
        if (SelectedFile != null) {
              ImagePath = "src/Images/"+SelectedFile.getName();
              NameImage =SelectedFile.getName();
              System.out.println("hedhi esm el image eli bich tlasa9ha maal el path ::"+SelectedFile.getName());
              System.out.println("min aand el InscriptionConnexion"+ImagePath);
              
            User_image.setImage(new Image(new File(ImagePath).toURI().toString()));
       
        }else {

            ImagePath = "C:/Users/user/Desktop/profile.jpg";
            System.out.println(ImagePath);
            User_image.setImage(new Image(new File(ImagePath).toString()));

        }
        
    }
}

