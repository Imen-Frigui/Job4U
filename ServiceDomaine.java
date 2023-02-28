/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Domaine;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DataSource;

/**
 *
 * @author wissal
 */
public class ServiceDomaine implements Iservice<Domaine> {
    
     Connection cnx = DataSource.getInstance().getCnx();
    @Override 
    public void ajouter(Domaine d) {
        try {
            String req = "INSERT INTO domaine (Nom) VALUES ('" + d.getNom() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Domaine created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM domaine  WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Domaine deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void modifier(Domaine d) {
        try {
            String req = "UPDATE domaine SET Nom = '" + d.getNom() + "' WHERE domaine.id = " + d.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Domaine updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public List<Domaine> getAll() {
        List<Domaine> list = new ArrayList<>();
        try {
            String req = "Select * from Domaine";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                
                Domaine d = new Domaine(rs.getInt(1), rs.getString(2));
                list.add(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    @Override
    public Domaine getOneById(int id) {
        Domaine d = null;
        try {
            String req = "Select * from domaine WHERE domaine.id = "+id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                d = new Domaine(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return d;
    }
    
    public Domaine getOneByName(String test) {
        Domaine d = null;
        try {
            String req = "Select * from domaine WHERE domaine.nom = "+test;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                d = new Domaine(rs.getInt(1), rs.getString(2));
                System.out.println(d);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return d;
    }

     public ObservableList<Domaine> getall() {
        ObservableList<Domaine> posts = FXCollections.observableArrayList();
        try {
            String req = "select distinct nom from domaine";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Domaine d = new Domaine(rs.getString("nom"));
                
               posts.add(d);
            }
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
     public ObservableList<String> getalls() {
        ObservableList<String> posts = FXCollections.observableArrayList();
        try {
            String req = "select distinct nom from domaine";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
            String d = (rs.getString("nom"));
                
               posts.add(d);
            }
            

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return posts;
    }
}
    
    

