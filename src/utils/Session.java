/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;


import entities.User;
import java.net.Authenticator;
import java.util.Properties;

/**
 *
 * @author user
 */
public final class Session {
     private static Session instance;

  
     private User SessionUser;
 

   
     private Session() {
     }
      private Session(User SessionUser) {
          this.SessionUser=SessionUser;
     }
     
     public static Session StartSession() {
        if(instance == null) {
            instance = new Session();
        }
        return instance;
    }
     
     public static Session StartSession(User SessionUser) {
        if(instance == null) {
            instance = new Session(SessionUser);
        }
        return instance;
    } 
     public static Session getSession() {
        return instance;
    }
      public  void clearSession() {
      SessionUser=null;
      
      
      }
      public void setSessionUser(User SessionUser){
      this.SessionUser=SessionUser;
      }
      public User getSessionUser(){
      return this.SessionUser;
      }
      
    

    
    public void SetSessionUser(User SessionUser ){
    this.SessionUser=SessionUser;
    
    }
}
