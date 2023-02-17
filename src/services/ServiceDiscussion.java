/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Discussion;
import interfaces.IServiceDiscussion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.MyDB;

/**
 *
 * @author GO BRO
 */
public class ServiceDiscussion implements IServiceDiscussion<Discussion> {
    Connection connection;
    Statement ste;

    public ServiceDiscussion() {
        connection = MyDB.getInstance().getCon();
    }

    @Override
    public void Add(Discussion d) throws SQLException {
        PreparedStatement pre = connection.prepareStatement("INSERT INTO `job4u`.`discussion` (`id_sender`,`id_reciver`) VALUES (?,?)");
        pre.setInt(1, d.getId_sender());
        pre.setInt(2, d.getId_reciver());
        
        pre.executeUpdate();  
    }

    @Override
    public void Delete(Discussion d) {
        try {
            String requete = "DELETE FROM `job4u`.`discussion` WHERE `id_disc`=?";
            PreparedStatement ps = connection.prepareStatement(requete);      
            ps.setInt(1,d.getId_disc());
            ps.executeUpdate();
            ps.close();
            System.out.println("Discussion supprimee !");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression de la discussion \n " + ex.getMessage());
        }
    }


    @Override
    public ArrayList<Discussion> afficher() {
        ArrayList<Discussion> listDisc = new ArrayList<>();
        try{
        ste= connection.createStatement();
        String req_select="SELECT * FROM `job4u`.`discussion`";
        ResultSet res = ste.executeQuery(req_select);
        while(res.next()){
            int id_disc = res.getInt(1);
            int sender = res.getInt(2);
            int reciver = res.getInt(3);
            Discussion disc = new Discussion(id_disc,sender,reciver);
            listDisc.add(disc);
        }
        }catch(SQLException ex){
            System.out.println("SQLException "+ex.getMessage());
        }
        
        return listDisc;    }
    


    
}
