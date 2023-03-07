/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Ahmed
 */
public class DataSingelton {
    private static final DataSingelton instance = new DataSingelton();
    private int id;
    private Date date_debut;
    private String nom;
    private String descrip;
    private String Duree;
    
    public static DataSingelton getInstance(){
        return instance;
    }

    @Override
    public String toString() {
        return "DataSingelton{" + "id=" + id + ", nom=" + nom + ", descrip=" + descrip + ", Duree=" + Duree + '}';
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getDuree() {
        return Duree;
    }

    public void setDuree(String Duree) {
        this.Duree = Duree;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

  
    }
    
    
    

