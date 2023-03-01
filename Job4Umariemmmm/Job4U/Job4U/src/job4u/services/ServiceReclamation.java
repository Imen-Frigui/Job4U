/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.services;

 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import job4u.entities.Reclamation;
import job4u.*;
import job4u.utils.DataSource;
public class ServiceReclamation implements IServiceReclamation<Reclamation> {
    private Connection cnx = DataSource.getInstance().getConnection();

    @Override
    public void ajouter(Reclamation r) {
        String req = "INSERT INTO reclamation (message, type, statut, id_user) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getMessage());
            st.setString(2, r.getType());
            st.setString(3, r.getStatut());
            st.setInt(4, r.getId_user());
            st.executeUpdate();
            System.out.println("Reclamation ajoutée avec succès !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

 
        public void supprimer(String nom) {
        try {
        	String req = "SELECT id_reclamation FROM reclamation r JOIN user u ON r.id_user = u.id_user WHERE u.nom = '" + nom + "'";
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
    @Override
    public void modifier(Reclamation r) {
        String req = "UPDATE reclamation SET message = ?  WHERE id_reclamation ="+"10";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, r.getMessage());
             
            st.executeUpdate();
            System.out.println("Reclamation modifiée avec succès !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Reclamation> afficherTous() {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT r.*, u.nom FROM reclamation r INNER JOIN user u ON r.id_user = u.id_user "
        		;
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
        return reclamations;
    }

    @Override
    public List<Reclamation> afficherReclamationsParUser(String nom) {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "SELECT r.* FROM reclamation r INNER JOIN user u ON r.id_user = u.id_user WHERE u.nom LIKE  ?";
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

        @Override
    public void modifierStatutReclamation(Reclamation reclamation, String nouveauStatut, String role) {
        if (!role.equals("admin")) {
            System.out.println("Erreur : seule l'administrateur peut modifier une réclamation !");
            return;
        }
  
        try {
            String req1 = "SELECT id_reclamation FROM `reclamation` WHERE `type`='" + reclamation.getType()+ "'";
               Statement st = cnx.createStatement();
               ResultSet rs = st.executeQuery(req1);
                           System.out.println(reclamation.getType());

               if (rs.next()) {
                   int id = rs.getInt("id_reclamation");
                    System.out.println(id);

              String req = "UPDATE `reclamation` SET `statut`='" +nouveauStatut+
                    "' WHERE `id_reclamation`=" +  id;
                          System.out.println(req);

              st.executeUpdate(req);
            System.out.println("Statut de la reclamation modifié avec succès !");
            } else {
                   System.out.println("Réclamation non trouvée !");
               }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
public Reclamation rechercherReclamationParId(int id) {
        Reclamation reclamation = null;

     try {
      String sql = "SELECT message, type, statut, id_user FROM reclamations WHERE id_reclamation = "+id+ "'";
       Statement stmt = cnx.prepareStatement(sql);
                        ResultSet rs = stmt.executeQuery(sql);

        // Execute the query and get the result set
         
        // If a reclamation with the given id is found, create a Reclamation object with the retrieved data
        if (rs.next()) {
            String message = rs.getString("message");
            String type = rs.getString("type");
            String statut = rs.getString("statut");
            int id_user = rs.getInt("id_user");
              reclamation = new Reclamation(id, message, type, statut, id_user);
                    }
         }
      catch (SQLException ex) {
        ex.printStackTrace();
    }  
    
    return reclamation;
}

    
}

