/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Societe;
import utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceSociete {
    java.sql.Connection connection;
    java.sql.Statement ste;

    public ServiceSociete() {
        connection = MyConnection.getInstance().getCnx();
    }
 
    public void ajouter(Societe s) {
     try {
         PreparedStatement pre =  connection.prepareStatement("  INSERT INTO `societe`(`nom`, `adresse`, `email`, `tel`, `domaine`, `sos_image`) VALUES (?,?,?,?,?,?)  ");
         pre.setString(1, s.getNom());
         pre.setString(2, s.getAdresse());    
         pre.setString(3, s.getEmail());
         pre.setString(4, s.getTel());
         pre.setString(5, s.getDomaine());
         pre.setString(6, s.getSos_image());
         
         pre.executeUpdate();
     } catch (SQLException ex) {
           System.out.println("SQLException "+ex.getMessage());
     }

    }

 
    public void modifier(String nom) {
     try {
         ste=connection.createStatement();
         String req_update=("UPDATE `societe` SET `adresse`=?,`email`=?,`tel`=?,`domaine`=?,`sos_image`=? WHERE `nom`=?");
         ste.executeUpdate(req_update);
     } catch (SQLException ex) {
           System.out.println("SQLException "+ex.getMessage());
     }
    }

    /**
     *
     * @param nom
     */
    
    public void supprimer(String nom) {
     try {
            String requete = "DELETE FROM `pidevusers`.`societe` WHERE `nom`=?";
            PreparedStatement pst = connection.prepareStatement(requete);
            pst.setString(1, nom);
            pst.executeUpdate();
     } catch (SQLException ex) {
           System.out.println("SQLException "+ex.getMessage());
     }
    }

 
    public ArrayList<Societe> afficher() {
 ArrayList<Societe> listsos = new ArrayList<>();
        try{
        ste=  connection.createStatement();
        String req_select="SELECT * FROM `societe`";
        ResultSet res = (ResultSet) ste.executeQuery(req_select);
        while(res.next()){
            String nom = res.getString("nom");
            String adresse = res.getString(3);
            String email = res.getString("email");
             String tel = res.getString("tel");
              String domaine = res.getString("domaine");
        Societe s= new Societe(nom,adresse,email,tel,domaine);
            listsos.add(s);
        }
        }catch(SQLException ex){
           System.out.println("SQLException "+ex.getMessage());
        }
        return listsos;
    }

   
    
}
