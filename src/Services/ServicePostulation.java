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
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServicePostulation implements IServicePostulation {
    Connection connection;
    Statement ste;
    private java.util.Date date;
    public ServicePostulation(){
        connection=MyDB.getInstance().getCon();
    }

   
    
    @Override
    public void ajouter(Postulation p)   {
        try {
            PreparedStatement pre = (PreparedStatement) connection.prepareStatement("INSERT INTO `postulation`(`Date`, `Simple_user`, `Email`) VALUES (?,?,?)");
            pre.setDate(1, (Date) p.getDate());
            pre.setString(2, p.getSimple_user());
            pre.setString(3, p.getEmail());
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
        public void modifier(Postulation p){
        try {
            ste=(Statement) connection.createStatement();
            String req_update=("UPDATE `postulation` SET `Date`='[value-1]',`Simple_user`='[value-2]',`Email`='[value-3]' WHERE 1");
            ste.executeUpdate(req_update);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    @Override
         public void supprimer(Postulation p){
        try {
            ste=(Statement) connection.createStatement();
            String req_update=("DELETE FROM `postulation` WHERE Date ='hhh';");
            ste.executeUpdate(req_update);
        } catch (SQLException ex) {
            Logger.getLogger(ServicePostulation.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
        
        

    @Override
    public ArrayList<Postulation> afficher() {
        ArrayList<Postulation> listpos = new ArrayList<>();
        try{
        ste= (Statement) connection.createStatement();
        String req_select="SELECT `Date`, `Simple_user`, `Email` FROM `postulation` WHERE Date='jhjh';";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            String Date = res.getString("Date");
            String Simple_user = res.getString(3);
            String Email = res.getString("Email");
            Postulation p = new Postulation(date,Simple_user,Email);
            listpos.add(p);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        return listpos;
    }
   
   
}
