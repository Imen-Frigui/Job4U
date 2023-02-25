/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxgestionuser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.util.stream.*;
import java.util.stream.Stream;
import services.ServiceUser;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import interfaces.UserInterface;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import utils.MyConnection;
import services.InformationsSupplementairesService;
import entities.InformationsSupplementaires;
import java.io.File;
import javafx.stage.Stage;
import javafxgestionuser.AfficherUser1Controller;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPwd;
    @FXML
    private ComboBox<String> comboRole;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Button btn_modifier;
    @FXML
    private Button btn_afficher;
    @FXML
    private Button btn_supprimer;
    @FXML
    private TableView<User> tableUsers;
    @FXML
    private TableColumn<User, Integer> id;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> password;
    @FXML
    private TableColumn<User, String> role;
    @FXML
    private Button btn_refresh;
    @FXML
    private TextField tfChercher;
    @FXML
    private Hyperlink gestionuser;
    @FXML
    private Hyperlink gestion_stat;
    @FXML
    private Hyperlink State_Freelancer;
    @FXML
    private Hyperlink btn_login;
    @FXML
    private Hyperlink btn_afficher_profile;
    @FXML
    private Hyperlink deconnecter;
    @FXML
    private Button btn_enregistrer;

    //hedhom eli tra fihom hedhom declarations graphiques taaa eli mawjoud fil scene buolder
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] items = {"Chef Entreprise", "Candidat"};
        comboRole.getItems().addAll(items);
        comboRole.setOnAction(event -> {
            String data = comboRole.getSelectionModel().getSelectedItem().toString();});

            ServiceUser us = new ServiceUser();
            ObservableList<User> list = FXCollections.observableArrayList();
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            email.setCellValueFactory(new PropertyValueFactory<>("mail"));
            password.setCellValueFactory(new PropertyValueFactory<>("password"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
            //nkalmo el service wa naamlo definition des attributs fi wisqt lista mnadhma 
            //ou akal liste hedhiki nkalmo aleha el service bich isob mil base de donnes saba wahda
            //el lista tw t3abbet 
            //nsobo akal lista ou las9oha kama hiya fil tableView 

            list.addAll(us.afficher());
            tableUsers.setItems(list);//baad ma 3ammart el lista bich t7otha fil tableau fil graphique
            tableUsers.setEditable(true);//t9olo les element fil tableau etidable wella la!,
            password.setCellFactory(TextFieldTableCell.forTableColumn());
            email.setCellFactory(TextFieldTableCell.forTableColumn());
           // role.setCellFactory(TextFieldTableCell.forTableColumn());
            
            
            
         
            
            

            ObservableList selectedCells = tableUsers.getSelectionModel().getSelectedCells();
            selectedCells.addListener(new ListChangeListener() {
                //el listner el role mta3o ifi9 bik wa9tech thot el curseurs 3ala ligne du tableau
                @Override
                public void onChanged(ListChangeListener.Change c) {
                    User uselected = (User) tableUsers.getSelectionModel().getSelectedItem();//wa9teli t7ot el sourie 3ala ligne fil tableau (wdli hiya el user )selectionne
                    System.out.println("selected value " + uselected);

                }

            });
        calculerNombreParRole();
        TrierParNom();
        
        
    }

    @FXML
    private void ajouter(ActionEvent event) {
        System.out.println("Bontton Ajouter Lu");
        ServiceUser us = new ServiceUser();
       //Integer idu = Integer.parseInt(tfId.getText());
        String Nom = tfNom.getText();
        String Prenom = tfPrenom.getText();
        String Email = tfEmail.getText();
        String Password = tfPwd.getText();
        String Role22 = comboRole.getValue();
        User u = new User(Nom, Prenom,Email,Password,Role22);
        System.out.println(u);
        us.ajouter2(u);
        refresh(event);

    }

    @FXML
    private void modifier(ActionEvent event) {
        
        System.out.println("Bontton Modif Lu");
        ServiceUser us = new ServiceUser();

        int idu = tableUsers.getSelectionModel().getSelectedItems().get(0).getId();
        System.out.println(idu);
        String Nom = tfNom.getText();
        String Prenom = tfPrenom.getText();
        String Email = tfEmail.getText();
        String Password = tfPwd.getText();
        String Role22 = comboRole.getValue();
        User u = new User(idu,Nom, Prenom, Email, Password, Role22);
        
        us.ModifierUser(u);

    }

    @FXML
    private void afficher(ActionEvent event) {
        try {
//nkalmo el service taa el user wel information_supp ta3o
//ou nchercho alih bil id 
//ne5dho el image eli insereha
//baad ma5dhina les donnes mil tableau lezem naa3ayto lel scene jdida elli hiya afficherUser(Profile) tafffichi eli mwjoud fil tableau wel table taa infos_supp eli hiya table o5ra
//yaani nal3abo 3ala deux tables mil base bich naffichiew minhom
//el infos supp zeyda 3al user bil tel wel image , el nom wel prenom inajmo yatbadlo 3ala user barka 
            User uselected = (User) tableUsers.getSelectionModel().getSelectedItem();
            ServiceUser us = new ServiceUser();
            InformationsSupplementairesService InfosService = new InformationsSupplementairesService();
            int id = uselected.getId();
            
            User u1 = us.ChercherParId(id);
            System.out.println(u1);
            System.out.println(u1);
                       int idS = us.ChercherParMail(u1.getMail()).getId();
                       System.out.println(idS);
                       System.out.println(idS);
                       System.out.println(idS);
            InformationsSupplementaires inf1 = InfosService.chercherparid(idS);
            
  
            
            System.out.println(inf1);
            System.out.println(inf1);
            System.out.println(inf1);
///            System.out.println(inf1.getLien_icon());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherUser1.fxml"));
            Parent root = loader.load();
            AfficherUser1Controller ctrl = loader.getController();
            System.out.println("Controller yeess");
         //b7okem lezemna non9lo el data mil scene el scene , aamalna fonction thez les datas hedhoukom lel scene el jdide
         //lezmek ta3ayat nefs el fonction 8adika bich  trecuperihom 8adi
         
            ctrl.MyFunction(uselected.getNom(), uselected.getPrenom(), inf1.getTell(), uselected.getMail(), uselected.getPassword(), uselected.getRole(),"/Images/home.png");
          //  ctrl.JibliUser(uselected.getNom(), uselected.getPrenom(), uselected.getMail(), uselected.getPassword(), uselected.getRole());

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(AfficherUser1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void supprimer(ActionEvent event) {
        //bich t3ayat lel service bich ifas5 el user selectionne 3abra el boutton supprimer (ActionEvent )

        System.out.println("Bontton supprimer Lu");
        ServiceUser us = new ServiceUser();
            int idu = tableUsers.getSelectionModel().getSelectedItems().get(0).getId();
        
        //inti hne keteb int idu fi wistha Ineteger hedheka alech howa ma9rach el button
        //ena tw raditha Integer idu bich mchetli ou maadesh t7ot el int idu
        us.SupprimerUser(idu);
        refresh(event);

        // refrech();
    }

    @FXML
    private void refresh(ActionEvent event) {

        System.out.println("Bontton refresh Lu");
        ServiceUser us = new ServiceUser();
        ObservableList<User> list = FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        list.addAll(us.afficher());

        tableUsers.setItems(list);
//refresh hiya nafsha afficher (actualiser)
    }

    @FXML
    private void chercher(KeyEvent event) {
        System.out.println("chercher ");
        ServiceUser us = new ServiceUser();
        ObservableList<User> liste = FXCollections.observableArrayList();

        liste.addAll(us.ChercherParMail(tfChercher.getText()));

        tableUsers.setItems(liste);

        System.out.print("list value \n " + liste);

    }

    @FXML
    private void clickMouse(MouseEvent event) {

        //clickMouse hiya wa9teli tenzel 3ala ligna du tableau yodhourlek nefs les attributes eli inti selectionthom fil les TextFields
        int id = tableUsers.getSelectionModel().getSelectedItems().get(0).getId();
        String nom = tableUsers.getSelectionModel().getSelectedItems().get(0).getNom();
        String prenom = tableUsers.getSelectionModel().getSelectedItems().get(0).getPrenom();
        String mail = tableUsers.getSelectionModel().getSelectedItems().get(0).getMail();
        String password = tableUsers.getSelectionModel().getSelectedItems().get(0).getPassword();
        String role = tableUsers.getSelectionModel().getSelectedItems().get(0).getRole();
   
        this.tfNom.setText(nom);
        this.tfPrenom.setText(prenom);
        this.tfEmail.setText(mail);
        this.tfPwd.setText(password);

    }

    @FXML
    private void afficherProfile(ActionEvent event) {
//hawka ena deja aamal fonction afficher el fou9 , hedhi eli aamaltha zeyda
    }

    @FXML
    private void deconnecter(ActionEvent event) {
        try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("InscriptionConnexion.fxml"));
            Parent root = loader.load();
            deconnecter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calculerNombreParRole(){
        
        int nbreCandidats=0;
        int nbreChefEntreprises=0;
        
          ServiceUser us = new ServiceUser();
        ObservableList<User> list = FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        list.addAll(us.afficher());
        for (User user : list) {
            if ("Candidat".equals(user.getRole())) {
                nbreCandidats+=1;
                
            }
            if ("Chef Entreprise".equals(user.getRole())) {
                nbreChefEntreprises+=1;
            }
        }
        System.out.println(nbreCandidats);
        System.out.println(nbreChefEntreprises);
        
    }

    @FXML
    private void On_stats_users(ActionEvent event) {
        
           try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("StatsUsers.fxml"));
            Parent root = loader.load();
            deconnecter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void TrierParNom(){
          ServiceUser us = new ServiceUser();
        ObservableList<User> list = FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        list.addAll(us.afficher());
       
        System.out.println(list);
        
    }

    @FXML
    private void saveFile(ActionEvent event) {
        
             ServiceUser us = new ServiceUser();
        ObservableList<User> list = FXCollections.observableArrayList();
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("mail"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
        list.addAll(us.afficher());
        
        FileChooser fileChooser = new FileChooser();
        
          File file = fileChooser.showSaveDialog(new Stage());
        if(file != null){
            saveSystem(file, list);
        }
    }

     public void saveSystem(File file, ObservableList<User> list ){
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(list.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
