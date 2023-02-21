/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class InformationsSupplementaires {
    int id;
  
    String nom;
    String prenom;
    String tell;
      public String lien_icon;
  

    public InformationsSupplementaires(int id, String nom, String prenom, String tell) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.tell = tell;
        
    }
    
    public InformationsSupplementaires(int id, String nom, String prenom, String tell ,String lien_icon) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.tell = tell;
        this.lien_icon=lien_icon;
        
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
        final InformationsSupplementaires other = (InformationsSupplementaires) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.lien_icon, other.lien_icon)) {
            return false;
        }
        return true;
    }
    

  

    public InformationsSupplementaires() {
    }

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

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }
    
    public String getLien_icon() {
        return lien_icon;
    }

    public void setLien_icon(String lien_icon) {
        this.lien_icon = lien_icon;
    }


    
    
    
}

