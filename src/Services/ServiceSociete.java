/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entities.Societe;
import Interfaces.IServiceSociete;
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
public class ServiceSociete implements IServiceSociete {
 Connection connection;
    Statement ste;
    public ServiceSociete(){
        connection=MyDB.getInstance().getCon();
    }
 @Override
    public void ajouter(Societe s) {
     try {
         PreparedStatement pre = (PreparedStatement) connection.prepareStatement("INSERT INTO `societe`(`nom`, `adresse`, `email`) VALUES (?,?,?)");
         pre.setString(1, s.getNom());
         pre.setString(2, s.getAdresse());
         pre.setString(3, s.getEmail());
         pre.executeUpdate();
     } catch (SQLException ex) {
         Logger.getLogger(ServiceSociete.class.getName()).log(Level.SEVERE, null, ex);
     }

    }

 @Override
    public void modifier(Societe s) {
     try {
         ste=(Statement) connection.createStatement();
         String req_update=("UPDATE `societe` SET `nom`='[value-1]',`adresse`='[value-2]' WHERE 1");
         ste.executeUpdate(req_update);
     } catch (SQLException ex) {
         Logger.getLogger(ServiceSociete.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

 @Override
    public void supprimer(Societe s) {
     try {
         ste=(Statement) connection.createStatement();
         String req_update=("DELETE FROM `societe` WHERE 0");
         ste.executeUpdate(req_update);
     } catch (SQLException ex) {
         Logger.getLogger(ServiceSociete.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

 @Override
    public ArrayList<Societe> afficher() {
 ArrayList<Societe> listsos = new ArrayList<>();
        try{
        ste= (Statement) connection.createStatement();
        String req_select="SELECT `nom`, `adresse`, `email` FROM `societe` WHERE 1";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            String nom = res.getString("nom");
            String adresse = res.getString(3);
            String email = res.getString("Email");
            Societe s = new Societe(nom,adresse,email);
            listsos.add(s);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        return listsos;
    }
    
}
