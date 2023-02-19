/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Imen Frigui
 */
public class MyDB {
    final String url="jdbc:mysql://localhost:3306/job4u";
    final String user="root";
    final String pwd="";
    Connection con;
    
    public static MyDB db;
    
  
   //rendre le constructeur prive
    private MyDB() {   
        try {
            System.out.println("Connexion en cours ....");
            con= (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("Connected");
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
        return con;
    }
}
    