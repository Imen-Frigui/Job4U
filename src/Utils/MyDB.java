/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**s
 
 * @author user
 */
public class MyDB {
    final String url="jdbc:mysql://localhost:3306/pidevusers";
    final String user="root";
    final String pwd="";
    Connection con;

    public static MyDB db;
    private MyDB() {       
        try {
            System.out.println("Connexion en cours");
            con= (Connection) DriverManager.getConnection(url, user, pwd);
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
        return con;
    }
     
}
