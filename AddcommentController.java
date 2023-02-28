/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entite.Commentaire;
import entite.Poste;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import service.ServiceCommentaire;
import service.ServiceDomaine;
import service.ServicePoste;
import service.ServiceUser;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author wissal
 */
public class AddcommentController implements Initializable {

    @FXML
    private TextArea descposte;
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private TextArea tfdesc;
     Poste p;
    @FXML
    private Label tftitre;
    private ServiceCommentaire sc = new ServiceCommentaire();
    
    public static int idd;
    @FXML
    private AnchorPane imganch;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Button aff;
    private Boolean b=false;
    /**
     * Initializes the controller class.
     */
    public void table(){
         List<Commentaire> offres = sc.getAll(idd);
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        

        int count = 0;
        for (Commentaire offre : offres) {
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
     public void tablem(){
         List<Commentaire> offres = sc.getAllm(1,idd);
        VBox vBox = new VBox();
        
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);
        

        HBox hBox = new HBox();
         
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(100);//
        

        int count = 0;
        for (Commentaire offre : offres) {
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
        table();
         Image image = new Image("file:/C:/Users/Ghass/Desktop/img.jpg");
BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));
Background background = new Background(backgroundImage);
AnchorPane anchorPane = new AnchorPane();
imganch.setBackground(background);
imganch.setPrefWidth(300);
imganch.setPrefHeight(200);

ImageView imageView = new ImageView(image);
imageView.setFitWidth(anchorPane.getPrefWidth());
imageView.setFitHeight(anchorPane.getPrefHeight());

imganch.getChildren().add(imageView);
        
        
    }
    
    
    private VBox createOffreBox(Commentaire offre)  {
        VBox box = new VBox();
        
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
         box.setUserData(offre.getId()); // set the ID as the user data for the VBox

        Label user = new Label(offre.getUser().getPrenom()+":");
        Label titre = new Label(offre.getDesc());
        TextField tfmodif= new TextField();
        
       Button bb = new Button();
       Button bbm = new Button();
        Label sep = new Label("______________________________________________________________________");
       bb.setText("Supprimer");
       bbm.setText("modifier");
       
        
     
       
        user.setStyle("-fx-text-fill : Green;");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
      
        box.getChildren().addAll(user,titre);
        if (b){
            tfmodif.setVisible(true);
            tfmodif.setEditable(true);
            
            
            box.getChildren().add(bb);
            box.getChildren().add(bbm);
            box.getChildren().add(tfmodif);
            
            
            
        }
        box.getChildren().add(sep);
        bb.setOnMouseClicked(event -> {
            if(b)
            {sc.supprimer(offre.getId());
            table();
            ;}
        });
        bbm.setOnMouseClicked(event -> {
            
            sc.modifier(offre.getId(),tfmodif.getText());
            table();
            
        });
        return box;
    }
        // TODO
       void getPoste(Poste u){
        
        descposte.setText(u.getDesc());
       tftitre.setText(u.getTitre());
      idd=u.getId();
      
        p =  (u);
        
        
    }

    @FXML
    private void comment(ActionEvent event) {
         LocalDate today = LocalDate.now();
        ServiceUser sa = new ServiceUser();
        
        ServiceCommentaire sp = new ServiceCommentaire();
       Commentaire P = new Commentaire();
        
        P.setDesc(tfdesc.getText());
       
       P.setPoste(p);
       P.setDate(java.sql.Date.valueOf(today));   
        P.setUser(sa.ChercherParId(1));
        
        sp.ajouter(P);
     table();
     tfdesc.clear();
    }

    @FXML
    private void aff(ActionEvent event) {
        table();
        b=false;
    }

    @FXML
    private void affv(ActionEvent event) {
        tablem();
        b=true;
    }
    
}
