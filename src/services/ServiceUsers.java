/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;
import interfaces.IServiceUsers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author Imen Frigui
 */
public class ServiceUsers implements IServiceUsers<User>{
    
    Connection connection;
    Statement ste;

    public ServiceUsers() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void ajouter(User u) {
        try {
            ste = connection.createStatement();
            String req = "INSERT INTO `job4u`.`Users` (`nom`,`prenom`,`pswd`) VALUES ('" + u.getNom() + "','" + u.getPrenom() + "'," + u.getPswd() + ");";
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    @Override
    public void supprimer(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ajouter2(User u) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `esprit3a11`.`Personne` (`nom`,`prenom`,`password`) VALUES (?,?,?)");
        pre.setString(1, u.getNom());
        pre.setString(2, u.getPrenom());
        pre.setString(3, u.getPswd());

        pre.executeUpdate();

    }

    @Override
    public ArrayList<User> afficher() {
        ArrayList<User> listusrs = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `job4u`.`Users`";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString("nom");
                String prenom = res.getString(3);
                String pswd = res.getString("password");
                User us = new User(id, nom, prenom, pswd);
                listusrs.add(us);
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listusrs;
    }

    public User getUserById(int id) throws SQLException {

        ste = connection.createStatement();
        ResultSet rs = ste.executeQuery("select * from users where Id=" + id + ";");
        String nom = null;
        String prenom = null;
        if (rs.next()) {
            nom = rs.getString("Nom");
            prenom = rs.getString("Prenom");
        }
        User u = new User(id, nom, prenom);
        System.out.println(u);
        return u;
    }

}
