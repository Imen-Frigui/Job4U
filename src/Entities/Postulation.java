/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Postulation {
    private String Date;
    private String Simple_user;
    private String Email;
    
    public Postulation(String Date, String Simple_user, String Email) {
        this.Date = Date;
        this.Simple_user = Simple_user;
        this.Email = Email;
    }

    public Postulation(){
}
    public String getDate() {
        return Date;
    }

    public String getSimple_user() {
        return Simple_user;
    }

    public String getEmail() {
        return Email;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setSimple_user(String Simple_user) {
        this.Simple_user = Simple_user;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Postulation{" + "Date=" + Date + ", Simple_user=" + Simple_user + ", Email=" + Email + '}';
    }

  
}