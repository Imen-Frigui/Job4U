/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package job4u.entities;

 public class Reponse {

 
    private int id_reponse;
    private int id_reclamation;
    private String message_rep;
    private String date_rep;
    private String statut;
    public Reponse(int id_reclamation, String message_rep, String date_rep) {
        this.id_reclamation = id_reclamation;
        this.message_rep = message_rep;
        this.date_rep = date_rep;
    }
    public Reponse(int id_reclamation, String message_rep, String date_rep, String statut) {
		super();
		this.id_reclamation = id_reclamation;
		this.message_rep = message_rep;
		this.date_rep = date_rep;
		this.statut = statut;
	}

	public Reponse(int id_reponse, int id_reclamation, String message_rep, String date_rep, String statut) {
		super();
		this.id_reponse = id_reponse;
		this.id_reclamation = id_reclamation;
		this.message_rep = message_rep;
		this.date_rep = date_rep;
		this.statut = statut;
	}

	@Override
	public String toString() {
		return "Reponse [id_reponse=" + id_reponse + ", id_reclamation=" + id_reclamation + ", message_rep="
				+ message_rep + ", date_rep=" + date_rep + ", statut=" + statut + "]";
	}

    public Reponse(String message_rep, String date_rep) {
        this.message_rep = message_rep;
        this.date_rep = date_rep;
    }

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Reponse(int id_reponse, int id_reclamation, String message_rep, String date_rep) {
        this.id_reponse = id_reponse;
        this.id_reclamation = id_reclamation;
        this.message_rep = message_rep;
        this.date_rep = date_rep;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getMessage_rep() {
        return message_rep;
    }

    public void setMessage_rep(String message_rep) {
        this.message_rep = message_rep;
    }

    public String getDate_rep() {
        return date_rep;
    }

    public void setDate_rep(String date_rep) {
        this.date_rep = date_rep;
    }
}

