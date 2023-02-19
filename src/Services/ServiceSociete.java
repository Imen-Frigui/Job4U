/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Categorie;
import Interfaces.IServiceCategorie;
import Utils.MyDB;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ServiceCategorie implements IServiceCategorie {
 Connection connection;
    Statement ste;
    public ServiceCategorie(){
        connection=MyDB.getInstance().getCon();
    }
 @Override
    public void ajouter(Categorie c ) {
     try {
          // PreparedStatement pre = (PreparedStatement) connection.prepareStatement("INSERT INTO `bdjob4you`.`categorie` (`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (5,loll,klk)");
         pre.setString(1, c.getid_categorie());
         pre.setString(2, c.getnom_categorie());
         pre.setString(3, c.getdescription_categorie());
         pre.executeUpdate();
     } catch (SQLException ex) {
         Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
     }

    }

 @Override
    public void modifier(Categorie c) {
     try {
         ste=(Statement) connection.createStatement();
          //String req_update=("Update bdjob4you set Date=2/15/3, adresse=3, email=5 where Date =5");
         ste.executeUpdate(req_update);
     } catch (SQLException ex) {
         Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

 @Override
    public void supprimer(Categorie c) {
     try {
         ste=(Statement) connection.createStatement();
        // String req_update=("DELETE FROM `bdjob4you` Date`.`adresse`WHERE Email=5 . Date =5");
         ste.executeUpdate(req_update);
     } catch (SQLException ex) {
         Logger.getLogger(ServiceCategorie.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

 @Override
    public ArrayList<Categorie> afficher() {
 ArrayList<Categorie> listsos = new ArrayList<>();
        try{
        ste= (Statement) connection.createStatement();
        String req_select="SELECT * FROM `Categorie`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            Int id_categorie = res.getInt("id_categorie");
            String nom_categorie = res.getString("nom_categorie");
            String description_categorie = res.getString("description_categorie");
            Categorie s = new Categorie(nom,adresse,email);
            listsos.add(c);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        return listsos;
    }
    
}
