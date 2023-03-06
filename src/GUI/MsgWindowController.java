/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Message;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceMessages;
import utils.MyListener;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class MsgWindowController implements Initializable {

    @FXML
    private TextField msgFld;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;

    private MyListener myListener;

    private Message m;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(Message m, MyListener myListener) {
        this.m = m;
        this.myListener = myListener;
        msgFld.setText(m.getMessage());
    }

    @FXML
    private void editMsg(ActionEvent event) {
        String msg = msgFld.getText();
        ServiceMessages smsg = new ServiceMessages();
        System.out.println("mesage" + m);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        smsg.Edit(m.getId_mesg(), msg);
        alert.setTitle("Success");
        alert.setHeaderText("updated");
        alert.setContentText("message updated successfully");
        msgFld.setText(msg);
        alert.showAndWait();
    }

    @FXML
    private void deleteMsg(ActionEvent event) {

        int id = m.getId_mesg();
        ServiceMessages smsg = new ServiceMessages();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        smsg.Delete(m);
        alert.setTitle("Success");
        alert.setHeaderText("deleted");
        alert.setContentText("message deleted successfully");
        alert.showAndWait();
    }
}
