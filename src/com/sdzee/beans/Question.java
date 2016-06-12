package com.sdzee.beans;

import java.util.ArrayList;

public class Question {
	/* Propriétés du bean */
    private String libelle;
    private String id;
    private String idQuestionnaire;
    private ArrayList<Reponse> reponses = new ArrayList<Reponse>();
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
    
    public void setReponse( ArrayList<Reponse> reponses ) {
        this.reponses = reponses;
    }

    public ArrayList<Reponse> getReponse() {
        return reponses;
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
    
    public void setIdQuestionnaire( String idQuestionnaire ) {
        this.idQuestionnaire = idQuestionnaire;
    }
    
    public String getIdQuestionnaire() {
        return idQuestionnaire;
    }

}
