/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Postulation;
import Interfaces.IServicePostulation;
import Utils.MyDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;

/**
 *
 * @author user
 */
public class ServicePostulation implements IServicePostulation {
    Connection connection;
    Statement ste;
    public ServicePostulation(){
        connection=MyDB.getInstance().getCon();
    }

   
    
    @Override
    public void ajouter(Postulation p)
    {java.util.Date utilDate = p.getDate();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("INSERT INTO `postulation`(`id_pos`, `date`, `Simple_user`, `Email`) VALUES (?,?,?,?)");
            pre.setInt(1,p.getId_pos());
            //pre.setDate(2, (java.sql.Date) p.getDate());
            //pre.setDate(2, java.sql.Date.valueOf(p.getDate()));
            pre.setDate(2, sqlDate);
            pre.setString(3, p.getSimple_user());
            pre.setString(4, p.getEmail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
       public void modifier(Postulation p){
           /*try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("UPDATE `postulation` SET `date`='?',`Email`='?' WHERE `id_pos`=?");
            pre.setInt(3,p.getId_pos());
            pre.setString(2, p.getDate());
            pre.setString(1, p.getEmail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);*/
        }
           
    public void modifier(int id, Postulation p) {
        /*try {
            String query = "UPDATE `postulation` SET `date`='?',`Email`='?' WHERE `id_pos`=?";
            PreparedStatement preparedStmt = (PreparedStatement) connection.prepareStatement(query);
            preparedStmt.setString(1,p.getEmail());
            preparedStmt.setString(3,p.getSimple_user());
            preparedStmt.setInt(2,p.getId_pos());
            // execute the java preparedstatement
            preparedStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur lors de la modif de la postulation \n " + e.getMessage());
        }*/
    

        
        try {
            ste=(Statement) connection.createStatement();
            
            String req_update=("UPDATE `postulation` SET `id_pos`,`date`=?,`Simple_user`=?,`Email`=? WHERE  `id_pos`=10;");
           
            ste.executeUpdate(req_update);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }
            

    }  
    @Override
         public void supprimer(Postulation p){
        try {
            ste=(Statement) connection.createStatement();
            String req_update=("DELETE FROM `postulation` WHERE `id_pos`=?;");
            ste.executeUpdate(req_update);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         }
    @Override
         public void supprimer1(int id_pos){
          try {
            System.out.println("supprimé");
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("DELETE FROM `postulation` WHERE id_pos = ?");
            pre.setInt(1, id_pos);
            pre.executeUpdate();

        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }}
         
    @Override
         public void Modifier(Postulation p) {
            java.util.Date utilDate = p.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        try {

            java.sql.PreparedStatement pre = connection.prepareStatement("UPDATE `postulation` SET date=?,Email=?  WHERE id = ?;");

           pre.setDate(1, sqlDate );
           pre.setString(2, p.getSimple_user());
            pre.setString(3, p.getEmail());         
            pre.setInt(4, p.getId_pos());
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }

    }
    @Override
          public ArrayList<Postulation> afficher() {
        ArrayList<Postulation> listpos = new ArrayList<>();
        try {
            ste = (Statement) connection.createStatement();
            String req_select = "SELECT * FROM `postulation`";
            ResultSet res = ste.executeQuery(req_select);
            Postulation p1 =new Postulation();
            java.util.Date utilDate = p1.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            while (res.next()) {
                int id_pos = res.getInt(1);
                Date date = res.getDate(2);
                String Simple_user = res.getString(3);
                String Email = res.getString(4);
                Postulation p = new Postulation(id_pos,date,Simple_user,Email);
                listpos.add(p);
                
            }
        } catch (SQLException ex) {
            System.out.println("SQLException " + ex.getMessage());
        }

        return listpos;
    }
    public Postulation ChercherParId(int id_pos) {
        try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("SELECT * FROM `postulation` where id_pos = ?");
            pre.setInt(1, id_pos);
            ResultSet result = pre.executeQuery();
            
            while (result.next()) {
                Postulation p = new Postulation(
                        result.getInt(1),
                        result.getDate(2),
                        result.getString(3),
                        result.getString(4));
                return p;
            }
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return null;
    }
   
   
}
