/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author user
 */
public class Societe {
    private String nom;
    private String adresse;
    private String email;
     private String tel;
     private String domaine;
     private String sos_image;

    public Societe(String nom, String adresse, String email, String tel, String domaine) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.domaine = domaine;
    }

    public String getSos_image() {
        return sos_image;
    }

    public void setSos_image(String sos_image) {
        this.sos_image = sos_image;
    }

    public Societe(String nom, String adresse, String email, String tel, String domaine, String sos_image) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
        this.tel = tel;
        this.domaine = domaine;
        this.sos_image = sos_image;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "Societe{" + "nom=" + nom + ", adresse=" + adresse + ", email=" + email + ", tel=" + tel + ", domaine=" + domaine + '}';
    }
     

}