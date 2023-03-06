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
public class offre {
     private int id;
    private String nom;
    private String desc;
    private String Duree;
    private int proj_id;

    /**
     * @return the id
     */
    
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public offre(String nom, String desc, String Duree, int proj_id) {
        this.nom = nom;
        this.desc = desc;
        this.Duree = Duree;
        this.proj_id = proj_id;
    }

    public offre(int id, String nom, String desc, String Duree, int proj_id) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
        this.Duree = Duree;
        this.proj_id = proj_id;
    }
    
    public int getProj_id() {
        return proj_id;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return the date_debut
     */
    public String getDuree() {
        return Duree;
    }

    /**
     * @param date_debut the date_debut to set
     */
    public void setDate_debut(String Duree) {
        this.Duree = Duree;
    }

    /**
     * @return the date_fin
     */
    

    /**
     * @param date_fin the date_fin to set
     */

    public offre(int id, String nom, String desc,String Duree) {
        this.id = id;
        this.nom = nom;
        this.desc = desc;
        this.Duree = Duree;
    }

    public offre(String nom, String desc, String Duree){
     this.nom = nom;
        this.desc = desc;
        this.Duree = Duree;   
    }

    public offre() {
    }


    @Override
    public String toString() {
        return "offre{" + "id=" + id + ", nom=" + nom + ", desc=" + desc + " Duree=" + Duree + '}';
    }
    
    
    
}
