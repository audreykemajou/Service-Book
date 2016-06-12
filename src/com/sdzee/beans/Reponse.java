package com.sdzee.beans;

public class Reponse {
	/* Propriétés du bean */
    private String libelle;
    private String idQuestion;
    private int bonne;
    private String id;
    private int statut;
    private String ordre;
    
    
    public void setLibelle( String libelle ) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }
    
    public void setOrdre( String ordre ) {
        this.ordre = ordre;
    }

    public String getOrdre() {
        return ordre;
    }


    public void setBonne( int bonne ) {
        this.bonne = bonne;
    }
    
    public int getBonne() {
        return bonne;
    }
    
    public void setStatut( int statut ) {
        this.statut = statut;
    }
    
    public int getStatut() {
        return statut;
    }
    
    public void setId( String id ) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setIdQuestion( String idQuestion ) {
        this.idQuestion = idQuestion;
    }
    
    public String getIdQuestion() {
        return idQuestion;
    }

}
