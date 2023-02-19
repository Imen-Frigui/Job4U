/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Reclamation;
import Interfaces.IServiceReclamation;
import Utils.MyDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariem
 */
public class ServiceReclamation implements IServiceReclamation {
    Connection connection;
    Statement ste;
    public ServiceReclamation(){
        connection=MyDB.getInstance().getCon();
    }

   
    
    @Override
    public void ajouter(Reclamation r)   {
        try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement( "INSERT INTO `bdjob4you`.`reclamation` (`Titre_reclamation`, `description_reclamation`, `date_reclamation` ) VALUES (?,?,?)");
           // pre.setInt(1, r.getId_reclamation());
            pre.setString(1, r.getTitre_reclamation());
            pre.setString(2, r.getdescription_reclamation());
             pre.setString(3, r.getdate_reclamation());           
            
            //pre.setDate(2, new java.sql.Date(Calendar.getInstance().getTime().getTime()));

            pre.executeUpdate();
        } catch (SQLException ex) {
           System.out.println("erreur lors de lajout \n " + ex.getMessage());

        }
        
    }
   
        public void modifier1(int id_reclamation,Reclamation r){
        try {
             ste=(Statement) connection.createStatement();
           // String req_update=("Update bdjob4you set Date=2/15/3, Simple_user=3, Email=5 where Date =5");
              PreparedStatement pre = (PreparedStatement) connection.prepareStatement ("UPDATE  `bdjob4you`.`reclamation` SET `Titre_reclamation`=?,`description_reclamation`=?, `date_reclamation` =? WHERE `Id_reclamation`=?"); 

            pre.setString(1, r.getTitre_reclamation());

            pre.setString(2, r.getdescription_reclamation());
            

            pre.setString(3, r.getdate_reclamation());
            pre.setInt(4,  id_reclamation);

            pre.executeUpdate();

        } catch (SQLException ex) {
         System.out.println("erreur lors de modification  \n " + ex.getMessage());        }

        }
        
         public void supprimerl (int Id_reclamation){
        try {
            ste=(Statement) connection.createStatement();
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement ("DELETE FROM `bdjob4you`.`reclamation` WHERE `Id_reclamation`=?" );
                       pre.setInt(1, Id_reclamation);

            pre.executeUpdate();
        } catch (SQLException ex) {
             System.out.println("erreur lors de suppression  \n " + ex.getMessage());
        }
        
         }
        
        

    @Override
    public ArrayList<Reclamation> afficher() {
        ArrayList<Reclamation> listrec = new ArrayList<>();
        try{
        ste= (Statement) connection.createStatement();
        String req_select="SELECT `Id_reclamation`, `Titre_reclamation`, `description_reclamation`, `date_reclamation` FROM `reclamation` WHERE 1";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
           int Id_reclamation = res.getInt("Id_reclamation");
            String Titre_reclamation = res.getString("Titre_reclamation");
            String description_reclamation = res.getString("description_reclamation");
            String date_reclamation = res.getString("date_reclamation");
            Reclamation r = new Reclamation(Id_reclamation,Titre_reclamation,description_reclamation,date_reclamation);
            listrec.add(r);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        return listrec;
    }

    @Override
    public void supprimer(Reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void modifier(Reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
   
}
