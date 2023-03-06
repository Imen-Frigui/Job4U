/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import interfaces.UserInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author user
 */
public class ServiceUser {

    Connection connection;
    Statement ste;

    public ServiceUser() {
        connection = (Connection) MyConnection.getInstance().getCnx();
    }

    public ArrayList<User> afficher() {
        ArrayList<User> listusers = new ArrayList<>();
        try {
            ste = connection.createStatement();
            String req_select = "SELECT * FROM `pidevusers`.`users`";
            ResultSet res = ste.executeQuery(req_select);
            while (res.next()) {
                int id = res.getInt(1);
                String nom = res.getString(2);
                String prenom = res.getString(3);
                String mail = res.getString(4);
                String password = res.getString(5);
                String role = res.getString(6);

                User ur = new User(id, nom, prenom, mail, password, role);
                listusers.add(ur);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listusers;
    }

    public void SupprimerUser(int id) {

        try {
            System.out.println("supprimé");
            PreparedStatement pre = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            pre.setInt(1, id);
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void ajouter2(User u) {
        try {
            PreparedStatement pre = connection.prepareStatement("INSERT INTO `pidevusers`.`users` (`Nom`,`Prenom`,`Mail`,`Password`,`Role`) VALUES (?,?,?,?,?)");

           
            pre.setString(1, u.getNom());
            pre.setString(2, u.getPrenom());
            pre.setString(3, u.getMail());
            pre.setString(4, u.getPassword());
            pre.setString(5, u.getRole());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

    }
      public void ajouter3(User u) {
        try {
            PreparedStatement pre = connection.prepareStatement("INSERT INTO `pidevusers`.`users` (`Mail`,`Password`) VALUES (?,?)");

           
            pre.setString(1, u.getMail());
            pre.setString(2, u.getPassword());
      

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

    }

    public User ChercherParMail(String mail) {

        try {
            PreparedStatement pre = connection.prepareStatement("SELECT * FROM users where mail = ?");
            pre.setString(1, mail);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                User u = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
                return u;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
    
     public ArrayList<User> ChercherPaNom(String Nom) {
  ArrayList<User> listusersNames = new ArrayList<>();
        try {
          
            PreparedStatement pre = connection.prepareStatement ("SELECT * FROM users where nom = ?");
           
           pre.setString(1, Nom);
            ResultSet result = pre.executeQuery();
           
            while (result.next()) {
              
                 int id = result.getInt(1);
                String nom = result.getString(2);
                String prenom = result.getString(3);
                String mail = result.getString(4);
                String password = result.getString(5);
                String role = result.getString(6);

                User ur = new User(id, nom, prenom, mail, password, role);
                listusersNames.add(ur);
                System.out.println("Min aand el base de donnes" + listusersNames);
                pre.executeUpdate();
            }
            
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
       public User filterByRole(String Role) {

        try {
            PreparedStatement pre = connection.prepareStatement("SELECT * FROM users where role = ?");
            pre.setString(1, Role);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                User u = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
                return u;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }

    public void ModifierUser(User u) {

        try {

            PreparedStatement pre = connection.prepareStatement("UPDATE users SET nom=?,prenom=?,mail=?,password=?,role=? WHERE id = ?");

           pre.setString(1, u.getNom());
            pre.setString(2, u.getPrenom());
            pre.setString(3, u.getMail());
            pre.setString(4, u.getPassword());
            pre.setString(5, u.getRole());
            pre.setInt(6, u.getId());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

    }

    public boolean isExiste(String mail) {

        try {
            PreparedStatement pre = connection.prepareStatement("SELECT * FROM users where mail = ?");
            pre.setString(1, mail);
            ResultSet result = pre.executeQuery();
            return result.first();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        }
    }
    
    
    
    public User ChercherParId(int id) {

        try {
            PreparedStatement pre = connection.prepareStatement("SELECT * FROM users where id = ?");
            pre.setInt(1, id);
            ResultSet result = pre.executeQuery();
            while (result.next()) {
                User u = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
                return u;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
    
    
     public int CountUsersPerRole(String Role) {

        int i = 0;
        String requete = "SELECT * FROM users where role= ?  ";

        try {
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1,Role);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             i=i+1;
            }
          
         return i; 
         

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return i;
    }

     
     public void ModifierUserProfile(User u) {

        try {

            PreparedStatement pre = connection.prepareStatement("UPDATE users SET nom=?,prenom=?,mail=? WHERE id = ?");

           pre.setString(1, u.getNom());
            pre.setString(2, u.getPrenom());
            pre.setString(3, u.getMail());
   
        
            pre.setInt(4, u.getId());

            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

    }
   
}
