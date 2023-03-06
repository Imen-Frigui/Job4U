/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Discussion;
import entities.Message;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import services.ServiceDiscussion;
import services.ServiceMessages;
import services.ServiceUser;
import services.ServiceUsers;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class DiscussionController implements Initializable {

    @FXML
    private ComboBox<User> senderCbox;
    @FXML
    private TextField firstMsgFld;
    @FXML
    private Button sendBtn;

    ObservableList<User> UsersList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ServiceUser su = new ServiceUser();

        List<User> users = su.afficher();
        UsersList.setAll(users);
        senderCbox.setItems(UsersList);
    }

    @FXML
    private void addDissAndSendFirstMsg(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Discussion disc = new Discussion(1, senderCbox.getValue().getId());
        ServiceDiscussion sdisc = new ServiceDiscussion();
        sdisc.Add(disc);
        Discussion lastDiscAdded = new Discussion();
        System.out.println("length"+sdisc.afficher().size());
        lastDiscAdded = sdisc.afficher().get(sdisc.afficher().size()-1);
        System.out.println(lastDiscAdded);
        Message mesg = new Message(lastDiscAdded.getId_disc(), 1, firstMsgFld.getText());
        ServiceMessages smsg = new ServiceMessages();
        smsg.Add(mesg);
        alert.setTitle("Success");
        alert.setHeaderText("sent");
        alert.setContentText("new disc and msg sent");
        alert.showAndWait();
    }
}
