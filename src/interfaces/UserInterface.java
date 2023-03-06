/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;


import entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;


/**
 *
 * @author user
 */
public interface UserInterface<T>{
    
        public void supprimer(int id) throws SQLException;
        
        public void ajouter2(T u) throws SQLException ;
        public void ajouter3(T u) throws SQLException ;
        
        
         public User ChercherParId(int id) throws SQLException;
        
        public User ChercherParMail (String mail);
        
       public void ModifierUser(User u) throws SQLException;
       
        public boolean isExiste(String mail)  throws SQLException;
     
    public ArrayList<T> afficher();
    
}
