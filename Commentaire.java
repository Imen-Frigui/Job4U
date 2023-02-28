/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.sql.Date;

/**
 *
 * @author wissal
 */
public class Commentaire {
    
    private int id;
    private String desc;
    private Date date;
    private Poste poste;
    private User user;

    public Commentaire(int id, String desc, Date date, Poste poste, User user) {
        this.id = id;
        this.desc = desc;
        this.date = date;
        this.poste = poste;
        this.user = user;
    }

    public Commentaire(String desc, Date date, Poste poste, User user) {
        this.desc = desc;
        this.date = date;
        this.poste = poste;
        this.user = user;
    }

    public Commentaire() {
        
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Date getDate() {
        return date;
    }

    public Poste getPoste() {
        return poste;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
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
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", desc=" + desc + ", date=" + date + ", poste=" + poste + ", user=" + user + '}';
    }
    
    
    
}
