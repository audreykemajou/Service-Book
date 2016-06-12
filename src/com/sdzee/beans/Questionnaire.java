package com.sdzee.beans;

public class Questionnaire {
	/* Propriétés du bean */
    private String sujet;
    private String id;
    private int statut;
    private String idAdmin;

    
    public void setSujet( String sujet ) {
        this.sujet = sujet;
    }

    public String getSujet() {
        return sujet;
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
    
    public void setIdAdmin( String idAdmin ) {
        this.idAdmin = idAdmin;
    }
    
    public String getIdAdmin() {
        return idAdmin;
    }

}
