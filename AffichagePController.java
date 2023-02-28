/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import entite.Domaine;
import util.DataSource;
import service.ServicePoste;
import entite.Poste;
import entite.RatingControl;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.ServiceDomaine;

/**
 * FXML Controller class
 *
 * @author wissal
 */
public class AffichagePController implements Initializable {

    @FXML
    private ScrollPane scrollpane;
    private ServicePoste sp = new ServicePoste();
    @FXML
    private Label tfid;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> combotri;
    private ServiceDomaine sd = new ServiceDomaine();
    private ImageView[] stars = new ImageView[5];

    /**
     * Initializes the controller class.
     */
    public void table(){
        List<Poste> offres = sp.getAll();
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
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        combotri.setItems(sd.getalls());
        table();
        
    }

    
    
    
    
    private VBox createOffreBox(Poste offre)  {
        VBox box = new VBox();
        ServicePoste sp = new ServicePoste();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(30);
         box.setUserData(offre.getId()); // set the ID as the user data for the VBox


        Label titre = new Label(offre.getTitre());
        
        
        Label comment_total = new Label("Total Commentaires :"+String.valueOf(sp.comments(offre.getId())));
        
       
        
        File imagef = new File(offre.getImg());
        Image image = new Image(imagef.toURI().toString());
        ImageView imm = new ImageView(image);
        Label date = new Label(offre.getDate().toString());
        Label user = new Label(offre.getUser().getNom());
        Label voir = new Label("Cliquez pour Afficher plus ou commentez");
        Label sep = new Label("_________________________________________________________________________________________________");
        
        
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
      user.setStyle("-fx-text-fill : Green;");
      voir.setStyle("-fx-text-fill : Blue;");
        
         voir.setFont(Font.font("Serif", FontWeight.LIGHT, 15));
        user.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        
        user.setWrapText(true);
        imm.setFitWidth(100);
        imm.setFitHeight(100);
        
        box.getChildren().addAll( user,titre,imm,date,comment_total,voir,sep);
        
        
        
        
          box.setOnMouseClicked(event -> {
            try {
                Poste selectedC=sp.getOneById(offre.getId());
                
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("Addcomment.fxml"));
                Parent view_2=loader.load();
                AddcommentController ModifierController=loader.getController();
                
                 ModifierController.getPoste(selectedC);
                 ModifierController.p =selectedC;
                 
                     
                
               
                
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AffichagePController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });


        return box;
    }

    @FXML
    private void tri(ActionEvent event) {
        List<Poste> offres = sp.getAllT(combotri.getValue());
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
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    @FXML
    private void rech(ActionEvent event) {
        List<Poste> offres = sp.getAll(tfrech.getText());
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
        scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
    }

    @FXML
    private void ajj(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("Addposte.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }

    @FXML
    private void afftout(ActionEvent event) {
        table();
    }

    @FXML
    private void mep(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
         fxmlLoader.setLocation(getClass().getResource("Mespostes.fxml"));
          AnchorPane anchorPane;
          anchorPane = fxmlLoader.load();
          Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
    
}
