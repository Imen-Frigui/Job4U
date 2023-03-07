/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import Connn.MyDB;
import Services.ServiceOffre;
import Services.ServiceProject;
import entities.Project;
import entities.offre;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class AjouterOffreController implements Initializable {

    @FXML
    private TextField nomOff;
    @FXML
    private TextField descOff;
    @FXML
    private TextField dureeOff;
    @FXML
    private ComboBox<String> oComb;
     ObservableList listM;
     ServiceProject sp = new ServiceProject();
      Statement ste;
    Connection con;
    @FXML
    private DatePicker sDate;
    /**
     * Initializes the controller class.{
          /*con = MyDB.getInstance().getCon();
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          /*con = MyDB.getInstance().getCon();
        ServiceOffre so = new ServiceOffre();
          
        try{
        ste= con.createStatement();
        String req_select="SELECT nom FROM projects;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
           oComb.getItems().add(res);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }  */
    listM= sp.afficher1();
        oComb.setItems(listM);
    }    

    @FXML
    private void addOff(MouseEvent event) throws SQLException {
        
        ServiceOffre sp = new ServiceOffre();
         String nom = nomOff.getText();
         String desc = descOff.getText();
          String duree = dureeOff.getText();
           LocalDate myFD = sDate.getValue();
           Date date = Date.valueOf(myFD);
          int dd =oComb.getSelectionModel().getSelectedIndex()+1;
         if (nom.isEmpty() || desc.isEmpty() || duree.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
         }else {
       offre p = new offre(nom,desc,date,duree,dd);
       System.out.println(dd);
       sp.ajouter2(p);
       Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();      
    }
         
    }

    @FXML
    private void annOff(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
