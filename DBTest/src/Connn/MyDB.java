/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connn;

/**
 *
 * @author Ahmed
 */
import java.sql.*;

public class MyDB {
    final String url="jdbc:mysql://localhost:3306/pidv";
    final String user="root";
    final String pwd="";
    Connection conn;
      
    
     public static MyDB db;
    
  
   //rendre le constructeur prive
    private MyDB() {
        
        try {
            System.out.println("Connexion en cours");
            conn= (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println("Probleme de connexion : "+ex.getMessage());
            
        }
    }
    
     public static MyDB getInstance(){
        if(db==null)
            db=new MyDB();
        return db;
        
    }

    public Connection getCon() {
        return conn;
    }
    
}
