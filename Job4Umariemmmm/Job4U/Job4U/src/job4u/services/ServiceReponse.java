/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.services;
import java.net.PasswordAuthentication;
 import java.util.Properties;
 import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
  
  
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import job4u.entities.Reponse;
import job4u.*;
import job4u.utils.DataSource;
 
  
public class ServiceReponse implements IServiceReponse<Reponse> {
 
    private Connection cnx = DataSource.getInstance().getConnection();
    

    @Override
    public void ajouterReponse(Reponse reponse,String to) {
        String req = "INSERT INTO reponse (id_reclamation, message_rep, date_rep) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, reponse.getId_reclamation());
            st.setString(2, reponse.getMessage_rep());
            st.setString(3, reponse.getDate_rep());
            st.executeUpdate();
            System.out.println("Réponse ajoutée avec succès !");
             // Send email to user
     //
     //String to = getUserEmail(reponse.getId_reclamation()); // Get user email from database
        String subject = "Nouvelle réponse à votre réclamation";
        String body = "Bonjour,\n\nUne nouvelle réponse a été ajoutée à votre réclamation.\n\nCordialement,\nL'équipe de support";
        sendEmail(to, subject, body); // Call function to send email
        } catch (SQLException ex) {
        }
    }
    private void sendEmail(String to, String subject, String body) {
        String username = "dridimaryem124@gmail.com";
        String password = "rpoaltvyodatlugr";
         Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); // Change this to your SMTP server host(yahoo...)
            props.put("mail.smtp.port", "587"); // Change this to your SMTP server port
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session;
            session = Session.getInstance(props,new Authenticator() {
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new jakarta.mail.PasswordAuthentication(username, password);
            }
        });
           
           
               try {
                // Create a MimeMessage object
     
    // Create a new message
                MimeMessage message = new MimeMessage(session);
                // Set the From, To, Subject, and Text fields of the message
                message.setFrom(new InternetAddress(username));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(subject);
                message.setText(body);

                // Send the message using Transport.send
                Transport.send(message);

                System.out.println("Email sent successfully");
            } catch (MessagingException ex) {
                System.err.println("Failed to send email: " + ex.getMessage());
            }
        }
 
 




   
 
private String getUserEmail(int id_reclamation) {
    String email = null;

    String req = "SELECT email FROM utilisateur WHERE id_reclamation = ?";
    try {
        PreparedStatement st = cnx.prepareStatement(req);
        st.setInt(1, id_reclamation);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            email = rs.getString("email");
        }
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
    }

    return email;
}

    @Override
    public void supprimerReponse(Reponse reponse) {
        String req = "DELETE FROM reponse WHERE id_reclamation = ?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, reponse.getId_reclamation());
            st.executeUpdate();
            System.out.println("Réponse supprimée avec succès !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifierReponse(Reponse reponse) {
        String req = "UPDATE reponse SET message_rep = ?, date_rep = ? WHERE id_reclamation = ?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setString(1, reponse.getMessage_rep());
            st.setString(2, reponse.getDate_rep());
            st.setInt(3, reponse.getId_reclamation());
            st.executeUpdate();
            System.out.println("Réponse modifiée avec succès !");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Reponse> afficherTousReponses() {
        List<Reponse> listeReponses = new ArrayList<>();
        String req = "SELECT r.*, u.statut FROM reponse r LEFT JOIN reclamation u ON r.id_reclamation = u.id_reclamation"
        		+ "";
        try {
           Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reponse reponse = new Reponse(
                    rs.getInt("id_reponse"),
                    rs.getInt("id_reclamation"),
                    rs.getString("message_rep"),
                    rs.getString("date_rep"),
                    rs.getString("statut")

                );
                
                listeReponses.add(reponse);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
          System.err.println(listeReponses);
        return listeReponses;
    }

    @Override
    public List<Reponse> afficherReponsesParReclamation(int id_reclamation) {
        List<Reponse> listeReponses = new ArrayList<>();
        String req = "SELECT * FROM reponse WHERE id_reclamation = ?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, id_reclamation);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Reponse reponse = new Reponse(
                    rs.getInt("id_reponse"),
                    rs.getInt("id_reclamation"),
                    rs.getString("message_rep"),
                    rs.getString("date_rep")
                );
                listeReponses.add(reponse);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return listeReponses;
    }
}
