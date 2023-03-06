/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author user
 */
public class User {
    
    private int id;
    private String nom;
    private String prenom; 
    private String password;
    private String mail;
    private String role;

    public User() {
    }

    public User(int id, String nom, String prenom,  String mail,String password, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        
        this.role = role;
    }
       public User( String nom, String prenom, String mail, String password, String Role) {
 
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        this.role=Role;
  
    }
        public User(int id, String nom, String prenom, String mail) {
           this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
     
  
    }
    
      
    
     public User(String mail,String password ) {
        this.password = password;
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public String isNom() {
        return nom;
    }

    public String isPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", mail=" + mail + ", role=" + role + '}';
    }
    public User(String nom, String prenom, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    
    public User(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    /**
     * @return the type
     */
    public String getPswd() {
        return password;
    }

    /**
     * @param pswd the type to set
     */
    public void setPswd(String pswd) {
        this.password = pswd;
    }
    
}