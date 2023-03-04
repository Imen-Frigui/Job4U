/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Entities.Postulation;
import Services.ServicePostulation;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import static com.sun.tools.attach.VirtualMachine.list;
import java.net.URL;
import static java.nio.file.Files.list;
import java.sql.DriverManager;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PostulationController implements Initializable {

    @FXML
    private TextField tfid_pos;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfSimpleUser;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfresultat;
    private TableView<Postulation> tablePos;
    TableColumn<Postulation, Integer>idColumn  = new TableColumn<>("ID");
    TableColumn<Postulation, String> userColumn = new TableColumn<>("User");
    TableColumn<Postulation, String> emailColumn = new TableColumn<>("Email");
    TableColumn<Postulation, String> dateColumn = new TableColumn<>("Date");

// add data to the table view

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServicePostulation pos = new ServicePostulation();
       ObservableList<Postulation> list = FXCollections.observableArrayList();
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            userColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            dateColumn .setCellValueFactory(new PropertyValueFactory<>("mail"));
            list.addAll(pos.afficher());
            tablePos.setItems(list);
            tablePos.setEditable(true);
            emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
         
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
       S.supprimer(p);
    
    }

    @FXML
    private void modifierPostulation(ActionEvent event) {
         Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(),tfSimpleUser.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.modifier(p);
    }

    @FXML
    private void affichage(ActionEvent event) {
        ServicePostulation S1 = new ServicePostulation();
      tfresultat.setText(S1.afficher().toString());
    }
    /*@FXML
    private boolean utilisateurExiste(ActionEvent event) {
    boolean existe = false;
    
    try (Connection conn =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev")) {
        PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT COUNT(*) `id_pos`, `date`, `Simple_user`, `Email` FROM `postulation` WHERE Simple_user=?;");
        String nomUtilisateur;
        stmt.setString(1, nomUtilisateur);
        ResultSet rs = (ResultSet) stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);
        if (count > 0) {
            existe = true;
        }
    } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    
    return existe;
}
    */
}
/*String query = "SELECT id, name FROM my_table";
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while (rs.next()) {
    int id = rs.getInt("id_pos");
    String name = rs.getString("date");
    data.add(new Postulation(id, name));
}

// Set the ObservableList as the data source for the TableView
tableView.setItems(data);

// Add the TableView to the scene graph
Scene scene = new Scene(new Group(tableView));
}*/
/*package GUI;

import Entities.Postulation;
import Services.ServicePostulation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.cell.PropertyValueFactory;

public class PostulationController implements Initializable {
    @FXML
    private TableView<Postulation> table;
    @FXML
    private TableColumn<Postulation, String> date;
    @FXML
    private TableColumn<Postulation, String> SimpleUser;
    @FXML
    private TableColumn<Postulation, String> Email;
    @FXML
    private TextField tfid_pos;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfSimpleUser;
    @FXML
    private TextField tfEmail;
    @FXML
    private Label tfresultat;

    private final ObservableList<Postulation> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        SimpleUser.setCellValueFactory(new PropertyValueFactory<>("simpleUser"));
        Email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.setItems(list);
    }

    @FXML
    private void addPostulation(ActionEvent Event) {
        if (tfDate.getText().isEmpty() || tfSimpleUser.getText().isEmpty() || tfEmail.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("All fields are required.");
            alert.showAndWait();
            return;
        }

        Postulation p;
        p = new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(), tfSimpleUser.getText(), tfEmail.getText());
        ServicePostulation S = new ServicePostulation();
        S.ajouter(p);
        list.add(p);
    }

    @FXML
    private void affichage(ActionEvent Event) {
        ServicePostulation S = new ServicePostulation();
        list.clear();
        list.addAll(S.afficher());
    }

    @FXML
    public void deletePostulation(ActionEvent Event) {
        if (table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a postulation to delete.");
            alert.showAndWait();
            return;
        }

        Postulation p = table.getSelectionModel().getSelectedItem();
        ServicePostulation S = new ServicePostulation();
        S.supprimer(p);
        list.remove(p);
    }

    @FXML
    public void modifierPostulation(ActionEvent Event) {
        if (table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please select a postulation to modify.");
            alert.showAndWait();
            return;
        }

        Postulation p = table.getSelectionModel().getSelectedItem();
        p.setDate(tfDate.getText());
        p.setSimple_user(tfSimpleUser.getText());
        p.setEmail(tfEmail.getText());
        ServicePostulation S = new ServicePostulation();
        S.modifier(p);
        table.refresh();
    }
}
*/
