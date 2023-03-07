/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Connn.MyDB;
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
        
        connection = MyDB.getInstance().getCon();
    }
    
    
   

    @Override
    public void supprimer(offre t) {
        try{
        ste = connection.createStatement();
            String req ="DELETE FROM offrefinal Where id="+t.getId()+");";
            ste.executeUpdate(req);}
        catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }          
    }
     public void supprimer1(int t) {
        try{
        ste = connection.createStatement();
            String req ="DELETE FROM offre Where id="+t+";";
            ste.executeUpdate(req);}
        catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
            
    }

    @Override
    public void modifier(offre t) {
       try{
        ste = connection.createStatement();
        String reqq="UPDATE offrefinal SET nom='"+t.getNom()+"', descrip='"+t.getDesc()+"', date_debut='"+t.getDate_debut()+"', duree ='"+t.getDuree()+"' WHERE id='"+t.getId()+"';";
           // String req ="UPDATE offre SET  nom ="+t.getNom()+" , descrip ="+t.getDesc()+" , duree="+t.getDuree()+"  where id="+t.getId()+";";
            ste.executeUpdate(reqq);}
       catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
    }
   
    

    @Override
    public void ajouter2(offre t) throws SQLException { 
        PreparedStatement pre = connection.prepareStatement("INSERT INTO offrefinal (nom,descrip,date_debut,duree,proj_id) VALUES (?,?,?,?,?)");
        pre.setString(1, t.getNom());
        pre.setString(2, t.getDesc());
        pre.setDate(3,t.getDate_debut());
        pre.setString(4,t.getDuree());
        pre.setInt(5,t.getProj_id());
        pre.executeUpdate();
        
    }

    @Override
    public ArrayList<offre> afficher() {
        ArrayList<offre> listpers = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM offrefinal;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String nom = res.getString("nom");
            String desc = res.getString(3);
            Date date_debut = res.getDate(4);
            String duree = res.getString(5);
            int proj_id = res.getInt(6);
            offre of = new offre(id,nom,desc,date_debut,duree,proj_id);
            listpers.add(of);
        }
        }catch(SQLException ex){
          //  System.out.println("SQLException "+ex.getMessage());
            System.out.println("Error sql");
        }
        
        return listpers;
    }
     public ObservableList <offre> afficher1() {
        ObservableList<offre> listpers = FXCollections.observableArrayList() ;
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM offrefinal;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
           int id = res.getInt(1);
            String nom = res.getString("nom");
            String desc = res.getString(3);
            Date date_debut = res.getDate(4);
            String duree = res.getString(5);
            int proj_id = res.getInt(6);
            offre of = new offre(id,nom,desc,date_debut,duree,proj_id);
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


