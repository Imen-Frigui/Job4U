/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Imen Frigui
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String password;

    public User(String nom, String prenom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    public User(int id, String nom, String prenom, String password) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }
    
    public User(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User() {
    }
    
    //getters / setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    //toString
    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + '}';
    }

    /**
     * @return the type
     */
    public String getPswd() {
        return password;
    }

    /**
     * @param pswd the type to set
     */
    public void setPswd(String pswd) {
        this.password = pswd;
    }
    
}
