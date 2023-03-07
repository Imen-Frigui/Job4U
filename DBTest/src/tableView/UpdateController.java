/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import Services.ServiceOffre;
import entities.DataSingelton;
import entities.offre;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     
     */
    DataSingelton data=DataSingelton.getInstance();
    @FXML
    private TextField INom;
    @FXML
    private TextField IDesc;
    @FXML
    private TextField IDuree;
    @FXML
    private DatePicker sDate;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        this.INom.setText(data.getNom());
        this.IDesc.setText(data.getDescrip());
        this.IDuree.setText(data.getDuree());
       
    }    

  

    @FXML
    private void onUpdate(MouseEvent event) {
         ServiceOffre sp = new ServiceOffre();
         String nom = INom.getText();
         String desc = IDesc.getText();
          String duree = IDuree.getText(); 
          LocalDate myFD = sDate.getValue();
           Date date = Date.valueOf(myFD);
              System.out.println(nom);
              System.out.println(desc);
              System.out.println(duree);
          
         if (nom.isEmpty() || desc.isEmpty() || duree.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
         }else {
       offre p = new offre(data.getId(),nom,desc,date,duree);
       sp.modifier(p);
       FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/tableView/tableView1.fxml"));
                TableView1Controller tablevi;
                tablevi = fxmlloader.getController();
                tablevi.refresh();
      
    }
    }
    }
    

