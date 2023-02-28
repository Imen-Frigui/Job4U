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
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import service.ServiceDomaine;
import service.ServicePoste;
import service.ServiceUser;



/**
 * FXML Controller class
 *
 * @author wissal
 */
public class MespostesController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextField tftitre;
    @FXML
    private TextArea tfdesc;
    @FXML
    private ComboBox<String> combodomaine;
    private ServicePoste sp = new ServicePoste();
    private String ImagePath;
    @FXML
    private ImageView img;
    private int idd;

    /**
     * Initializes the controller class.
     */
    public void tabel(){
     List<Poste> offres = sp.getAll(1);
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(30);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        

        int count = 0;
        for (Poste offre : offres) {
            VBox box = createOffreBox(offre);
            
            hBox.getChildren().add(box);
            count++;

            if (count == 1) {
                vBox.getChildren().add(hBox);
                hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.setSpacing(100);
                count = 0;
            }
        }

        if (count > 0) {
            vBox.getChildren().add(hBox);
        }

        scrollpane.setContent(vBox);
        scrollpane.setFitToWidth(true);
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       tabel();
    }
   
    private VBox createOffreBox(Poste offre)  {
        VBox box = new VBox();
        ServicePoste sp = new ServicePoste();
        ServiceDomaine sd= new ServiceDomaine();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
         box.setUserData(offre.getId()); // set the ID as the user data for the VBox


        Label titre = new Label(offre.getTitre());
        
        
        Label comment_total = new Label("Total Commentaires :"+String.valueOf(sp.comments(offre.getId())));
        Label date = new Label(offre.getDate().toString());
        Label user = new Label(offre.getUser().getNom());
        Button bb = new Button();
        bb.setText("Supprimer");
        Label voir = new Label("Click pour modifier");
        Label sep = new Label("_________________________________________________________");

        titre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
      user.setStyle("-fx-text-fill : Green;");
      voir.setStyle("-fx-text-fill : Blue;");
        
         voir.setFont(Font.font("Serif", FontWeight.LIGHT, 15));
        user.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        user.setWrapText(true);
        box.getChildren().addAll( user, titre, date,comment_total,voir,bb,sep);
        
        bb.setOnMouseClicked(event -> {
            
            sp.supprimer(offre.getId());
            tabel();
            
        });
        
          box.setOnMouseClicked(event -> {
                
                idd = (offre.getId());
                Poste selected=sp.getOneById(offre.getId());
                tftitre.setText(selected.getTitre());
                tfdesc.setText(selected.getDesc());
                combodomaine.setItems(sd.getalls());
                File imagef = new File(selected.getImg());
                ImagePath=imagef.toURI().toString();
                Image image = new Image(imagef.toURI().toString());
                img.setImage(image);
         
                
                
              
        });


        return box;
    }

    @FXML
    private void img(ActionEvent event) {
    
    FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        if (SelectedFile != null) {
            ImagePath = "src/resources/"+SelectedFile.getName();
            
            
            
            img.setImage(new Image(new File(ImagePath).toURI().toString()));
        } else {

            ImagePath = "C:/Users/Firas/Desktop/profile.jpg";
            
            img.setImage(new Image(new File(ImagePath).toString()));

        }}

    @FXML
    private void add(ActionEvent event) {
        LocalDate today = LocalDate.now();
        ServiceUser uss = new ServiceUser();
        User uu;
        uu=uss.ChercherParId(1);
         Domaine ddd;
        ddd=new Domaine(combodomaine.getValue().toString());
        Poste p = new Poste(idd,tftitre.getText(),tfdesc.getText(),ImagePath,ddd,java.sql.Date.valueOf(today),uu);
        sp.modifier(p);
        
    }
    
}
    

