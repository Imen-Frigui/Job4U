/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import Connn.MyDB;
import Services.ServiceOffre;
import entities.DataSingelton;
import interfaces.IServiceOffre;
import java.sql.Connection;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private TableColumn<?, ?> fin;
    @FXML
    private Button iUp;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
      
    }    
    @FXML
    private void getItem(MouseEvent event) {
       try { 
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
        Date date_debut = offTable.getSelectionModel().getSelectedItems().get(0).getDate_debut();
        data.setNom(nom);
        data.setDescrip(desc);
        data.setDuree(duree);
        data.setId(id);
        data.setDate_debut(date_debut);}catch(Exception e){
            System.out.println("Problem");
        }
        /*.lId.setText(String.valueOf(id));
        this.lNom.setText(nom);
        this.lDesc.setText(desc);
        this.lDuree.setText(duree);*/

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

    @FXML
    private void iClose(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void iDelete(MouseEvent event) {
        index = offTable.getSelectionModel().getFocusedIndex();
        ServiceOffre of = new ServiceOffre();
        of.supprimer1(index);
        refresh();
        
    }


    public void refresh(){
        ServiceOffre so = new ServiceOffre();
        listM= so.afficher1();
        offTable.setItems(listM);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("desc"));
        fin.setCellValueFactory(new PropertyValueFactory<>("date_debut"));
         dureeCol.setCellValueFactory(new PropertyValueFactory<>("duree"));
        
        
    }
    @FXML
    private void oRef(MouseEvent event) {
        
        refresh();
    }

    

    @FXML
    private void goUp(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/update.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TableView1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
