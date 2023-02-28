/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author wissal
 */
public class Domaine {
    private int id;
    private String nom;

    public Domaine(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Domaine(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.id;
        hash = 23 * hash + Objects.hashCode(this.nom);
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
        final Domaine other = (Domaine) obj;
        return true;
    }

    @Override
    public String toString() {
        return "Domaine{" + "id=" + id + ", nom=" + nom + '}';
    }


    
   
    
    
    
    
}
