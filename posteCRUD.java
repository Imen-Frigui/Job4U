/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jobforu.services;

import edu.jobforu.interfaces.InterfaceCRUD;
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
 * @author belkn
 */
public class posteCRUD implements InterfaceCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
    @Override
    public void ajouterposte(poste p) {
        try {
            String req = "INSERT INTO `poste`(`date_publication`,`region`,`categorie`,`cv`,`titre`) VALUES ('"+p.getDate_publication()+"','"+p.getRegion()+"','"+p.getCategorie()+"','"+p.getCv()+"','"+p.getTitre()+"')";
            ste = conn.createStatement();
            ste.executeUpdate(req);
            System.out.println("poste ajouté!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                      }
 }
 
    @Override
    public void modifierposte(poste p ) {
        try {
            String req = "UPDATE `poste` SET `date_publication` = '" + p.getDate_publication()+ "',`region` = '" + p.getRegion()+ "',`categorie` = '" + p.getCategorie()+ "',`cv` = '" + p.getCv()+ "',`titre` = '" + p.getTitre()+ "' WHERE `id_poste` = " + p.getId_poste();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("voiture updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        }
    
    
   
    @Override
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
    

    @Override
    public List<poste> afficherposte() {
       List<poste> list = new ArrayList<>();
        try {
            String req = "Select * from poste";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             poste p = new poste();
             p.setId_poste(RS.getInt(1));
                p.setDate_publication(RS.getString(2));
                
                p.setRegion(RS.getString(3));    
                p.setCategorie(RS.getString(4));
                 p.setCv(RS.getString(5));
                  
                    p.setTitre(RS.getString(6));
                        
                
             
             list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    
    
}
