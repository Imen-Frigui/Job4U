/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import entities.Reclamation;

import utils.MyConnection;

public class ServiceReclamation {

    private Connection cnx = MyConnection.getInstance().getCnx();

    public void ajouter(Reclamation r) {
        String req = "INSERT INTO reclamation (message, type, statut) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getMessage());
            st.setString(2, r.getType());
            st.setString(3, r.getStatut());

            st.executeUpdate();
            System.out.println("Reclamation ajouter avec success !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void supprimer(String nom) {
        try {
            String req = "SELECT id_reclamation FROM reclamation r JOIN user u ON r.id_user = u.Id WHERE u.nom = '" + nom + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            if (rs.next()) {
                int id = rs.getInt("id_reclamation");
                String reqDelete = "DELETE FROM `reclamation` WHERE `id_reclamation`=" + id;
                st.executeUpdate(reqDelete);
                System.out.println("Réclamation supprimée !");
            } else {
                System.out.println("Réclamation non trouvée !");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifier(String msg, String nom) {

        try {
            String query = "UPDATE reclamation r JOIN user u ON r.id_user = u.Id SET r.message = ? WHERE u.Nom = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, msg);
            stmt.setString(2, nom);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " rows updated");
            System.out.println("Statut de la reclamation modifer � avec succes �s !");

        } catch (SQLException ex) {

            System.out.println("Reclamation non trouveee !");
            System.err.println(ex.getMessage());
        }

    }

    public ObservableList<Reclamation> afficherTous() {

        ObservableList<Reclamation> reclamations = FXCollections.observableArrayList();

        String req = "SELECT r.*, u.nom FROM reclamation r INNER JOIN user u ON r.id_user= u.Id ";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reclamation r = new Reclamation(
                        rs.getInt("id_reclamation"),
                        rs.getString("message"),
                        rs.getString("type"),
                        rs.getString("statut"),
                        rs.getInt("id_user"),
                        rs.getString("nom")
                );
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(reclamations.toString());
        return reclamations;
    }

    public List<Reclamation> afficherReclamationsParUser(String nom) {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT r.* FROM reclamation r INNER JOIN user u ON r.id_user = u.Id WHERE u.nom LIKE  ?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, nom);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reclamation r = new Reclamation(
                        rs.getInt("id_reclamation"),
                        rs.getString("message"),
                        rs.getString("type"),
                        rs.getString("statut"),
                        rs.getInt("id_user")
                );
                reclamations.add(r);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(reclamations);
        return reclamations;
    }

    public void modifierStatutReclamation(String nom, String nouveauStatut, String role) {
        if (!role.equals("admin")) {
            System.out.println("Erreur : seule l'administrateur peut modifier une réclamation !");
            return;
        }

        try {
            String query = "UPDATE reclamation r JOIN user u ON r.id_user = u.Id SET r.statut = ? WHERE u.Nom = ?";
            PreparedStatement stmt = cnx.prepareStatement(query);
            stmt.setString(1, nouveauStatut);
            stmt.setString(2, nom);
            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " rows updated");
            System.out.println("Statut de la reclamation modifer � avec succes �s !");

        } catch (SQLException ex) {

            System.out.println("Reclamation non trouveee !");
            System.err.println(ex.getMessage());
        }
    }

    public Reclamation rechercherReclamationParId(int id) {
        Reclamation reclamation = null;

        try {
            String sql = "SELECT message, type, statut, Id FROM reclamations WHERE id_reclamation = " + id + "'";
            Statement stmt = cnx.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            // Execute the query and get the result set
            // If a reclamation with the given id is found, create a Reclamation object with the retrieved data
            if (rs.next()) {
                String message = rs.getString("message");
                String type = rs.getString("type");
                String statut = rs.getString("statut");
                int Id = rs.getInt("Id");
                reclamation = new Reclamation(id, message, type, statut, Id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reclamation;
    }

}
