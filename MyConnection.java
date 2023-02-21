/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MyConnection {

    public  String url="jdbc:mysql://localhost:3306/pidevusers?serverTimezone=UTC"; 
    // hiya local host 3306 taa serveur mysql amma howa el gestionnaire te3o phpMyAdmine ou tgolo el base de donnes chniya esmha baad akal (?)
    public  String pwd="";
    public  String login="root";
    public static MyConnection instance;//hedhi el attribut staituqe et publique
    public Connection cnx;
    
    public Connection getCnx() {
        return cnx;
    }
    
    //hedhi tetsamma instancce welli ahna nest7a99o conctrcuteur prive ou methode statique ou attribut publique et statique

    private MyConnection() {//heedha constrcuteur priveee
         try {
             System.out.println("Connexion en cours");
             cnx=  DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static MyConnection getInstance(){
        
        if(instance == null){
            instance=new MyConnection();
        }
        return instance;//haja unique fardiya
    }

 
    
    
}
