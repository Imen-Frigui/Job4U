/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author mariem 
 */
public class Reclamation {
    private int Id_reclamation;
    private String Titre_reclamation ;
    private String description_reclamation;
    private String  date_reclamation;
    
    public Reclamation (int  Id_reclamation, String Titre_reclamation, String description_reclamation,String date_reclamation) {
        this.Id_reclamation = Id_reclamation;
        this.Titre_reclamation = Titre_reclamation;
        this.description_reclamation = description_reclamation;
        this.date_reclamation  = date_reclamation;

    }

       public Reclamation ( String Titre_reclamation, String description_reclamation,String date_reclamation) {
        this.Titre_reclamation = Titre_reclamation;
        this.description_reclamation = description_reclamation;
        this.date_reclamation  = date_reclamation;

    }
    public Reclamation(){
}
    public int getId_reclamation() {
        return  Id_reclamation;
    }

    public String getTitre_reclamation() {
        return Titre_reclamation;
    }

    public String getdescription_reclamation() {
        return description_reclamation;
    }
    public String getdate_reclamation() {
        return date_reclamation;
    }
    
    public void setId_reclamation(int Id_reclamation) {
        this.Id_reclamation= Id_reclamation;
    }

    public void setTitre_reclamation(String Titre_reclamation) {
        this.Titre_reclamation = Titre_reclamation;
    }

    public void setdescription_reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }
    public void setdate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }
    
    @Override
    public String toString() {
        return "Reclamation{" + "Id_reclamation=" + Id_reclamation + ", Titre_reclamation=" + Titre_reclamation + ", description_reclamation=" + description_reclamation + ", date_reclamation=" + date_reclamation +'}';
    }

  
}