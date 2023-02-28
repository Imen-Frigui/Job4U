/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Domaine;
import entite.Poste;
import entite.User;
import java.io.File;
import java.io.IOException;
import service.ServiceDomaine;
import service.ServicePoste;
import service.ServiceUser;
import util.DataSource;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wissal
 */
public class AddposteController implements Initializable {

    @FXML
    private ComboBox<String> combodomaine;
    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tfdesc;
    @FXML
    private ImageView tfimage;
    @FXML
    private Button btn_select_image;
    private String ImagePath;
    private ServiceDomaine sd = new ServiceDomaine();
    @FXML
    private Label image_link;
    @FXML
    private ImageView ben;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ImagePath = "";
        combodomaine.setItems(sd.getalls());
      
        
        
    }    

    @FXML
    private void btn_image_action(ActionEvent event) {
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
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        
        
            LocalDate today = LocalDate.now();
            ServiceUser sa = new ServiceUser();
            ServiceDomaine sd = new ServiceDomaine();
            ServicePoste sp = new ServicePoste();
            Poste p = new Poste();
            p.setTitre(tftitre.getText());
            p.setDesc(tfdesc.getText());
            p.setImg(ImagePath.toString());
            Domaine ddd;
            ddd=new Domaine(combodomaine.getValue().toString());
            p.setDomaine(ddd);
            p.setDate(java.sql.Date.valueOf(today));
            p.setUser(sa.ChercherParId(1));
            
            sp.ajouter(p);
            
            FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("AffichageP.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
        
        
    
    
}}
