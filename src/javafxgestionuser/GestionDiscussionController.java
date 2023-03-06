/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxgestionuser;

import com.itextpdf.text.DocumentException;
import entities.Discussion;
import entities.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ServiceDiscussion;
import services.ServiceUser;
import utils.PdfAPI;

/**
 * FXML Controller class
 *
 * @author GO BRO
 */
public class GestionDiscussionController implements Initializable {

    @FXML
    private Hyperlink gestionuser;
    @FXML
    private Hyperlink gestion_stat;
    @FXML
    private Hyperlink State_Freelancer;
    @FXML
    private Hyperlink btn_login;
    @FXML
    private Hyperlink btn_gestion_discussion;
    @FXML
    private Hyperlink deconnecter;
    @FXML
    private Button btn_pdf;
    @FXML
    private TableView<Discussion> tableDiscussion;
    @FXML
    private TableColumn<Discussion, Integer> idDiscussion;
    @FXML
    private TableColumn<Discussion, String> idSender;
    @FXML
    private TableColumn<Discussion, String> idReceiver;
    @FXML
    private Button btn_afficher_discussion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 ServiceDiscussion us = new ServiceDiscussion();
        ObservableList<Discussion> list = FXCollections.observableArrayList();
        idDiscussion.setCellValueFactory(new PropertyValueFactory<>("id_disc"));
        idSender.setCellValueFactory(new PropertyValueFactory<>("id_sender"));
        idReceiver.setCellValueFactory(new PropertyValueFactory<>("id_reciver"));
 
        list.addAll(us.afficherD());
        tableDiscussion.setItems(list);
        // TODO
    }    

    @FXML
    private void clickMouse(MouseEvent event) {
    }

    @FXML
    private void On_stats_users(ActionEvent event) {
    }

    @FXML
    private void Emailtest(ActionEvent event) {
    }

    @FXML
    private void ListDisc(ActionEvent event) {
    }

    @FXML
    private void deconnecter(ActionEvent event) {
    }

    @FXML
    private void GeneratePdf(ActionEvent event) throws SQLException {
                PdfAPI pdf = new PdfAPI();

        try {
            pdf.listDiscussion();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherDisc(ActionEvent event) {
        ServiceDiscussion us = new ServiceDiscussion();
        ObservableList<Discussion> list = FXCollections.observableArrayList();
        idDiscussion.setCellValueFactory(new PropertyValueFactory<>("idDiscussion"));
        idSender.setCellValueFactory(new PropertyValueFactory<>("idSender"));
        idReceiver.setCellValueFactory(new PropertyValueFactory<>("idReceiver"));
 
        list.addAll(us.afficherD());
        tableDiscussion.setItems(list);

    }
    
}
