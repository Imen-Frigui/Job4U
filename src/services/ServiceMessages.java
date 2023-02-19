/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Discussion;
import entities.Message;
import interfaces.IServiceMessages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author Imen Frigui
 */
public class ServiceMessages implements IServiceMessages<Message> {
    Connection connection;
    Statement ste;

    public ServiceMessages() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void Add(Message m) throws SQLException {
        try {
            PreparedStatement pre = connection.prepareStatement("INSERT INTO `job4u`.`message` (`id_disc`,`id_sender`,`message`) VALUES (?,?,?)");
            pre.setInt(1, m.getId_disc());
            pre.setInt(2, m.getId_sender());
            pre.setString(3, m.getMessage());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void Delete(Message m) {
        try {
            String requete = "DELETE FROM message WHERE `id_mesg`=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setInt(1, m.getId_mesg());
            pst.executeUpdate();
            System.out.println("Message supprimée !");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la discussion \n " + ex.getMessage());
        }
    }

    @Override
    public List<Message> afficher() {
        try {
            List<Message> listOfMsgs = new ArrayList<>();

            ste = connection.createStatement();
            ResultSet rs = ste.executeQuery("Select * from message");
            while (rs.next()) {
                int id_mesg = rs.getInt("id_mesg");
                int id_disc = rs.getInt("id_disc");
                int id_sender = rs.getInt("id_sender");
                String message = rs.getString("message");
                Message m = new Message(id_mesg, id_disc, id_sender, message);
                listOfMsgs.add(m);
            }
            System.out.println(listOfMsgs);
            return listOfMsgs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public List<Message> getMsgsByDissId(int id) {
        try {
            List<Message> listOfMsgs = new ArrayList<>();

            ste = connection.createStatement();
            ResultSet rs = ste.executeQuery("Select * from message where id_disc=" + id + ";");
            while (rs.next()) {
                int id_mesg = rs.getInt("id_mesg");
                int id_disc = rs.getInt("id_disc");
                int id_sender = rs.getInt("id_sender");
                String message = rs.getString("message");
                Message m = new Message(id_mesg, id_disc, id_sender, message);
                listOfMsgs.add(m);
            }
            System.out.println(listOfMsgs);
            return listOfMsgs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void Edit(int id, String msg) {
        try {
            String query = "update `message` set `message` = ? where `id_mesg` = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, msg);
            preparedStmt.setInt(2, id);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            System.out.println("erreur lors de la modif de la discussion \n " + e.getMessage());
        }
    }

}
