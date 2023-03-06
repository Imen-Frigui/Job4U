/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package GUI;

import entities.Postulation;
import utils.MyConnection;
import java.sql.ResultSet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**n
 *
 * @author user
 */
public class postulation1FXMain extends Application {
    @FXML
    private TableView<Postulation> tablePos;
    @FXML
    TableColumn<Postulation, Integer>idColumn  = new TableColumn<>("ID");
    @FXML
    TableColumn<Postulation, String> userColumn = new TableColumn<>("User");
    @FXML
    TableColumn<Postulation, String> emailColumn = new TableColumn<>("Email");
    @FXML
    TableColumn<Postulation, String> dateColumn = new TableColumn<>("Date");
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("postulation1.fxml"));
            
            Scene scene =new Scene(root);
            
        
    
        
       
      
            primaryStage.setTitle("Form");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println("err"+ex.getLocalizedMessage());
        
        }
    tablePos=new TableView();
    tablePos.setItems(getPostulations());
    tablePos.getColumns().addAll(idColumn,dateColumn,userColumn,emailColumn);
    VBox vBox=new VBox();
    vBox.getChildren().addAll(tablePos);
    
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
     
    }
     public ObservableList<Postulation> getPostulations(){
        ObservableList<Postulation> pos=FXCollections.observableArrayList();
    pos.add(new Postulation (2,"Formulvgfre","Forbgaire","Formulre"));
    pos.add(new Postulation (2,"Formulgfgfre","Forbgaire","Formulre"));
    pos.add(new Postulation (2,"21/8/2010","Forbhhire","Fo@re"));
    return pos;
    }
}
