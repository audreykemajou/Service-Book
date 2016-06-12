package com.sdzee.bdd;

import java.util.ArrayList;
import java.util.Date;

import com.sdzee.beans.Parcours;
import com.sdzee.beans.Question;
import com.sdzee.beans.Questionnaire;
import com.sdzee.beans.Reponse;
import com.sdzee.beans.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC {
    /* La liste qui contiendra tous les résultats de nos essais */
    private ArrayList<String> messages = new ArrayList<String>();
    
    public boolean validerCompte( String email, String mdp) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
		boolean trouveCompte = false;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM utilisateur WHERE email= '" + email + "'  AND mdp= '" + mdp + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	        
	        
	        if ( resultat.next()) {
	        	trouveCompte = true;
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return trouveCompte;
	}
    
    public Utilisateur rechercherCompte( String email) {
    	Utilisateur utilisateur = new Utilisateur();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM utilisateur WHERE email= '" + email + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	        	String idUtilisateur = resultats.getString( "id" );
	            String prenomUtilisateur = resultats.getString( "prenom" );
	            String societeUtilisateur = resultats.getString( "societe" );
	            String emailUtilisateur = resultats.getString( "email" );
	            //String motDePasseUtilisateur = resultats.getString( "mdp" );
	            String nomUtilisateur = resultats.getString( "nom" );
	            String telUtilisateur = resultats.getString( "telephone" );
	            int admin = resultats.getInt( "admin" );
	            int statut = resultats.getInt( "statut" );
	            Date creation = resultats.getDate( "date_creation" );
	            /* Formatage des données pour affichage dans la JSP finale. */
	            
	            utilisateur.setId(idUtilisateur);
	            utilisateur.setAdmin(admin);
	            utilisateur.setEmail(emailUtilisateur);
	            utilisateur.setNom(nomUtilisateur);
	            utilisateur.setPrenom(prenomUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setStatut(statut);
	            utilisateur.setTelephone(telUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setDateCreation(creation);
	            
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return utilisateur;
	}
    
    public Questionnaire rechercherQuestionnaire( String sujet) {
    	Questionnaire questionnaire = new Questionnaire();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM questionnaire WHERE sujet= '" + sujet + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	        	String id = resultats.getString( "id" );
	            String idAdmin = resultats.getString( "admin" );
	            int statut = resultats.getInt( "statut" );
	            
	            questionnaire.setId(id);
	            questionnaire.setIdAdmin(idAdmin);
	            questionnaire.setStatut(statut);
	            questionnaire.setSujet(sujet);
	            
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questionnaire;
	}
    
    public Utilisateur rechercherCompteId( String id) {
    	Utilisateur utilisateur = new Utilisateur();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM utilisateur WHERE id= '" + id + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	        	String idUtilisateur = resultats.getString( "id" );
	            String prenomUtilisateur = resultats.getString( "prenom" );
	            String societeUtilisateur = resultats.getString( "societe" );
	            String emailUtilisateur = resultats.getString( "email" );
	            String motDePasseUtilisateur = resultats.getString( "mdp" );
	            String nomUtilisateur = resultats.getString( "nom" );
	            String telUtilisateur = resultats.getString( "telephone" );
	            int admin = resultats.getInt( "admin" );
	            int statut = resultats.getInt( "statut" );
	            Date creation = resultats.getDate( "date_creation" );
	            /* Formatage des données pour affichage dans la JSP finale. */
	            
	            utilisateur.setId(idUtilisateur);
	            utilisateur.setAdmin(admin);
	            utilisateur.setEmail(emailUtilisateur);
	            utilisateur.setNom(nomUtilisateur);
	            utilisateur.setPrenom(prenomUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setStatut(statut);
	            utilisateur.setTelephone(telUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setDateCreation(creation);
	            utilisateur.setMotDePasse(motDePasseUtilisateur);
	            
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return utilisateur;
	}
    
    public Questionnaire rechercherQuestionnaireId( String id) {
    	Questionnaire questionnaire = new Questionnaire();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM questionnaire WHERE id= '" + id + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	            String sujet = resultats.getString( "sujet" );
	            int statut = resultats.getInt( "statut" );
	            String idCreateur = resultats.getString( "admin" );
	            
	            questionnaire.setId(id);
	            questionnaire.setIdAdmin(idCreateur);
	            questionnaire.setSujet(sujet);
	            questionnaire.setStatut(statut);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questionnaire;
	}
    
    public ArrayList<Parcours> rechercherParcoursId( String idUser) {
    	ArrayList<Parcours> parcours_utilisateur = new ArrayList<Parcours>();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM parcours WHERE utilisateur= '" + idUser + "';";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        while ( resultats.next()) {
	            String id = resultats.getString( "id" );
	            int score = resultats.getInt( "score" );
	            int duree = resultats.getInt( "duree" );
	            String idUtilisateur = idUser;
	            String idQuestionnaire = resultats.getString( "questionnaire" );
	            
	            Parcours parcours = new Parcours();
	            
	            parcours.setId(id);
	            parcours.setScore(score);
	            parcours.setDuree(duree);
	            parcours.setIdUtilisateur(idUtilisateur);
	            parcours.setIdQuestionnaire(idQuestionnaire);
	            
	            parcours_utilisateur.add(parcours);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return parcours_utilisateur;
	}
    
    public Question rechercherQuestionId( String id) {
    	Question question = new Question();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM question WHERE id= '" + id + "' ORDER BY ordre;";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	            String questionnaire = resultats.getString( "questionnaire" );
	            int statut = resultats.getInt( "statut" );
	            String libelle = resultats.getString( "libelle" );
	            String ordre = resultats.getString("ordre");
	            
	            question.setId(id);
	            question.setOrdre(ordre);
	            question.setIdQuestionnaire(questionnaire);
	            question.setLibelle(libelle);
	            question.setStatut(statut);
	            ArrayList<Reponse> reponses = afficherReponses(id);
	            question.setReponse(reponses);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return question;
	}
    
    public Reponse rechercherReponseId( String id) {
    	Reponse reponse = new Reponse();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM reponse WHERE id= '" + id + "' ORDER BY ordre;";
	        //System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	            String question = resultats.getString( "question" );
	            int statut = resultats.getInt( "statut" );
	            String libelle = resultats.getString( "libelle" );
	            int bonne = resultats.getInt( "bonne" );
	            String ordre = resultats.getString( "ordre" );
	            
	            reponse.setId(id);
	            reponse.setOrdre(ordre);
	            reponse.setIdQuestion(question);
	            reponse.setLibelle(libelle);
	            reponse.setStatut(statut);
	            reponse.setBonne(bonne);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return reponse;
	}
    
    public Reponse rechercherBonneReponse( String libelle) {
    	Reponse reponse = new Reponse();
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire?characterEncoding=iso-8859-1","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM reponse WHERE libelle= '" + libelle + "';";
	        System.out.println(query);
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	        
	        
	        if ( resultats.next()) {
	            int bonne = resultats.getInt( "bonne" );
	            reponse.setBonne(bonne);
	        }
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return reponse;
	}
    
    public void creerCompte( String email, String nom, String prenom, String mdp, String societe, String telephone, String admin, String statut) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "INSERT INTO utilisateur (email, nom, prenom, societe, telephone, mdp, date_creation, statut, admin) "
            + "VALUES ('" + email + "','" + nom + "','" + prenom + "','" + societe + "','" + telephone + "','" + mdp + "', NOW(), '" + statut + "','" + admin + "');";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void creerQuestionnaire( String sujet, String idCreateur) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "INSERT INTO questionnaire (sujet, statut, admin) "
            + "VALUES ('" + sujet + "','0','" + idCreateur + "');";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void creerReponse( String libelle, String statut, String idQuestion, String bonne, String ordre) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "INSERT INTO reponse (statut, libelle, question, bonne, ordre) "
            + "VALUES ('" + statut + "','" + libelle + "','" + idQuestion + "','" + bonne + "','" + ordre + "');";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void creerQuestion( String libelle, String idQuestionnaire, String ordre) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "INSERT INTO question (statut, libelle, questionnaire, ordre) "
            + "VALUES ('0','" + libelle + "','" + idQuestionnaire + "','" + ordre + "');";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void creerParcours(int score, int duree, String idQuestionnaire, String idUtilisateur) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "INSERT INTO parcours (statut, score, duree, utilisateur, questionnaire) "
            + "VALUES ('1','" + score + "','" + duree + "','" + idUtilisateur + "','" + idQuestionnaire + "');";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
	        
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierCompte( String id, String email, String nom, String prenom, String mdp, String societe, String telephone, String admin, String statut) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE utilisateur "
            + " SET email = '" + email + "', nom = '" + nom + "', prenom = '" + prenom + "', societe = '" + societe + "', telephone = '" + telephone + "', mdp = '" + mdp + "', statut = '" + statut + "', admin = '" + admin + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierQuestionnaire( String id, String sujet, String idCreateur) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE questionnaire "
            + " SET sujet = '" + sujet + "', admin = '" + idCreateur + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierQuestionnaireStatut( String id, String statut) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE questionnaire "
            + " SET statut = '" + statut + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierQuestion( String id, String idQuestionnaire, String libelle, String ordre) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE question "
            + " SET libelle = '" + libelle + "', questionnaire = '" + idQuestionnaire + "', ordre = '" + ordre + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierQuestionStatut( String statut, String id) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE question "
            + " SET statut = '" + statut + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void modifierReponse( String id, String idQuestion, String libelle, String statut, String bonne, String ordre) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "UPDATE reponse "
            + " SET libelle = '" + libelle + "', statut = '" + statut + "', question = '" + idQuestion + "', bonne = '" + bonne + "', ordre = '" + ordre + "'"
	        + " WHERE id = '" + id + "';";
            System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
	        connexion.commit();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void supprimerCompte(String id) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "DELETE FROM utilisateur WHERE id= '" + id + "';";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void supprimerQuestion(String id) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "DELETE FROM question WHERE id= '" + id + "';";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void supprimerReponse(String id) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "DELETE FROM reponse WHERE id= '" + id + "';";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
    public void supprimerQuestionnaire(String id) {
    	try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		      
		}
	
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try{
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "DELETE FROM questionnaire WHERE id= '" + id + "';";
	        System.out.println(query);
	        
	        preparedStatement = connexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	
	        /* Exécution d'une requête de lecture */
	        preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
		  
		    if ( preparedStatement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		        	preparedStatement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
	}
    
	public Utilisateur connexion(String email, String mdp ) {
		/* Chargement du driver JDBC pour MySQL */
		Utilisateur utilisateur = new Utilisateur();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultats = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM utilisateur WHERE email= '" + email + "'  AND mdp= '" + mdp + "';";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultats = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultats.next() ) {
	            String idUtilisateur = resultats.getString( "id" );
	            String prenomUtilisateur = resultats.getString( "prenom" );
	            String societeUtilisateur = resultats.getString( "societe" );
	            String emailUtilisateur = resultats.getString( "email" );
	            String motDePasseUtilisateur = resultats.getString( "mdp" );
	            String nomUtilisateur = resultats.getString( "nom" );
	            String telUtilisateur = resultats.getString( "telephone" );
	            int admin = resultats.getInt( "admin" );
	            int statut = resultats.getInt( "statut" );
	            Date creation = resultats.getDate( "date_creation" );
	            /* Formatage des données pour affichage dans la JSP finale. */
	            
	            utilisateur.setId(idUtilisateur);
	            utilisateur.setAdmin(admin);
	            utilisateur.setEmail(emailUtilisateur);
	            utilisateur.setMotDePasse(motDePasseUtilisateur);
	            utilisateur.setNom(nomUtilisateur);
	            utilisateur.setPrenom(prenomUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setStatut(statut);
	            utilisateur.setTelephone(telUtilisateur);
	            utilisateur.setDateCreation(creation);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultats != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultats.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return utilisateur;
	}
	
	public ArrayList<Utilisateur> afficherUtilisateur( ) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM utilisateur";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String idUtilisateur = resultat.getString( "id" );
	            String prenomUtilisateur = resultat.getString( "prenom" );
	            String societeUtilisateur = resultat.getString( "societe" );
	            String emailUtilisateur = resultat.getString( "email" );
	            String motDePasseUtilisateur = resultat.getString( "mdp" );
	            String nomUtilisateur = resultat.getString( "nom" );
	            String telUtilisateur = resultat.getString( "telephone" );
	            int admin = resultat.getInt( "admin" );
	            int statut = resultat.getInt( "statut" );
	            Date creation = resultat.getDate( "date_creation" );
	            
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Utilisateur utilisateur = new Utilisateur();
	            
	            utilisateur.setId(idUtilisateur);
	            utilisateur.setAdmin(admin);
	            utilisateur.setEmail(emailUtilisateur);
	            utilisateur.setMotDePasse(motDePasseUtilisateur);
	            utilisateur.setNom(nomUtilisateur);
	            utilisateur.setPrenom(prenomUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setStatut(statut);
	            utilisateur.setTelephone(telUtilisateur);
	            utilisateur.setSociete(societeUtilisateur);
	            utilisateur.setDateCreation(creation);
	            utilisateurs.add(utilisateur);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return utilisateurs;
	}
	
	public ArrayList<Questionnaire> afficherQuestionnaires( ) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM questionnaire";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String sujet = resultat.getString( "sujet" );
	            String idAdmin = resultat.getString( "admin" );
	            int statut = resultat.getInt( "statut" );
	            
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Questionnaire questionnaire = new Questionnaire();
	            
	            questionnaire.setId(id);
	            questionnaire.setIdAdmin(idAdmin);
	            questionnaire.setStatut(statut);
	            questionnaire.setSujet(sujet);
	            
	            questionnaires.add(questionnaire);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questionnaires;
	}
	
	public ArrayList<Questionnaire> afficherQuestionnairesActifs( ) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM questionnaire WHERE statut = '1' ";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String sujet = resultat.getString( "sujet" );
	            String idAdmin = resultat.getString( "admin" );
	            int statut = resultat.getInt( "statut" );
	            
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Questionnaire questionnaire = new Questionnaire();
	            
	            questionnaire.setId(id);
	            questionnaire.setIdAdmin(idAdmin);
	            questionnaire.setStatut(statut);
	            questionnaire.setSujet(sujet);
	            
	            questionnaires.add(questionnaire);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questionnaires;
	}
	
	public ArrayList<Question> afficherQuestions(String idQuestionnaire) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM question WHERE questionnaire = '" + idQuestionnaire + "' ORDER BY ordre;";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String libelle = resultat.getString( "libelle" );
	            int statut = resultat.getInt( "statut" );
	            String ordre = resultat.getString( "ordre" );
	            ArrayList<Reponse> reponses = afficherReponses(id);
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Question question = new Question();
	            
	            question.setId(id);
	            question.setOrdre(ordre);
	            question.setIdQuestionnaire(idQuestionnaire);
	            question.setLibelle(libelle);
	            question.setStatut(statut);
	            question.setReponse(reponses);
	            
	            questions.add(question);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questions;
	}
	
	public ArrayList<Question> afficherQuestionsP(String idQuestionnaire) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM question WHERE questionnaire = '" + idQuestionnaire + "' ORDER BY ordre;";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String libelle = resultat.getString( "libelle" );
	            int statut = resultat.getInt( "statut" );
	            String ordre = resultat.getString( "ordre" );
	            ArrayList<Reponse> reponses = afficherBonneReponse(id);
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Question question = new Question();
	            
	            question.setId(id);
	            question.setIdQuestionnaire(idQuestionnaire);
	            question.setLibelle(libelle);
	            question.setStatut(statut);
	            question.setOrdre(ordre);
	            question.setReponse(reponses);
	            
	            questions.add(question);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return questions;
	}
	
	public ArrayList<Reponse> afficherReponses(String idQuestion) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Reponse> reponses = new ArrayList<Reponse>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM reponse WHERE question = '" + idQuestion + "' ORDER BY ordre;";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String libelle = resultat.getString( "libelle" );
	            int bonne = resultat.getInt("bonne");
	            int statut = resultat.getInt( "statut" );
	            String ordre = resultat.getString( "ordre" );
	            
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Reponse reponse = new Reponse();
	            
	            reponse.setId(id);
	            reponse.setIdQuestion(idQuestion);
	            reponse.setLibelle(libelle);
	            reponse.setStatut(statut);
	            reponse.setBonne(bonne);
	            reponse.setOrdre(ordre);
	            
	            reponses.add(reponse);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return reponses;
	}
	
	public ArrayList<Reponse> afficherBonneReponse(String idQuestion) {
		/* Chargement du driver JDBC pour MySQL */
		ArrayList<Reponse> reponses = new ArrayList<Reponse>();
		try {
		    Class.forName( "com.mysql.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		}
	
		Connection connexion = null;
		Statement statement = null;
		ResultSet resultat = null;
	
		try{
			
			
			connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evalstagiaire","root","SR03Eval");
	
	        /* Création de l'objet gérant les requêtes */
	        String query = "SELECT * FROM reponse WHERE question = '" + idQuestion + "' AND bonne= '1';";
	        PreparedStatement preparedStatement = connexion.prepareStatement(query);
	
	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	 
	        /* Récupération des données du résultat de la requête de lecture */
	        while ( resultat.next() ) {
	            String id = resultat.getString( "id" );
	            String libelle = resultat.getString( "libelle" );
	            int bonne = resultat.getInt("bonne");
	            int statut = resultat.getInt( "statut" );
	            String ordre = resultat.getString( "ordre" );
	            
	            
	            /* Formatage des données pour affichage dans la JSP finale. */
	            Reponse reponse = new Reponse();
	            
	            reponse.setId(id);
	            reponse.setIdQuestion(idQuestion);
	            reponse.setLibelle(libelle);
	            reponse.setStatut(statut);
	            reponse.setBonne(bonne);
	            reponse.setOrdre(ordre);
	            
	            reponses.add(reponse);
	            
	        }
			
		}catch(SQLException e){
			messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
		} finally {
			messages.add( "Fermeture de l'objet ResultSet." );
		    if ( resultat != null ) {
		        try {
		            /* On commence par fermer le ResultSet */
		            resultat.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Statement." );
		    if ( statement != null ) {
		        try {
		            /* Puis on ferme le Statement */
		            statement.close();
		        } catch ( SQLException ignore ) {
		        }
		    }
		    messages.add( "Fermeture de l'objet Connection." );
		    if ( connexion != null ) {
		        try {
		        	/* Et enfin on ferme la connexion */
			        connexion.close();
			    } catch ( SQLException ignore ) {
			    }
			}
		}
		return reponses;
	}
	
}



