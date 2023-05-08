package com.job4u.entities;

public class Societe {

    private int id;
    private String adresse;
    private String email;
    private String tel;
    private String domaine;
    private String image;

    public Societe() {
    }

    public Societe(int id, String adresse, String email, String tel, String domaine, String image) {
        this.id = id;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.domaine = domaine;
        this.image = image;
    }

    public Societe(String adresse, String email, String tel, String domaine, String image) {
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.domaine = domaine;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}