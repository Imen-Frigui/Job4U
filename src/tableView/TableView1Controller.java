/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import utils.MyConnection;
import services.ServiceOffre;
import entities.DataSingelton;
import entities.InformationsSupplementaires;
import entities.User;
import interfaces.IServiceOffre;
import java.sql.Connection;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafxgestionuser.InscriptionConnexionController;
import services.InformationsSupplementairesService;
import services.ServiceUser;

import javafxgestionuser.ChefEntrepriseHomeFrontController;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class TableView1Controller implements Initializable {

    @FXML
    private TableView<offre> offTable;
    @FXML
    private TableColumn<offre, String> idCol;
    @FXML
    private TableColumn<offre, String> nomCol;
    @FXML
    private TableColumn<offre, String> dureeCol;
    @FXML
    private TableColumn<offre, String> descCol;

    ObservableList listM;
    DataSingelton data= DataSingelton.getInstance();
   
    int index;
    offre offr;
    @FXML
    private TextField lId;
    @FXML
    private TextField lNom;
    @FXML
    private TextField lDesc;
    @FXML
    private TextField lDuree;
    @FXML
    private Hyperlink btn_entreprises;
    @FXML
    private Hyperlink lien_postulation;
    @FXML
    private Hyperlink btn_jobs;
    @FXML
    private Hyperlink deconnecter;
    @FXML
    private AnchorPane home;
    @FXML
    private Button btn_actualiser;
    @FXML
    private Hyperlink back_to_profile;
    
    
    String Email2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
      
    }    
    @FXML
    private void getItem(MouseEvent event) {
        
        index=offTable.getSelectionModel().getSelectedIndex();
        /*
        lId.setText(idCol.getCellData(index).toString());
        lNom.setText(nomCol.getCellData(index).toString());
        lDesc.setText(descCol.getCellData(index).toString());
        lDuree.setText(dureeCol.getCellData(index).toString());
*/
        
        int id = offTable.getSelectionModel().getSelectedItems().get(0).getId();
        String nom = offTable.getSelectionModel().getSelectedItems().get(0).getNom();
        String desc = offTable.getSelectionModel().getSelectedItems().get(0).getDesc();
        String duree = offTable.getSelectionModel().getSelectedItems().get(0).getDuree();
        data.setNom(nom);
        data.setDescrip(desc);
        data.setDuree(duree);
        
        this.lId.setText(String.valueOf(id));
        this.lNom.setText(nom);
        this.lDesc.setText(desc);
        this.lDuree.setText(duree);

    }
    
          
    
      public User JibliBilMailChefEntreprise1(String mail){
        ServiceUser u_service = new ServiceUser();
        InformationsSupplementairesService infoUser= new InformationsSupplementairesService();
        User UserProfile=u_service.ChercherParMail(mail);
        Email2=mail;
        int idUser=UserProfile.getId();
        InformationsSupplementaires infoUserF= infoUser.chercherparid(idUser);
        
        
       
        return null;
        
        
    }

    @FXML
    private void goOffre(MouseEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/ajouterOffre.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableView1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goProjet(MouseEvent event) {
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/ajouterProjet.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableView1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iClose(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void iDelete(MouseEvent event) {
        
        
           int id = offTable.getSelectionModel().getSelectedItems().get(0).getId();
        index = offTable.getSelectionModel().getFocusedIndex();
        System.out.println("index to supprimer"+id);
        ServiceOffre of = new ServiceOffre();
        of.supprimer1(id);
        refresh();
        
        /*    System.out.println("Bontton supprimer Lu");
        ServiceUser us = new ServiceUser();
        int idu = tableUsers.getSelectionModel().getSelectedItems().get(0).getId();

        //inti hne keteb int idu fi wistha Ineteger hedheka alech howa ma9rach el button
        //ena tw raditha Integer idu bich mchetli ou maadesh t7ot el int idu
        us.SupprimerUser(idu);
        refresh(event);*/
        
    }


    public void refresh(){
        ServiceOffre so = new ServiceOffre();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        dureeCol.setCellValueFactory(new PropertyValueFactory<>("duree"));
        
        listM= so.afficher1();
        offTable.setItems(listM);
    }
    private void oRef(MouseEvent event) {
        
        refresh();
    }

    @FXML
    private void onSave(MouseEvent event) {
        ServiceOffre sp = new ServiceOffre();
         int number = Integer.parseInt(lId.getText());
         String nom = lNom.getText();
         String desc = lDesc.getText();
          String duree = lDuree.getText(); 
              System.out.println(number);
              System.out.println(nom);
              System.out.println(desc);
              System.out.println(duree);
          
         if (nom.isEmpty() || desc.isEmpty() || duree.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
         }else {
       offre p = new offre(number,nom,desc,duree);
       sp.modifier(p);
           refresh(); 
    }
    }

    private void goUp(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/Update.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableView1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    }

    @FXML
    private void refresh_offre(ActionEvent event) {
        refresh();
    }

    @FXML
    private void backToProfile(ActionEvent event) {
        
         try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/javafxgestionuser/ChefEntrepriseHomeFront.fxml"));
            Parent root = loader.load();
            back_to_profile.getScene().setRoot(root);
            
                 ChefEntrepriseHomeFrontController ctrl = loader.getController();
                User UGamma = ctrl.JibliBilMailChefEntreprise(Email2);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
