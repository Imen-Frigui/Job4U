/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Ahmed
 */
public class Project {
    private int id;
    private String nom;
    private String societe;

    public Project(int id, String nom, String societe) {
        this.id = id;
        this.nom = nom;
        this.societe = societe;
    }

    public Project(String nom, String societe) {
        this.nom = nom;
        this.societe = societe;
    }

    public Project() {
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

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", nom=" + nom + ", societe=" + societe + '}';
    }

}