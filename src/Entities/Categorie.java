/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author mariem 
 */
public class Categorie {
    private int id_categorie;
    private String nom_categorie;
    private String description_categorie;
    
    public Categorie(int id_categorie, String nom_categorie, String description_categorie) {
        this.id_categorie = id_categorie;
        this.nom_categorie = nom_categorie;
        this.description_categorie = description_categorie;
    }
public Categorie(){
    }
    public int getid_categorie() {
        return id_categorie;
    }

    public String getnom_categorie() {
        return nom_categorie;
    }

    public String getdescription_categorie() {
        return description_categorie;
    }

    public void setid_categorie(int  id_categorie) {
        this.id_categorie = id_categorie;
    }

    public void setnom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }

    public void setdescription_categorie(String description_categorie) {
        this.description_categorie = description_categorie;
    }
    
}
