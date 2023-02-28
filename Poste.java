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
public class Poste {
    
    private int id;
    private String titre;
    private String desc;
    private String img;
    private Domaine domaine;
    private Date date;
    private User user;

    public Poste() {
    }

    public Poste(int id, String titre, String desc, String img, Domaine domaine, Date date, User user) {
        this.id = id;
        this.titre = titre;
        this.desc = desc;
        this.img = img;
        this.domaine = domaine;
        this.date = date;
        this.user = user;
    }

    public Poste(String titre, String desc, String img, Domaine domaine, Date date, User user) {
        this.titre = titre;
        this.desc = desc;
        this.img = img;
        this.domaine = domaine;
        this.date = date;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDesc() {
        return desc;
    }

    public String getImg() {
        return img;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public Date getDate() {
        return date;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Poste other = (Poste) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Poste{" + "id=" + id + ", titre=" + titre + ", desc=" + desc + ", img=" + img + ", domaine=" + domaine + ", date=" + date + ", user=" + user + '}';
    }
    
    
    
}
