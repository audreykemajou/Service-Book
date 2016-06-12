package com.sdzee.beans;

import java.util.HashMap;

import org.joda.time.DateTime;

public class Parcours {
	/* Propriétés du bean */
	private String id; //
    private int score;
    private DateTime debut;//
    private DateTime fin;//
    private int duree;//
    private HashMap <String, String> question_reponse = new HashMap<String, String>();
    private String idQuestionnaire;//
    private String idUtilisateur;//
    
    
    public void setScore( int score ) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
    
    public void setReponse( HashMap <String, String> question_reponse ) {
        this.question_reponse = question_reponse;
    }

    public HashMap <String, String> getReponse() {
        return question_reponse;
    }
    
    public void setId( String id ) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public void setIdUtilisateur( String idUtilisateur ) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getIdUtilisateur() {
        return idUtilisateur;
    }
    
    public void setIdQuestionnaire( String idQuestionnaire ) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setDebut( DateTime debut ) {
        this.debut = debut;
    }
    
    public DateTime getDebut() {
        return debut;
    }
    
    public void setFin( DateTime fin ) {
        this.fin = fin;
    }
    
    public DateTime getFin() {
        return fin;
    }
    
    public void setDuree( int duree ) {
        this.duree = duree;
    }
    
    public int getDuree() {
        return duree;
    }

}
