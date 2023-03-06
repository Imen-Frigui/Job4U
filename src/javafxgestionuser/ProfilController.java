
package javafxgestionuser;

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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.commons.io.FilenameUtils;

public class ProfilController {

    @FXML
    private Label id_ID;

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
    void modifierlink(ActionEvent event) {

    }

    public void initialize(URL url, ResourceBundle rb) {

    }

    void MyFunction(String nom, String prenom, String tell, String mail, String password, String role) {

        mailvalue.setText(mail);
        motdepassevalue.setText(password);
        typevalue.setText(role);

        nomvalue.setText(nom);

        prenomvalue.setText(prenom);

        telvalue.setText(role);

    }

}
