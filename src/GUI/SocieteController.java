/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import entities.Postulation;
import entities.Societe;
import services.ServiceSociete;
import services.ServicePostulation;
import utils.MyConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import services.ServiceSociete;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SocieteController implements Initializable {
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tftel;
     @FXML
    private TextField tfdomaine;
      @FXML
    private TextField tfimage;
    private Button supprimer;
    private Button modifier;
  private String ImagePath;
  private String NameImage;
    @FXML
  private ImageView sos_image;
  @FXML
    private TableView<Societe> tablesos;
    @FXML
    TableColumn<Postulation, String>nomcolumn  = new TableColumn<>("nom");
    @FXML
    TableColumn<Postulation, String> adressecolumn = new TableColumn<>("adresse");
    @FXML
    TableColumn<Postulation, String> emailcolumn = new TableColumn<>("email");
    @FXML
    TableColumn<Postulation, String> telcolumn = new TableColumn<>("tel");
    @FXML
    TableColumn<Postulation, String> domainecolumn = new TableColumn<>("domaine");
    @FXML
    private ImageView sosimage;
    @FXML
    private Hyperlink gestionuser;
    @FXML
    private Hyperlink State_Freelancer;
    @FXML
    private Hyperlink gestionsociete;
    @FXML
    private Hyperlink deconnecter;
/*
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     /* @FXML
    private void insert_image(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Ajouter une Image");
      
        File SelectedFile = fc.showOpenDialog(null);
       ImageView sos_image = new ImageView();
       
        if (SelectedFile != null) {
              ImagePath = "src/resources/"+SelectedFile.getName();
              NameImage =SelectedFile.getName();
              System.out.println("logo ::"+SelectedFile.getName());
              System.out.println(""+ImagePath);
              
           sos_image.setImage(new Image(new File(ImagePath).toURI().toString()));
       
        }else {

            ImagePath = "C:/Users/user/Documents/NetBeansProjects/Job4U/src/ressources/logo(2).png";
            System.out.println(ImagePath);
            sos_image.setImage(new Image(new File(ImagePath).toString()));

        }
        
    }*/
      @FXML
    private void img(ActionEvent event) {
    
    FileChooser fc = new FileChooser();
        File SelectedFile = fc.showOpenDialog(null);
        ImageView sos_image = new ImageView();
        if (SelectedFile != null) {
            ImagePath = "src/resources/"+SelectedFile.getName();
            
            
            
            sos_image.setImage(new Image(new File(ImagePath).toURI().toString()));
        } else {

            ImagePath = "src/ressources/logo(2).png";
            
            sos_image.setImage(new Image(new File(ImagePath).toString()));

        }}
    
    
      
    public ObservableList<Societe> list1=FXCollections.observableArrayList();
    Connection connection;
    Statement ste;
    @FXML
     public ObservableList<Societe> afficher(ActionEvent event){
        try {
            connection= MyConnection.getInstance().getCnx();
            ste= (Statement) connection.createStatement();
            String req_select="SELECT * FROM `societe`";
            
            java.sql.ResultSet res =  ste.executeQuery(req_select);
            
            while (res.next()) {
                Societe s = new Societe(
                        res.getString("nom"),
                         res.getString("adresse"),
                        res.getString("email"),
                        res.getString("tel"),
                        res.getString("domaine"),
                        res.getString("sos_image")
                       
                       
                );
                list1.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SocieteController.class.getName()).log(Level.SEVERE, null, ex);

            
        
        }
                
         TableColumn<Societe, String>nomcolumn  = new TableColumn<>("nom");   
        nomcolumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TableColumn<Societe, String> adressecolumn = new TableColumn<>("adresse");
        adressecolumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        TableColumn<Societe, String> emailColumn = new TableColumn<>("email");
        emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Societe, String> telcolumn = new TableColumn<>("tel");
        telcolumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
        TableColumn<Societe, String> domainecolumn = new TableColumn<>("domaine");
        domainecolumn.setCellValueFactory(new PropertyValueFactory<>("domaine"));
        tablesos.setItems(list1);
        
        return list1;
        
        
        
        
    
}
     @FXML
    private void addsociete(ActionEvent event) {
        Societe s=new Societe((tfnom.getText()),tfadresse.getText(),tfemail.getText(),tftel.getText(),tfdomaine.getText(),tfimage.getText());
       ServiceSociete Sos=new ServiceSociete();
       Sos.ajouter(s);
    }
     
     
       @FXML
    private void deleteSociete(ActionEvent event) {
      //  Societe s=new Societe((tfnom.getText()),tfadresse.getText(),tfemail.getText(),tftel.getText(),tfdomaine.getText(),tfimage.getText());
         System.out.println("mil champs"+tfnom.getText());
       ServiceSociete Sos=new ServiceSociete ();
           System.out.println("mil champs"+tfnom.getText());
      Sos.supprimer(tfnom.getText());
    
    }

    @FXML
    private void modifierSociete(ActionEvent event) {
         Societe s=new  Societe((tfnom.getText()),tfadresse.getText(),tfemail.getText(),tftel.getText(),tfdomaine.getText(),tfimage.getText());
       ServiceSociete Sos=new ServiceSociete();
       Sos.modifier(s.getNom());
       
    }
     public void affichage() {
   

       ObservableList<Societe> list1 = FXCollections.observableArrayList();
       
            nomcolumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            adressecolumn .setCellValueFactory(new PropertyValueFactory<>("adresse"));
            emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
            telcolumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
            domainecolumn.setCellValueFactory(new PropertyValueFactory<>("domaine"));
            
            //list.addAll(list.afficher());
            tablesos.setItems(list1);
            tablesos.setEditable(true);
            nomcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
            adressecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
            emailcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
            telcolumn.setCellFactory(TextFieldTableCell.forTableColumn());
            domainecolumn.setCellFactory(TextFieldTableCell.forTableColumn());
         
    }

  


    @FXML
    private void Refresh(ActionEvent event) {
        affichage();
    }

    @FXML
    private void GoToGestionSciete(ActionEvent event) {
    }

    @FXML
    private void deconnecter(ActionEvent event) {
    }
}
