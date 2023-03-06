/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Discussion;
import entities.Message;
import entities.User;
import interfaces.IServiceDiscussion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import utils.MyConnection;

/**
 *
 * @author Imen Frigui
 */
public class ServiceDiscussion implements IServiceDiscussion<Discussion> {
    Connection connection;
    Statement ste;

    public ServiceDiscussion() {
        connection = MyConnection.getInstance().getCnx();
    }

    @Override
    public void Add(Discussion d) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `pidevusers`.`discussion` (`id_sender`,`id_reciver`) VALUES (?,?)");
        pre.setInt(1, d.getId_sender());
        pre.setInt(2, d.getId_reciver());

        pre.executeUpdate();
    }

    @Override
    public void Delete(Discussion d) {
        try {
            String requete = "DELETE FROM `pidevusers`.`discussion` WHERE `id_disc`=?";
//            String requete = "INSERT INTO evenement VALUES (null,?,?,?,CONVERT(?, DATE),CONVERT(?, DATE),CONVERT(?, TIME),CONVERT(?, TIME),?,?)";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, d.getId_disc());
            ps.executeUpdate();
            System.out.println("Discussion supprimee !");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la discussion \n " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Discussion> afficher() {
        ArrayList<Discussion> listDisc = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `pidevusers`.`discussion`";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id_disc = res.getInt(1);
                int id_sender = res.getInt(2);
                int id_reciver = res.getInt(3);
                ServiceUsers su = new ServiceUsers();
               // User sender = su.getUserById(id_sender);
                //User reciver = su.getUserById(id_reciver);
                Discussion disc = new Discussion(id_disc, su.getUserById(id_sender).getNom(), su.getUserById(id_reciver).getNom());
                listDisc.add(disc);
                System.out.println(disc);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listDisc;
    }
        public ArrayList<Discussion> afficherD() {
        ArrayList<Discussion> listuser = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT id_disc,id_sender,id_reciver FROM `pidevusers`.`discussion`";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                int sender = res.getInt(2);
                int reciver = res.getInt(3);
                Discussion ur = new Discussion(id,reciver,sender);
                listuser.add(ur);
            }
                            System.out.println(listuser);

        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listuser;
    }

    public ArrayList<Message> AfficherMessageDiscussion(int id) {
        ArrayList<Message> messages = new ArrayList<>();
        try {
            String requete = "Select `discussion`.`id_disc`,`message`.`id_sender`,`message`.`message` FROM `message` JOIN `discussion` WHERE `discussion`.`id_disc` = `message`.`id_disc` AND `discussion`.`id_disc`=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                messages.add(new Message(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur affichage des message \n" + ex.getMessage());
        }
        return messages;
    }

    public String AfficherDernierMess(int id) {
        try {
            String requete = "Select `message` FROM `message` WHERE `id_disc`=? ORDER BY id_mesg DESC limit 1";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return "pas de message";
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
            return "pas de message";
        }
    }

    public List<Discussion> AfficherListe(int id) {
        List<Discussion> listDi = new ArrayList<>();
        try {
            String req_select = "Select * FROM `discussion` WHERE `id_sender`=?";
            PreparedStatement pst = connection.prepareStatement(req_select);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id_disc = rs.getInt(1);
                int id_sender = rs.getInt(2);
                int id_reciver = rs.getInt(3);
                ServiceUsers su = new ServiceUsers();
                User sender = su.getUserById(id_sender);
                User reciver = su.getUserById(id_reciver);
                Discussion disc = new Discussion(id_disc, sender, reciver);
                listDi.add(disc);            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
        return listDi;
    }
    
public ArrayList<Discussion> Search (String search){
            ArrayList<Discussion> Disc = new ArrayList<>();
        try{
            PreparedStatement p = connection.prepareStatement("Select `discussion`.`id_disc`,`discussion`.`id_sender`,`discussion`.`id_reciver` FROM `users` JOIN `Discussion` ON `users`.`Id`=`Discussion`.`id_sender` WHERE `users`.`Nom` LIKE ?");
            p.setString(1,"%"+search+"%");
           // p.setString(2,"%"+search+"%");

            ResultSet r = p.executeQuery();
            while(r.next()){
                int id_disc = r.getInt(1);
                int id_sender = r.getInt(2);
                int id_reciver = r.getInt(3);
                ServiceUsers su = new ServiceUsers();
                User sender = su.getUserById(id_sender);
               User reciver = su.getUserById(id_reciver);
                Discussion disc = new Discussion(id_disc, sender, reciver);
                Disc.add(disc);
        }
        } catch (SQLException ex) {
            System.out.println("Erreur lors d'extraction des données \n" + ex.getMessage());
        }
            return Disc;

    }
}
