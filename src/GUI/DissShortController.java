/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gui;

import entities.Discussion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import services.ServiceDiscussion;
import utils.MyListener;

/**
 * FXML Controller class
 *
 * @author Imen Frigui
 */
public class DissShortController implements Initializable {

    @FXML
    private AnchorPane clickPane;
    @FXML
    private ImageView image;
    @FXML
    private Label senderName;
    @FXML
    private Label msgContent;
    private MyListener myListener;
    public Discussion d;
    public static Discussion discussion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void setData(Discussion d, MyListener myListener) {
        this.d = d;
        this.myListener = myListener;
        senderName.setText(d.getSender().getNom() + d.getSender().getPrenom());
        ServiceDiscussion sdis = new ServiceDiscussion();
        msgContent.setText(sdis.AfficherDernierMess(d.getId_disc()));
    }

    @FXML
    private void showDiss(MouseEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("ChatSection.fxml"));
        AnchorPane anchorPane;
        anchorPane = fxmlLoader.load();

        ChatSectionController chatSectionController = fxmlLoader.getController();
        chatSectionController.setData(d, myListener);

        Stage stage = new Stage();
        stage.setScene(new Scene(anchorPane));
        stage.show();
    }
    
}
