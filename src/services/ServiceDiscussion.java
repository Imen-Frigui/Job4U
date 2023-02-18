/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Discussion;
import entities.Message;
import interfaces.IServiceDiscussion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import utils.MyDB;

/**
 *
 * @author GO BRO
 */
public class ServiceDiscussion implements IServiceDiscussion<Discussion> {
    Connection connection;
    Statement ste;

    public ServiceDiscussion() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void Add(Discussion d) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `job4u`.`discussion` (`id_sender`,`id_reciver`) VALUES (?,?)");
        pre.setInt(1, d.getId_sender());
        pre.setInt(2, d.getId_reciver());
        
        pre.executeUpdate();  
    }

    @Override
    public void Delete(Discussion d) {
        try {
            String requete = "DELETE FROM `job4u`.`discussion` WHERE `id_disc`=?";
            PreparedStatement ps = connection.prepareStatement(requete);      
            ps.setInt(1,d.getId_disc());
            ps.executeUpdate();
            ps.close();
            System.out.println("Discussion supprimee !");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la discussion \n " + ex.getMessage());
        }
    }


    @Override
    public ArrayList<Discussion> afficher() {
        ArrayList<Discussion> listDisc = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `job4u`.`discussion`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_disc = res.getInt(1);
            int sender = res.getInt(2);
            int reciver = res.getInt(3);
            Discussion disc = new Discussion(id_disc,sender,reciver);
            listDisc.add(disc);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listDisc;    }
    
         public ArrayList<Message> AfficherMessageDiscussion(int id){
        ArrayList<Message> messages = new ArrayList<>();
        try {
            String requete = "Select `discussion`.`id_disc`,`message`.`id_sender`,`message`.`message` FROM `message` JOIN `discussion` WHERE `discussion`.`id_disc` = `message`.`id_disc` AND `discussion`.`id_disc`=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getInt(1),rs.getInt(2),rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur affichage des message \n" + ex.getMessage());
        }
        return messages;
    }
         
         public String AfficherDernierMess(int id){
         try {
         String requete = "Select `message` FROM `message` WHERE `id_disc`=? ORDER BY id_mesg DESC limit 1";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) return rs.getString(1);
            return "pas de message";
         } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
            return "pas de message";
        }
     }
    public ArrayList<Discussion> AfficherListe(int id){
        ArrayList<Discussion> discussion = new ArrayList<>();
        try {
            String requete;
            requete = "Select * FROM `discussion` WHERE `id_reciver`=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(3,id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return discussion;
    }
    
        public ArrayList<Discussion> Search (String search){
            ArrayList<Discussion> discussion = new ArrayList<>();
        try{
            PreparedStatement p = connection.prepareStatement("Select `discussion`.`id_disc`,`discussion`.`id_sender`,`discussion`.`id_reciver` FROM `users` JOIN `Discussion` WHERE `users`.`Nom` LIKE ? OR `users`.`Prenom` LIKE ?");
            p.setString(1,"%"+search+"%");
            p.setString(2,"%"+search+"%");

            ResultSet r = p.executeQuery();
            while(r.next()){
                discussion.add(new Discussion(r.getInt(1),r.getInt(2),r.getInt(3)));
        }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
            return discussion;

    }
        public VBox GetConversations(int id, VBox listView) {
        try {
            String requete;
            requete = "Select * FROM `discussion` WHERE `id_reciver`=?";
            java.sql.PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1,id);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                Discussion conv = new Discussion(res.getInt(1), res.getInt(2), res.getInt(3));
                Label label = new Label();
                label.setUserData(conv);
                label.setText(conv.toString());
                //label.setAlignment(Pos.CENTER);
                //label.setFont(new Font(20));
                label.setStyle("-fx-background-color: #007bff; -fx-background-radius: 50px;");
                //label.setPadding(new Insets(20, 25, 20, 25));

                listView.getChildren().add(label);
            }

            // connection.close();
        } catch (SQLException e) {
        }
        return listView;
    }
    


    
}
