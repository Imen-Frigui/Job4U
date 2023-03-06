/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Entities.Postulation;
import Services.ServicePostulation;
import Utils.MyDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import static com.sun.tools.attach.VirtualMachine.list;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import static java.nio.file.Files.list;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Postulation1Controller implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private TextField tfid_pos;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfSimpleUser;
    @FXML
    private TextField tfEmail;
     @FXML
    private Button Refresh;
    private Button accepter;
      @FXML
    private ComboBox<String> combouser;
    @FXML
    private TableView<Postulation> tablePos;
    @FXML
    TableColumn<Postulation, Integer>idColumn  = new TableColumn<>("id_pos");
    @FXML
    TableColumn<Postulation, String> userColumn = new TableColumn<>("Simple_User");
    @FXML
    TableColumn<Postulation, String> emailColumn = new TableColumn<>("email");
    @FXML
    TableColumn<Postulation, String> dateColumn = new TableColumn<>("date");
    
    public ObservableList<Postulation> list=FXCollections.observableArrayList();
    Connection connection;
    Statement ste;
     public ObservableList<Postulation> afficher(ActionEvent event){
        try {
            connection=MyDB.getInstance().getCon();
            ste= (Statement) connection.createStatement();
            String req_select="SELECT * FROM `postulation`";
            ResultSet res = (ResultSet) ste.executeQuery(req_select);
            
            while (res.next()) {
                Postulation r = new Postulation(
                        res.getInt("id_pos"),
                         res.getString("Simple_User"),
                        res.getString("email"),
                        res.getString("date")
                       
                       
                );
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);

            
        
        }
                
         TableColumn<Postulation, Integer>idColumn  = new TableColumn<>("ID");   
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_pos"));
        TableColumn<Postulation, String> userColumn = new TableColumn<>("User");
        userColumn.setCellValueFactory(new PropertyValueFactory<>("Simple_user"));
        TableColumn<Postulation, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        TableColumn<Postulation, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        tablePos.setItems(list);
        
        return list;
        
        
        
        
}

     
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   String[] items = {"Chef Entreprise", "Candidat"};
        combouser.getItems().addAll(items);
       String data = combouser.getSelectionModel().getSelectedItem();
                }
    
    
       public void handle(ActionEvent event) {
           try {
               
               String url = "jdbc:mysql://localhost:3306/new";
               String username = "root";
               String password = "";
               String selectQuery = "SELECT Simple_user FROM `postulation` WHERE id_pos = ?";
               String updateQuery = "UPDATE `postulation` SET Simple_user = ? WHERE id_pos = ?";
               int id_pos = 1;
               Connection conn = null;
               PreparedStatement stmt;
               ResultSet rs;
               try {
                   conn = (Connection) DriverManager.getConnection(url, username, password);
                   stmt = (PreparedStatement) conn.prepareStatement(selectQuery);
                   stmt.setInt(1, id_pos);
                   rs = (ResultSet) stmt.executeQuery(); 
                   String currentValue = null;
                   if (rs.next()) {
                       currentValue = rs.getString("Simple_user");
                   }
                   ObservableList<String> items;
                   items = FXCollections.observableArrayList("Chef Entreprise", "Candidat");
                   combouser = new ComboBox<>(items);
                   combouser.setValue(currentValue);
                   rs.close();
                   stmt.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
                stmt = (PreparedStatement) conn.prepareStatement(updateQuery);
               stmt.setString(1, combouser.getValue());
               stmt.setInt(2, id_pos);
               stmt.executeUpdate();
               stmt.close();
               
               
           } catch (SQLException ex) {
               Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
               
               
               }
           
       
   

    @FXML
    private void addPostulation(ActionEvent event) {
        Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.ajouter(p);
       //id_pos.getValue() == null;
       String idpos=tfid_pos.getText();
     if (idpos.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("ID is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + idpos);
            }
       
   String value = tfDate.getText();

    if (value.isEmpty() ) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Date is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + value);
            }
    String val = tfSimpleUser.getText();
    if (value.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("SimpleUser is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + val);
            }
    String va_email=tfEmail.getText();
     if (value.isEmpty()) {
                
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Email is empty.");
                alert.showAndWait();
            } else {
        
                System.out.println("The value is: " + va_email);
            }
       
    }
    

    @FXML
    private void deletePostulation(ActionEvent event) {
        Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
      S.supprimer1(p.getId_pos());
    
    }

    @FXML
    private void modifierPostulation(ActionEvent event) {
        Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.modifier(p);
    }
    /*@FXML
    private void ModifierPostulation(ActionEvent event) {
        String date =tfDate.getText();
        int id_pos =Integer.parseInt(tfid_pos.getText());
        String email =tfEmail.getText();
        
        ServicePostulation p = new ServicePostulation();
        System.out.println("mesage" + date);
        p.modifier();
        tfDate.setText(date);
        tfEmail.setText(email);
        
        alert.showAndWait();
    }*/


  public void affichage() {
   

       ObservableList<Postulation> list = FXCollections.observableArrayList();
       
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id_pos"));
            dateColumn .setCellValueFactory(new PropertyValueFactory<>("date"));
            userColumn.setCellValueFactory(new PropertyValueFactory<>("Simple_user"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
            
            //list.addAll(list.afficher());
            tablePos.setItems(list);
            tablePos.setEditable(true);
            emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
         
    }

  


    @FXML
    private void Refresh(ActionEvent event) {
        affichage();
    }
   
/*@FXML 
private void accepter1(ActionEvent event){
    

   

}
 @FXML*/
    @FXML
    private void savepos(ActionEvent event) {

        ServicePostulation p = new ServicePostulation();
        ObservableList<Postulation> list = FXCollections.observableArrayList();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_pos"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("Simple_user"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        list.addAll(p.afficher());

        FileChooser fileChooser = new FileChooser();

        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            saveSystem(file, list);
        }
    }

    public void saveSystem(File file, ObservableList<Postulation> list) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.write(list.toString());
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    @FXML
    
    
    private void chercherpos(ActionEvent event){
       ServicePostulation p = new ServicePostulation();
        ObservableList<Postulation> list = FXCollections.observableArrayList();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_pos"));
        userColumn.setCellValueFactory(new PropertyValueFactory<>("Simple_user"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Email"));
        list.addAll(p.afficher());


      p.ChercherParId(5);
      System.out.println("The value is: " + p.ChercherParId(5));
      /*Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Information Dialog");
      alert.setHeaderText(null);
      alert.setContentText("This is an information message!");

      alert.showAndWait();*/
      tablePos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
        Postulation selectedData = tablePos.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Selected Row Data");
        alert.setHeaderText(null);
        alert.setContentText("ID: " + selectedData.getId_pos() + "\nName: " + selectedData.getSimple_user() + "\nAge: " + selectedData.getEmail());
        alert.showAndWait();
    }
});

        
        
    }
    
   public Postulation ChercherParId(int id_pos) {
        try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("SELECT * FROM `postulation` where id_pos = ?");
            pre.setInt(1, id_pos);
            java.sql.ResultSet result = pre.executeQuery();
            while (result.next()) {
                Postulation p = new Postulation(
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4));
                return p;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }


   

    /*private void accepter(String filePath, int id_pos) throws IOException, SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Establish a connection to the database
        conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev", "root", "");

        // Define a SQL query to fetch the candidate's name, email, and job title
        String sql = "SELECT * FROM `postulation` WHERE id = ?";

        // Create a PreparedStatement object to execute the query
        stmt = (PreparedStatement) conn.prepareStatement(sql);
        stmt.setInt(1, id_pos);

        // Execute the query and get the ResultSet
        rs = (ResultSet) stmt.executeQuery();
        // Retrieve the candidate's name, email, and job title from the ResultSet
        String SimpleUser= rs.getString("userColumn");
        String date = rs.getString("dateColumn");
        String candidateEmail = rs.getString("emailColumn");
        String jobTitle = rs.getString("emailColumn");
        

        try ( // Create a BufferedWriter to write to the file
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)) // Close the BufferedWriter
        ) {
            // Write the acceptance message to the file
            writer.write("Dear " + SimpleUser + ",\n\n");
            writer.write("Congratulations! We are pleased to inform you that your candidature for the position of " + jobTitle + " has been accepted.\n\n");
            writer.write("We look forward to having you join our team. Please find attached a copy of the employment contract for your review and signature.\n\n");
            writer.write("If you have any questions or concerns, please do not hesitate to contact us at " + candidateEmail + ".\n\n");
            writer.write("Thank you for your interest in our company.\n\n");
            writer.write("Best regards,\n\n");
            writer.write("Human Resources Department\n");
        }
    } finally {
        // Close the JDBC resources in the reverse order of their creation
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }
}*/
    
}


    

