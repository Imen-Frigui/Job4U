/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.entities;

 
public class Reclamation {
    private int id_reclamation;
    private String message;
    private String type;
    private String statut;
    private int id_user;
    private String nom;
    
    public Reclamation(int id_reclamation, String message, String type, String statut, int id_user, String nom) {
		super();
		this.id_reclamation = id_reclamation;
		this.message = message;
		this.type = type;
		this.statut = statut;
		this.id_user = id_user;
		this.nom = nom;
	}

    public String getNom() {
        return nom;
    }

	public Reclamation(String message) {
		super();
		this.message = message;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

    public Reclamation(int id_reclamation, String message, String type, String statut, int id_user) {
        this.id_reclamation = id_reclamation;
        this.message = message;
        this.type = type;
        this.statut = statut;
        this.id_user = id_user;
    }

    public Reclamation(String message, String type, String statut, int id_user) {
         this.message = message;
        this.type = type;
        this.statut = statut;
        this.id_user = id_user;
     }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

	@Override
	public String toString() {
		return "Reclamation [id_reclamation=" + id_reclamation + ", message=" + message + ", type=" + type + ", statut="
				+ statut + ", id_user=" + id_user + ", nom=" + nom + "]";
	}

     
    
}

