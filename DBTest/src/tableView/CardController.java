/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import Services.ServiceOffre;
import entities.DataSingelton;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class CardController implements Initializable {

    @FXML
    private Label Nom;
    @FXML
    private Label Desc;
    @FXML
    private Label Duree;
    @FXML
    private Label leb;
    
    private int id;
        DataSingelton data= DataSingelton.getInstance();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(offre off){
        leb.setText(String.valueOf(off.getId()));
        //leb.setText(Integer.toString(off.getId()));
        Nom.setText(off.getNom());
        Desc.setText(off.getDesc());
        Duree.setText(off.getDuree());
              
    }
    
    @FXML
    private void getItem(MouseEvent event) {
        
        /* int num = Integer.parseInt(leb.getText());
         data.setId(num);
        data.setNom(Nom.getText());
        data.setDescrip(Desc.getText());
        data.setDuree(Duree.getText());
        
        System.out.print(data);*/
    }
  

    @FXML
    private void Edit(MouseEvent event) {
        /* ServiceOffre sp = new ServiceOffre();
         String nom = Nom.getText();
         String desc = Desc.getText();
          String duree = Duree.getText(); 
          String id = leb.getText();
          int num = Integer.parseInt(id);
              System.out.println(nom);
              System.out.println(desc);
              System.out.println(duree);
          
         if (nom.isEmpty() || desc.isEmpty() || duree.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
         }else {
       offre p = new offre(num,nom,desc,duree);
        
       sp.modifier(p);
         }*/
        int num = Integer.parseInt(leb.getText());
         data.setId(num);
        data.setNom(Nom.getText());
        data.setDescrip(Desc.getText());
        data.setDuree(Duree.getText());
         try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/Update.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(UpdateController.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @FXML
    private void onDelete(MouseEvent event) {
        int num = Integer.parseInt(leb.getText());
        ServiceOffre of = new ServiceOffre();
        of.supprimer1(num);
        
    }

    
}
         
    

