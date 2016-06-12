package com.sdzee.beans;

import java.util.Date;

public class Utilisateur {
	/* Propriétés du bean */
	private String id;
    private String nom;
    private String prenom;
    private String societe;
    private String telephone;
    private Date date_creation;
    private String email;
    private String motDePasse;
    private int statut;
    private int admin;
    
    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    
    public void setNom( String nom ) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setSociete( String societe ) {
        this.societe = societe;
    }

    public String getSociete() {
        return societe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone( String telephone ) {
        this.telephone = telephone;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    
    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
    
    public void setStatut( int statut ) {
        this.statut = statut;
    }
    
    public int getStatut() {
        return statut;
    }
    
    public void setAdmin( int admin ) {
        this.admin = admin;
    }
    
    public int getAdmin() {
        return admin;
    }
    
    public void setDateCreation( Date date_creation ) {
        this.date_creation = date_creation;
    }
    
    public Date getDateCreation() {
        return date_creation;
    }

}
