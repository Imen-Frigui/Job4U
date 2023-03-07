/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package tableView;

import Services.ServiceOffre;
import entities.offre;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ShowCardController implements Initializable {

    private ArrayList<offre> res;
    private HBox cardLayout1;
    @FXML
    private GridPane cardContainer;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceOffre so = new ServiceOffre();
        res=so.afficher();
        int column=0;
        int row=1;
        System.out.println(res);
        try{
            for(offre offre : res){
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/tableView/Card.fxml"));
                VBox cardBox =fxmlloader.load();
                CardController CardController;
                CardController = fxmlloader.getController();
                CardController.setData(offre);
                
               if(column==2){
                   column=0;
                   ++row;
               }
                cardContainer.add(cardBox,column++,row);
                GridPane.setMargin(cardBox,new Insets(10));
            }}
            catch(IOException e){
                    e.printStackTrace();
                    }
        }
    }    
    

