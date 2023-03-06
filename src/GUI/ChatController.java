/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Discussion;
import entities.Message;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import services.ServiceDiscussion;
import services.ServiceMessages;
import utils.MyListener;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class ChatController implements Initializable {
    @FXML
    private TextField tfrech;
    private Discussion d;

    public static List<Discussion> dissList = new ArrayList<>();
    public static List<Discussion> discs = new ArrayList<>();

    public static List<Message> msgsList = new ArrayList<>();
    public static List<Message> msgs = new ArrayList<>();

    private MyListener myListener;
    @FXML
    private GridPane dissGrid;
    @FXML
    private Button newChatBtn;

    public void setDataList(List<Message> list) {
        ServiceMessages smsg = new ServiceMessages();
        msgsList.addAll(smsg.afficher());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dissList.clear();
            ServiceDiscussion sdis = new ServiceDiscussion();

            dissList.addAll(sdis.AfficherListe(2));
            Collections.reverse(dissList);

            discs.addAll(getDiscData());
            Collections.reverse(discs);

            int column = 0;
            int row = 1;
            for (int i = 0; i < dissList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("DissShort.fxml"));
                AnchorPane anchorPane;
                anchorPane = fxmlLoader.load();

                DissShortController disShortController = fxmlLoader.getController();
                disShortController.setData(dissList.get(i), myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                dissGrid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                dissGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                dissGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                dissGrid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                dissGrid.setMinHeight(280);
                dissGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                dissGrid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Discussion> getDiscData() {
        List<Discussion> dissItem = new ArrayList<>();
        Discussion diss;

        for (Discussion d : dissList) {
            diss = new Discussion();
            diss.setId_sender(d.getId_sender());

            dissItem.add(diss);
        }

        return dissItem;

    }

    public static List<Message> getMsgData() {
        List<Message> msgItem = new ArrayList<>();
        Message mesg;

        for (Message m : msgsList) {
            mesg = new Message();
            mesg.setId_disc(m.getId_disc());
            mesg.setId_sender(m.getId_sender());

            msgItem.add(mesg);
        }

        return msgItem;

    }

    @FXML
    private void openNewDiss(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Discussion.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
@FXML
    private void rech(ActionEvent event) {
               try {
                   dissGrid.getChildren().clear();
            dissList.clear();
            ServiceDiscussion sdis = new ServiceDiscussion();

            dissList.addAll(sdis.Search(tfrech.getText()));
            Collections.reverse(dissList);

            discs.addAll(getDiscData());
            Collections.reverse(discs);

            int column = 0;
            int row = 1;
            for (int i = 0; i < dissList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("DissShort.fxml"));
                AnchorPane anchorPane;
                anchorPane = fxmlLoader.load();

                DissShortController disShortController = fxmlLoader.getController();
                disShortController.setData(dissList.get(i), myListener);

                if (column == 1) {
                    column = 0;
                    row++;
                }

                dissGrid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                dissGrid.setMinWidth(Region.USE_COMPUTED_SIZE);
                dissGrid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                dissGrid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                dissGrid.setMinHeight(280);
                dissGrid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                dissGrid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
