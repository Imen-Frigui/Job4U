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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
     private int Roletest=2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  ServiceUser us = new ServiceUser();
        
    }

    @FXML
    public boolean goToFreelancer(MouseEvent event) throws IOException {

         Roletest =1;
         changerValeurRole(Roletest);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CandiatHomeFront.fxml"));
        Parent root = loader.load();
        clk_img_candiat.getScene().setRoot(root);
        System.out.println(Roletest);
        return true;
    }
    
    
     @FXML
    public boolean goToChefEntreprise(MouseEvent event) throws IOException {
        
         Roletest =0;
         changerValeurRole(Roletest);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChefEntrepriseHomeFront.fxml"));
        Parent root = loader.load();
        clk_img_entreprise.getScene().setRoot(root);
        
        return true;
    }

    
    
   
    public User JibliUser2(String mail) {
        ServiceUser us = new ServiceUser();

        User u = us.ChercherParMail(mail);
       
        System.out.println(Roletest);
        System.out.println(u);
        System.out.println(u);

        if (Roletest==1) {
            u.setRole("Candidat");

            System.out.println(u);
        } else if (Roletest==0) {
            u.setRole("Chef Entreprise");
            System.out.println(u);
        }
        return u;

    }

    boolean changerValeurRole(int Roletest){
        
        
        if(Roletest==1){
            return true;
            
        }
        else {
            return false;
        }
 
        
        
    }

  
   

}
