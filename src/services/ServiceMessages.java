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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            PreparedStatement pstmt = null;
        try{
            pstmt = connection.prepareStatement("INSERT INTO message (id_disc, id_sender, message) VALUES (?, ?, ?)");

        pstmt.setLong(1, m.getId_disc());
        pstmt.setInt(2, m.getId_sender());
        pstmt.setString(3, m.getMessage());

        pstmt.executeUpdate();
    } catch (SQLException ex) {
            System.out.println("erreur lors de la addession de la discussion \n " + ex.getMessage());
    } 

    }


    @Override
    public ArrayList<Message> afficher() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Edit(Message m) {
      try{ 
        String query = "update `message` set `message` = ? where `id_mesg` = ?";
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt   (2, m.getId_mesg());
      preparedStmt.setString(1, m.getMessage());

      // execute the java preparedstatement
      preparedStmt.executeUpdate();
      
      connection.close();
        }
        catch (SQLException e){
            System.out.println("erreur lors de la suppression de la discussion \n " + e.getMessage());
        }
    }
    @Override
    public void Delete(Message m) {
        try {
            String requete = "DELETE FROM `job4u`.`message` WHERE `id_message`=?";
            PreparedStatement ps = connection.prepareStatement(requete);      
            ps.setInt(1,m.getId_mesg());
            ps.executeUpdate();
            ps.close();
            System.out.println("Discussion supprimee !");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la discussion \n " + ex.getMessage());
        }
    }

    
}
