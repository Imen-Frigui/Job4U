/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Front;

import services.ServiceOffre;
import services.ServiceProject;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class OffreviewController implements Initializable {

    private TableView<offre> offreTable;
    @FXML
    private TableColumn<offre, String> idCol;
    @FXML
    private TableColumn<offre, String> nameCol;
    @FXML
    private TableColumn<offre, String> debutcol;
    @FXML
    private TableColumn<offre, String> finCol;
    @FXML
    private TableColumn<offre, String> projCol;
    @FXML
    private TableColumn<offre, String> descCol;
    
    offre offre = null ;
    
    ObservableList<offre>  offreList = FXCollections.observableArrayList();
    ServiceProject sp = new ServiceProject();
    ServiceOffre so = new ServiceOffre();
    @FXML
    private TableView<?> studentsTable;
    @FXML
    private TableColumn<?, ?> editCol;
    
     public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        debutcol.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
        finCol.setCellValueFactory(new PropertyValueFactory<>("DeadLine"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
        
     offreList =(ObservableList<offre>) so.afficher();
     offreTable.setItems(offreList);
    }

    /**
     * Initializes the controller class.
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }    
*/
    @FXML
    private void addOffre(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Front/project.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void addProjet(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Front/trois.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TroisController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void aClose(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    /*
    private void refreshTable() {
        
            offreList.clear();
            offreList = (ObservableList<offre>) so.afficher();
            
        } 
    
    private void loadDate() {
        
        
        idCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        debutcol.setCellValueFactory(new PropertyValueFactory<>("Date_debut"));
        finCol.setCellValueFactory(new PropertyValueFactory<>("DeadLine"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("Description"));
     
        
                
            
            
        
        
        Callback<TableColumn<offre, String>, TableCell<offre, String>> cellFoctory = (TableColumn<offre, String> param) -> {
             // make cell containing buttons
            final TableCell<offre, String> cell = new TableCell<offre, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    //that cell created only on non-empty rows
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {

                        Button delete = new Button("Delete");
                        Button edit = new Button("Edit");

                        delete.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );                        
                        delete.setOnMouseClicked((MouseEvent event) -> {
                            
                            offre = offreTable.getSelectionModel().getSelectedItem();
                            /*
                            query = "DELETE FROM `student` WHERE id  ="+offre.getId();
                            connection = DbConnect.getInstance().getConnect();
                            preparedStatement = connection.prepareStatement(query);
                            preparedStatement.execute();
                            
                            so.supprimer(offre);
                            //refreshTable();
                                      
                        });
                        edit.setOnMouseClicked((MouseEvent event) -> {
                            
                            offre = offreTable.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/Front/project.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(OffreviewController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            ProjectController addOffreController = loader.getController();
                          //  addOffreController.setUpdate(true);
                            addOffreController.setTextField(offre.getId(), offre.getNom(), 
                                    offre.getDate_debut().toLocalDate(),offre.getDate_fin(), offre.getDesc());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        HBox managebtn = new HBox(edit, delete);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(delete, new Insets(2, 2, 0, 3));
                        HBox.setMargin(edit, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         projCol.setCellFactory(cellFoctory);
         offreTable.setItems(offreList);
         
         
    }*/
    
}
