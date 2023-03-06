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
    private int id_pos;
    private String date;
    private String Simple_user;
    private String Email;

    public Postulation(int id_pos, String date, String Simple_user, String Email) {
        this.id_pos = id_pos;
        this.date = date;
        this.Simple_user = Simple_user;
        this.Email = Email;
    }
        public Postulation(int id_pos, String date, String Email) {
        this.id_pos = id_pos;
        this.date = date;
        this.Email = Email;
    }

    public int getId_pos() {
        return id_pos;
    }

    public String getDate() {
        return date;
    }

    public String getSimple_user() {
        return Simple_user;
    }

    public String getEmail() {
        return Email;
    }

    public void setId_pos(int id_pos) {
        this.id_pos = id_pos;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSimple_user(String Simple_user) {
        this.Simple_user = Simple_user;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    @Override
    public String toString() {
        return "Postulation{" + "id_pos=" + id_pos + ", date=" + date + ", Simple_user=" + Simple_user + ", Email=" + Email + '}';
    }

   

  
}