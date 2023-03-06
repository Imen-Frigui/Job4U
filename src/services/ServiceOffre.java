/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import utils.MyConnection;
import entities.offre;
import interfaces.IServiceOffre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ahmed
 * */
public class ServiceOffre implements IServiceOffre<offre>{
    Connection connection;
    Statement ste;
    public ServiceOffre() {
        
        connection = MyConnection.getInstance().getCnx();
    }
    
    
   

    @Override
    public void supprimer(offre t) {
        try{
        ste = connection.createStatement();
            String req ="DELETE FROM offre Where id="+t.getId()+");";
            ste.executeUpdate(req);}
        catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }       
        
        /*  try {
            System.out.println("supprimé");
            PreparedStatement pre = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            pre.setInt(1, id);
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }*/
    }
     public void supprimer1(int id) {
        try{
        PreparedStatement pre = connection.prepareStatement("DELETE FROM offre WHERE id = ?");
             pre.setInt(1, id);
               pre.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
           /*  try {
            System.out.println("supprimé");
            PreparedStatement pre = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            pre.setInt(1, id);
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }*/  
    }

    @Override
    public void modifier(offre t) {
       try{
        ste = connection.createStatement();
        String reqq="UPDATE offre SET nom='"+t.getNom()+"', descrip='"+t.getDesc()+"', duree ='"+t.getDuree()+"' WHERE id='"+t.getId()+"';";
           // String req ="UPDATE offre SET  nom ="+t.getNom()+" , descrip ="+t.getDesc()+" , duree="+t.getDuree()+"  where id="+t.getId()+";";
            ste.executeUpdate(reqq);}
       catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
    }
   
    

    @Override
    public void ajouter2(offre t) throws SQLException { 
        PreparedStatement pre = connection.prepareStatement("INSERT INTO offre (nom,descrip,duree,proj_id) VALUES (?,?,?,?)");
        pre.setString(1, t.getNom());
        pre.setString(2, t.getDesc());
        pre.setString(3,t.getDuree());
        pre.setInt(4,t.getProj_id());
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<offre> afficher() {
        ArrayList<offre> listpers = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM offre;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String nom = res.getString("nom");
            String desc = res.getString(3);
            String duree = res.getString(4);
            offre of = new offre(id,nom,desc,duree);
            listpers.add(of);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listpers;
    }
     public ObservableList <offre> afficher1() {
        ObservableList<offre> listpers = FXCollections.observableArrayList() ;
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM offre;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String nom = res.getString("nom");
            String desc = res.getString(3);
            String duree = res.getString(4);
            offre of = new offre(id,nom,desc,duree);
            listpers.add(of);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listpers;
    }
    
    @Override
    public void ajouter(offre t) throws SQLException {

        try {
            
            ste = connection.createStatement();
            String req =" INSERT INTO `offre`(`nom`, `descrip`, `duree`) VALUES ('"+t.getNom()+"','"+t.getDesc()+"','"+t.getDuree()+"')";
           // String req ="Insert Into Projects (nom,descrip,duree) values ('"+t.getNom()+"','"+t.getDesc()+"','"+t.getDuree()+"' );";
            ste.executeUpdate(req);  
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
        
    }

    
}


