/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Message;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceMessages;
import utils.MyListener;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class MsgController implements Initializable {
private MyListener myListener;
    private Message m;
    public static Message message;
    @FXML
    private Label msg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setData(Message m, MyListener myListener, int index) {
        this.m = m;
        this.myListener = myListener;
        ServiceMessages smsg = new ServiceMessages();
        msg.setText(smsg.getMsgsByDissId(m.getId_disc()).get(index).getMessage());
        if (m.getId_sender()!=3) {
            msg.setStyle("-fx-background-color: grey;");
                }
    }
    
    public void setMsgData(String data) {
        msg.setText(data);
    }

    @FXML
    private void selectMsg(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MsgWindow.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();

        MsgWindowController msgWindowController = fxmlLoader.getController();
        msgWindowController.setData(m, myListener);

        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
}
