/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package GUI;

import Entities.Postulation;
import Services.ServicePostulation;
import Utils.MyDB;
import Utils.PdfAPI;
import com.itextpdf.text.DocumentException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
//import static com.sun.tools.attach.VirtualMachine.list;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button accepter;
    @FXML
    private Button btn_image;
    @FXML
    private Button btn;
    @FXML
    private ImageView imagePost;
     @FXML
    private TextField tfChercher;
    
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
    
    private String ImagePath;
    private String NameImage;
    
    public ObservableList<Postulation> list=FXCollections.observableArrayList();
    Connection connection;
    Statement ste;
    @FXML
     public ObservableList<Postulation> afficher(ActionEvent event){
         Postulation p1 =new Postulation();
         
        java.util.Date utilDate = p1.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
         try {
            connection=MyDB.getInstance().getCon();
            ste= (Statement) connection.createStatement();
            String req_select="SELECT * FROM `postulation`";
            ResultSet res = (ResultSet) ste.executeQuery(req_select);
            while (res.next()) {
                Postulation r = new Postulation(
                        res.getInt("id_pos"),
                        res.getDate("date"),
                         res.getString("Simple_User"),
                        res.getString("email")
                        
                       
                       
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
                }
    @FXML
    private void addPostulation(ActionEvent event) {
        try {
            String dateStr = tfDate.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(dateStr);
            Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),date,tfSimpleUser.getText(),tfEmail.getText());
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
        } catch (ParseException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    

    @FXML
    private void deletePostulation(ActionEvent event) {
        try {
            String dateStr = tfDate.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(dateStr);
            Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),date,tfSimpleUser.getText(),tfEmail.getText());
            ServicePostulation S=new ServicePostulation();
            S.supprimer1(p.getId_pos());
        } catch (ParseException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    }
@FXML
    private void modifierPostulation(ActionEvent event) {

        try {
            System.out.println("Bontton Modif Lu");
            ServicePostulation s = new ServicePostulation();
            
            int id_pos = tablePos.getSelectionModel().getSelectedItems().get(0).getId_pos();
            System.out.println(id_pos);
            String Simple_user = tfSimpleUser.getText();
            String Email = tfEmail.getText();
            
            //String Role22 = comboRole.getValue();
            String dateStr = tfDate.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = sdf.parse(dateStr);
            Postulation p = new Postulation( id_pos, date, Simple_user,Email);
            
            s.modifier(p);
        } catch (ParseException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    /*@FXML
    private void modifierPostulation(ActionEvent event) {
        Postulation p=new Postulation(Integer.parseInt(tfid_pos.getText()),tfDate.getText(),tfEmail.getText());
       ServicePostulation S=new ServicePostulation();
       S.modifier(p);
    }*/
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
    public void chercher(KeyEvent event) {
        System.out.println("chercher ");
        ServicePostulation s = new ServicePostulation();
        ObservableList<Postulation> liste = FXCollections.observableArrayList();

        liste.addAll(s.ChercherParId(Integer.parseInt(tfid_pos.getText())));

        tablePos.setItems(liste);

        System.out.print("list value \n " + liste);

    }


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
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the ID value: ");
            int id_pos = scanner.nextInt();
        Postulation p1=new Postulation(id_pos);

      p.ChercherParId(p1.getId_pos());
      System.out.println("The value is: " + p.ChercherParId(p1.getId_pos()));
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
                        result.getDate(2),
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
     
    
   
   @FXML
    void insert_image(ActionEvent event) {

        
        FileChooser fc = new FileChooser();
        fc.setTitle("Ajouter une Image");
      
        File SelectedFile = fc.showOpenDialog(null);
       
       
        if (SelectedFile != null) {
              ImagePath = "src/ressources/"+SelectedFile.getName();
              NameImage =SelectedFile.getName();
              System.out.println("hedhi esm el image eli bich tlasa9ha maal el path ::"+SelectedFile.getName());
              System.out.println("min aand el InscriptionConnexion"+ImagePath);
              
            imagePost.setImage(new Image(new File(ImagePath).toURI().toString()));
       
        }else {

            ImagePath = "C:\\Users\\user\\Documents\\NetBeansProjects\\Job4U\\src\\ressources\\logo.png";
            System.out.println(ImagePath);
            imagePost.setImage(new Image(new File(ImagePath).toString()));

        }
        
    }
    
    /*@   FXML
    private void filter(){

        TextField searchField = new TextField();


        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
    
    ObservableList<Postulation> filteredData = list.filtered(item -> {
        
        int cellValue = item.getId_pos();
        try {
            int searchValue = Integer.parseInt(newValue);
            return cellValue == searchValue;
        } catch (NumberFormatException e) {
            return false;
        }
    });

    // Step 4: Update the TableView to display the filtered data
    tablePos.setItems(filteredData);
});





    
    
    }*/
   
       public void click(MouseEvent event) {
       

        int id = tablePos.getSelectionModel().getSelectedItems().get(0).getId_pos();
        Date date= tablePos.getSelectionModel().getSelectedItems().get(0).getDate();
        String simple_user =tablePos.getSelectionModel().getSelectedItems().get(0).getSimple_user();
        String email = tablePos.getSelectionModel().getSelectedItems().get(0).getEmail();
        

        this.tfid_pos.getText();
       // this.tfDate;
        this.tfEmail.setText(email);
        this.tfSimpleUser.setText(simple_user);

    }
    
    @FXML
    private void GeneratePdf(ActionEvent event) throws SQLException, DocumentException {
    PdfAPI pdf = new PdfAPI();

        try {
            pdf.listAllPostulations();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Postulation1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      @FXML
        private void filterByPosId(ActionEvent event) {
             Postulation p = new Postulation();
        int id_pos=p.getId_pos() ; // Replace with the desired ID to filter by
        ObservableList<Postulation> filteredData = FXCollections.observableArrayList();
        for (Postulation postulation : tablePos.getItems()) {
            if (postulation.getId_pos() == id_pos) {
                filteredData.add(postulation);
            }
        }
        tablePos.setItems(filteredData);
}
   
    
}


    

