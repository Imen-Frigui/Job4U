/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Discussion;
import entities.Message;
import entities.User;
import static gui.ChatController.getMsgData;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.ServiceMessages;
import services.ServiceUsers;
import utils.MyListener;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class ChatSectionController implements Initializable {

   
    @FXML
    private Label senderName;
    @FXML
    private TextField msgTxtFld;
    @FXML
    private Button msgBtn;
    @FXML
    private GridPane msgsGrid;

    private MyListener myListener;

    private Discussion d;

    public static List<Message> msgsList = new ArrayList<>();
    public static List<Message> msgs = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DisplayDisc();
        } catch (SQLException ex) {
            Logger.getLogger(ChatSectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sendMsg(ActionEvent event) {
        String msg = msgTxtFld.getText();
        ServiceMessages smsg = new ServiceMessages();
        Message m = new Message(17, 3, msg);
        try {
            smsg.Add(m);
            msgTxtFld.setText("");
            DisplayDisc();
        } catch (SQLException ex) {
            Logger.getLogger(ChatSectionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setData(Discussion d, MyListener myListener) {
        this.d = d;
        this.myListener = myListener;
        senderName.setText(d.getSender().getNom() + d.getSender().getPrenom());
    }

    public void DisplayDisc() throws SQLException {
        try {
            msgsList.clear();
            ServiceMessages smsg = new ServiceMessages();

            msgsList.addAll(smsg.afficher());
            //Collections.reverse(msgsList);

            msgs.addAll(getMsgData());
            //Collections.reverse(msgs);

            int column = 0;
            int row = 1;
            for (int i = 0; i < msgsList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Msg.fxml"));
                AnchorPane anchorPane;
                anchorPane = fxmlLoader.load();

                MsgController msgController = fxmlLoader.getController();
                msgController.setData(msgsList.get(i), myListener, i);

                ServiceUsers su = new ServiceUsers();
                User u = su.getUserById(msgsList.get(i).getId_sender());

                senderName.setText(u.getNom() + " " + u.getPrenom());

                if (column == 1) {
                    column = 0;
                    row++;
                }

                msgsGrid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                msgsGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                msgsGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                msgsGrid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                msgsGrid.setMinHeight(280);
                msgsGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                msgsGrid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
