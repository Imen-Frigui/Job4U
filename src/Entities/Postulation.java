/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Postulation {
    private int id_pos;
    private Date date;
    private String Simple_user;
    private String Email;

    public Postulation(int id_pos, Date date, String Simple_user, String Email) {
        this.id_pos = id_pos;
        this.date = date;
        this.Simple_user = Simple_user;
        this.Email = Email;
    }

    public Postulation() {
    }

    public Postulation(int id_pos) {
        this.id_pos = id_pos;
    }

    public int getId_pos() {
        return id_pos;
    }

    public Date getDate() {
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

    public void setDate(Date date) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Postulation other = (Postulation) obj;
        if (this.id_pos != other.id_pos) {
            return false;
        }
        if (!Objects.equals(this.Simple_user, other.Simple_user)) {
            return false;
        }
        if (!Objects.equals(this.Email, other.Email)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

    
    
    
}

    