/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.jobforu.services;

import jobforu.troc.model.commentaire;
import jobforu.troc.model.poste;
import edu.jobforu.utils.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wissal
 */
public class commentaireCRUD {
        Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
    
    public void ajouterposte(commentaire c) {
        try {
            String req = "INSERT INTO `commentaire`(`date_publication`,`photos`,`region`,`categorie`,`description`,`valeur`,`titre`) VALUES ('"+c.getDate_publication()+"','"+c.getPhoto()+"','"+c.getRegion()+"','"+c.getCategorie()+"','"+c.getDescription()+"','"+c.getValeur()+"','"+c.getTitre()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("poste ajouté!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                      }
 }
 
    
    public void modifierposte(poste p ) {
        try {
            String req = "UPDATE `poste` SET `date_publication` = '" + p.getDate_publication()+ "', `photos` = '" + p.getPhoto()+"',`region` = '" + p.getRegion()+ "',`categorie` = '" + p.getCategorie()+ "',`description` = '" + p.getDescription()+ "',`valeur` = '" + p.getValeur()+ "',`titre` = '" + p.getTitre()+ "' WHERE `id_poste` = " + p.getId_poste();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
    
   
    
    public void supprimerposte(int id) {
        try {
            String req = "DELETE FROM `poste` WHERE id_poste = " + id;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    
    public List<commentaire> afficherposte() {
       List<poste> list = new ArrayList<>();
        try {
            String req = "Select * from poste";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             poste p = new poste();
             p.setId_poste(RS.getInt(1));
                p.setDate_publication(RS.getString(2));
                p.setPhoto(RS.getString(3));
                p.setRegion(RS.getString(4));    
                p.setCategorie(RS.getString(5));
                 p.setDescription(RS.getString(6));
                  p.setValeur(RS.getInt(7));
                    p.setTitre(RS.getString(8));
                        
                
             
             list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
}
