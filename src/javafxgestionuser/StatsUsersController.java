/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import services.ServiceUser;
import entities.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author user
 */
public class StatsUsersController implements Initializable {

    @FXML
    private PieChart statsUsers;
    @FXML
    private Button btn_dashboard;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            ServiceUser us = new ServiceUser();
           User users = new User();
           
        int nbreCand=   us.CountUsersPerRole("Candidat");
           System.out.println(nbreCand);
           int nbreChef=   us.CountUsersPerRole("Chef Entreprise");
           System.out.println(nbreChef);
       
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
        new PieChart.Data("Candidat", nbreCand),
        new PieChart.Data("Chef Entreprise", nbreChef));
       
        statsUsers.getData().forEach(data->{
        String pourcentage =String.format("%.2f%%",(data.getPieValue()/100));
            Tooltip tooltip= new Tooltip(pourcentage);
            tooltip.install(data.getNode(), tooltip);
        }
              
       
        );
        
        statsUsers.setTitle("Graphe des utilisateurs par role");
        
      
       
    
     
     //   us.afficher().forEach((a) -> {

            //  data.put(a.getTitre(),Aides.CountAides(a.getId()));
      //      if (a.getRole().equals("Candidat")) {
       //          pieData.add( new PieChart.Data("Cd", 1)) ;
        //    }
            
           //  if (a.getRole().equals("Chef Entreprise")) {
         //        pieData.add( new PieChart.Data("Chef", 1)) ;
         //   }
            
            
        
         
     
      // });
        statsUsers.setData(pieData);
        
        
       
          
        
    }    

    @FXML
    private void backDashboard(ActionEvent event) {
             try {
            //taawed thezzek lel inscription
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GestionUsers.fxml"));
            Parent root = loader.load();
                btn_dashboard.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(InscriptionConnexionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
