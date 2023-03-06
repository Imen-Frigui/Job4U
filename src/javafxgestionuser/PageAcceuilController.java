/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import entities.User;
import java.awt.Event;
import java.awt.event.ActionEvent;
import services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafxgestionuser.InscriptionConnexionController;
import org.apache.pdfbox.Loader;
import utils.Session;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PageAcceuilController implements Initializable {

    @FXML
    private ImageView clk_img_candiat;
    @FXML
    private ImageView clk_img_entreprise;
    public String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    static int Roletest = 2;
    static int ClickImage = 2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  ServiceUser us = new ServiceUser();
        Roletest = 2;
        ClickImage = 2;
        System.out.println(Roletest);
        System.out.println(getEmail());

    }

    @FXML
    public int goToFreelancer(MouseEvent event) throws IOException {
        ServiceUser service = new ServiceUser();
        System.out.println("min aand el InscriptionConnection" + email);
        System.out.println("min aand el InscriptionConnection" + email);
         System.out.println("min aand el InscriptionConnection" + email);
      
            User Ualpha = JibliUser2(email);
            Ualpha.setRole("Candidat");
            service.ModifierUser(Ualpha);

        

        System.out.println("min aand goToFreelancer" + Roletest);

        Roletest = 1;
        System.out.println("min aand goToFreelancer" + Roletest);
        ClickImage = 0;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandiatHomeFront.fxml"));
        Parent root = loader.load();
        clk_img_candiat.getScene().setRoot(root);
        System.out.println("min aand goToFreelancer" + Roletest);

        return ClickImage;
    }

    @FXML
    public int goToChefEntreprise(MouseEvent event) throws IOException {
         ServiceUser service = new ServiceUser();
          System.out.println("min aand el InscriptionConnection" + email);
        System.out.println("min aand el InscriptionConnection" + email);
         System.out.println("min aand el InscriptionConnection" + email);
      
            User Ualpha = JibliUser2(email);
            Ualpha.setRole("Chef Entreprise");
            service.ModifierUser(Ualpha);

        Roletest = 0;
        System.out.println("min aand goToChefEntreprise" + Roletest);

        System.out.println("min aand goToChefEntreprise" + Roletest);
        ClickImage = 1;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefEntrepriseHomeFront.fxml"));
        Parent root = loader.load();
        clk_img_entreprise.getScene().setRoot(root);

        return ClickImage;
    }

    public User JibliUser2(String mail) {

        ServiceUser us = new ServiceUser();

        User u = us.ChercherParMail(mail);

        System.out.println(Roletest);
        System.out.println(u);
        System.out.println(u);
        System.out.println("min aand JibliUser2" + Roletest);
        if (Roletest == 1 && ClickImage == 0) {
            u.setRole("Candidat");

            System.out.println(u);
        } else if (Roletest == 0) {
            u.setRole("Chef Entreprise");
            System.out.println(u);
        }
        return u;

    }

}
