/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import utils.MyConnection;
import entities.Project;
import entities.offre;
import interfaces.IServiceProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Ahmed
 */
public class ServiceProject implements IServiceProject<Project>{
    Connection connection;
    Statement ste;

    public ServiceProject() {
        
        connection = MyConnection.getInstance().getCnx();
    }
    
    
   

    @Override
    public void supprimer(Project t) {
        try{
        ste = connection.createStatement();
            String req ="DELETE FROM Projects Where proj_id="+t.getId()+";";
            ste.executeUpdate(req);}
        catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
            
    }

    @Override
    public void modifier(Project t) {
       try{
        ste = connection.createStatement();
        String req ="UPDATE `projects` SET "
                    + "`nom`='"+t.getNom()+"',"
                    + "`contact`='"+t.getSociete()+"'"
                    + " WHERE proj_id = '"+t.getId()+"'";
            //String req ="UPDATE Projects SET  nom ="+t.getNom()+"' , contact="+t.getRes_name()+" where proj_id="+t.getId()+";";
            ste.executeUpdate(req);}
       catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
    }

    
    @Override
    public void ajouter(Project t) {
        try {
            
            ste = connection.createStatement();
            String req ="Insert Into Projects (nom,scoiete) values ('"+t.getNom()+"','"+t.getSociete()+"' );";
            ste.executeUpdate(req);  
            
        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }    
    }
        

    @Override
    public void ajouter2(Project t) throws SQLException {
        PreparedStatement pre = connection.prepareStatement ("Insert Into Projects (nom,scoiete) values (?,?);" );
       // PreparedStatement pre = connection.prepareStatement("INSERT INTO projects (nom,contact) VALUES (?,?);");
        pre.setString(1, t.getNom());
        pre.setString(2, t.getSociete());
        
        pre.executeUpdate();
        
    }
      public ArrayList<String> afficher2() {
        ArrayList<String> list = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `Projects`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            String nom = res.getString("nom");
            list.add(nom);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return list;
    }

    @Override
    public ArrayList<Project> afficher() {
        ArrayList<Project> listpers = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `Projects`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String nom = res.getString("nom");
            String res_name = res.getString(3);
            Project pr = new Project(id,nom,res_name);
            listpers.add(pr);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listpers;
    }
    public ObservableList <Project> afficher1() {
        ObservableList<Project> listpers = FXCollections.observableArrayList() ;
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM projects;";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id = res.getInt(1);
            String nom = res.getString("nom");
            String desc = res.getString(3);
            Project of = new Project(id,nom,desc);
            listpers.add(of);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listpers;
    }
    
}
