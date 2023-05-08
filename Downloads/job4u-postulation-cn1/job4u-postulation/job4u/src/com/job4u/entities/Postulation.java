package com.job4u.entities;

import java.util.Date;

public class Postulation {

    private int id;
    private User user;
    private String adresse;
    private String email;
    private Date date;

    public Postulation() {
    }

    public Postulation(int id, User user, String adresse, String email, Date date) {
        this.id = id;
        this.user = user;
        this.adresse = adresse;
        this.email = email;
        this.date = date;
    }

    public Postulation(User user, String adresse, String email, Date date) {
        this.user = user;
        this.adresse = adresse;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}