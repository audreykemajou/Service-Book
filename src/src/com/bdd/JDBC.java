package com.bdd;
import com.beans.Annonce;
import com.beans.Categorie;
import com.beans.Adresse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBC {
	

	/**CONNEXION A LA BASE DE DONNEES**/
	public static Connection connectDB(){
		try{
			Class.forName( "com.mysql.jdbc.Driver" );
			System.out.println("Driver ok!");
			String url = "jdbc:mysql://localhost:3306/annuaire";
			String  userName = "root";
			String password = "SR03Eval";
			Connection connexion = DriverManager.getConnection(url,userName,password);
			System.out.println("Connexion établie");
			
			return connexion;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}	
	/**CATEGORIE**/
	public static void creerCategorie(String titre){
		try{
			Connection connexion = connectDB();
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("INSERT INTO categorie (titre,annuaire) VALUES ('"+ titre +"',1)");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void modifierCategorie(String titre,String id){
		try{
			Connection connexion = connectDB();
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("UPDATE categorie SET  titre ='"+titre+"' WHERE id ='"+id+"'");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void supprimerCategorie(String id){
		try{
			Connection connexion = connectDB();
			ArrayList<Annonce> annonces = rechercherAnnonceIdCategorieArray(id);
			for (Annonce annonce : annonces) {
				String idAnnonce = annonce.getId();
				supprimerAnnonce(idAnnonce);
			}
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("DELETE FROM categorie WHERE id ='"+id+"'");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**ADRESSE**/
	public static void creerAdresse(String rue, String ville, String code_postal, String annonce){
		try{
			Connection connexion = connectDB();
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("INSERT INTO adresse (rue,ville,code_postal,annonce) VALUES ('"+ rue +"','"+ ville +"','"+ code_postal +"','"+ annonce +"')");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void modifierAdresse(String id,String rue, String ville, String code_postal, String annonce){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("UPDATE adresse SET  rue ='"+rue+"', ville ='"+ville+"' , code_postal ='"+code_postal+"' , annonce ='"+annonce+"' WHERE id ='"+id+"'");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void supprimerAdresse(String id){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("DELETE FROM adresse WHERE id ='"+id+"'");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	/**ANNONCE**/
	public static void creerAnnonce(String nom, String telephone, String categorie, String ville, String rue, String code_postal){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("INSERT INTO annonce (nom,telephone,categorie) VALUES ('"+nom+"','"+telephone+"','"+categorie+"') ", Statement.RETURN_GENERATED_KEYS);
			ResultSet resultat = statement.getGeneratedKeys();
			int idAnnonce = 0;
			while ( resultat.next() ) {
				idAnnonce = resultat.getInt( 1 );
			}
			creerAdresse(rue, ville, code_postal, String.valueOf(idAnnonce));
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void modifierAnnonce(String id, String nom, String telephone, String categorie, String rue, String ville, String code_postal){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			statement = connexion.createStatement();
			statement.executeUpdate("UPDATE annonce SET nom = '"+nom+"',telephone ='"+telephone+"',categorie = '"+categorie+"' WHERE id = '"+id+"' ");
			String idAdresse = rechercherAdresse(id).getId();
			modifierAdresse(idAdresse, rue, ville, code_postal, id);
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void supprimerAnnonce(String id){
		try{
			Adresse adresse = rechercherAdresse(id);
			String idAdresse = adresse.getId();
			Connection connexion = connectDB();
		
			Statement statement;
			statement = connexion.createStatement();
			supprimerAdresse(idAdresse);
			statement.executeUpdate("DELETE FROM annonce WHERE id = '"+id+"' ");
			if (connexion!=null){
				try {
	        	connexion.close();
				} catch ( SQLException ignore ) {
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Adresse rechercherAdresse(String idAnnonce){
		Adresse adresse = new Adresse();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM adresse WHERE annonce= '" + idAnnonce + "';");
			while ( result.next()) {
	            String id = result.getString( "id" );
	            String rue = result.getString( "rue" );
	            String ville = result.getString( "ville" );
	            String code_postal = result.getString( "code_postal" );
	            
	            adresse.setId(id);
	            adresse.setIdAnnonce(idAnnonce);
	            adresse.setRue(rue);
	            adresse.setVille(ville);
	            adresse.setCodePostal(code_postal);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return adresse;
	}
	
	public static String rechercherAdresseString(String idAnnonce){
		Adresse adresse = new Adresse();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM adresse WHERE annonce= '" + idAnnonce + "';");
			while ( result.next()) {
	            String id = result.getString( "id" );
	            String rue = result.getString( "rue" );
	            String ville = result.getString( "ville" );
	            String code_postal = result.getString( "code_postal" );
	            
	            adresse.setId(id);
	            adresse.setIdAnnonce(idAnnonce);
	            adresse.setRue(rue);
	            adresse.setVille(ville);
	            adresse.setCodePostal(code_postal);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat = "<Adresse>"
				 + "<id>" + adresse.getId() + "</id>"
				 + "<idAnnonce>" + adresse.getIdAnnonce() + "</idAnnonce>"
				 + "<rue>" + adresse.getRue()  + "</rue>"
				 + "<ville>" + adresse.getVille()  + "</ville>"
				 + "<code_postal>" + adresse.getCodePostal() + "</code_postal>"
				 + "</Adresse>" ;
				 
		return Resultat;
	}
	
	public static String rechercherAdresseStringId(String idAdresse){
		Adresse adresse = new Adresse();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM adresse WHERE id= '" + idAdresse + "';");
			while ( result.next()) {
	            String idAnnonce = result.getString( "annonce" );
	            String rue = result.getString( "rue" );
	            String ville = result.getString( "ville" );
	            String code_postal = result.getString( "code_postal" );
	            
	            adresse.setId(idAdresse);
	            adresse.setIdAnnonce(idAnnonce);
	            adresse.setRue(rue);
	            adresse.setVille(ville);
	            adresse.setCodePostal(code_postal);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat = "<Adresse>"
				 + "<id>" + adresse.getId() + "</id>"
				 + "<idAnnonce>" + adresse.getIdAnnonce() + "</idAnnonce>"
				 + "<rue>" + adresse.getRue()  + "</rue>"
				 + "<ville>" + adresse.getVille()  + "</ville>"
				 + "<code_postal>" + adresse.getCodePostal() + "</code_postal>"
				 + "</Adresse>" ;
				 
		return Resultat;
	}
	
	public static String rechercherCategorieString(String idCategorie){
		Categorie categorie = new Categorie();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM categorie WHERE id= '" + idCategorie + "';");
			while ( result.next()) {
	            String id = result.getString( "id" );
	            String titre = result.getString( "titre" );
	            
	            categorie.setId(id);
	            categorie.setTitre(titre);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat = "<Categorie>"
				 + "<id>" + categorie.getId() + "</id>"
				 + "<titre>" + categorie.getTitre()  + "</titre>"
				 + "</Categorie>";
		return Resultat;
	}
	
	public static String rechercherAnnonceNom(String nom){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce WHERE nom= '" + nom + "';");
			while ( result.next()) {
	            String idAnnonce = result.getString( "id" );
	            String idCategorie = result.getString( "categorie" );
	            String telephone = result.getString( "telephone" );
	            Adresse adresse = rechercherAdresse(idAnnonce);
	            Annonce annonce = new Annonce();
	            annonce.setId(idAnnonce);
	            annonce.setIdCategorie(idCategorie);
	            annonce.setTelephone(telephone);
	            annonce.setAdresse(adresse);
	            annonce.setNom(nom);
	            
	            annonces.add(annonce);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat="<Annonces>";
		for (Annonce annonce : annonces) {
			Resultat = Resultat + "<Annonce>"
				 + "<id>" + annonce.getId() + "</id>"
				 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
				 + "<nom>" + annonce.getNom()  + "</nom>"
				 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
				 + "<adresse>" 
				 + "<id>" + annonce.getAdresse().getId() + "</id>"
				 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
				 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
				 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
				 + "</adresse>"
				 + "</Annonce>";
		}
		Resultat = Resultat + "</Annonces>";
		return Resultat;
	}
	
	public static String rechercherAnnonceIdString(String idAnnonce){
		Annonce annonce = new Annonce();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce WHERE id= '" + idAnnonce+ "';");
			while ( result.next()) {
				String idCategorie = result.getString( "categorie" );
	            String nom = result.getString( "nom" );
	            String telephone = result.getString( "telephone" );
	            Adresse adresse = rechercherAdresse(idAnnonce);
	            
	            annonce.setId(idAnnonce);
	            annonce.setIdCategorie(idCategorie);
	            annonce.setTelephone(telephone);
	            annonce.setAdresse(adresse);
	            annonce.setNom(nom);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat = "<Annonce>"
			 + "<id>" + annonce.getId() + "</id>"
			 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
			 + "<nom>" + annonce.getNom()  + "</nom>"
			 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
			 + "<adresse>" 
			 + "<id>" + annonce.getAdresse().getId() + "</id>"
			 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
			 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
			 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
			 + "</adresse>"
			 + "</Annonce>";
		return Resultat;
	}
	
	public static Annonce rechercherAnnonceId(String id){
		Annonce annonce = new Annonce();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce WHERE id= '" + id+ "';");
			while ( result.next()) {
				String idCategorie = result.getString( "categorie" );
	            String nom = result.getString( "nom" );
	            String telephone = result.getString( "telephone" );
	            Adresse adresse = rechercherAdresse(id);
	            
	            annonce.setId(id);
	            annonce.setIdCategorie(idCategorie);
	            annonce.setTelephone(telephone);
	            annonce.setAdresse(adresse);
	            annonce.setNom(nom);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return annonce;
	}
	
	public static String rechercherAnnonceIdCategorie(String idCategorie){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try{
			Connection connexion = connectDB();
			
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce WHERE categorie= '" + idCategorie+ "';");
			while ( result.next()) {
	            String nom = result.getString( "nom" );
	            String telephone = result.getString( "telephone" );
	            String id = result.getString( "id" );
	            Adresse adresse = rechercherAdresse(id);
	            
	            Annonce annonce = new Annonce();
	            annonce.setId(id);
	            annonce.setIdCategorie(idCategorie);
	            annonce.setTelephone(telephone);
	            annonce.setAdresse(adresse);
	            annonce.setNom(nom);
	            annonces.add(annonce);
	        }
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat="<Annonces>";
		for (Annonce annonce : annonces) {
			Resultat = Resultat + "<Annonce>"
				 + "<id>" + annonce.getId() + "</id>"
				 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
				 + "<nom>" + annonce.getNom()  + "</nom>"
				 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
				 + "<adresse>" 
				 + "<id>" + annonce.getAdresse().getId() + "</id>"
				 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
				 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
				 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
				 + "</adresse>"
				 + "</Annonce>";
		}
		Resultat = Resultat + "</Annonces>";
		return Resultat;
	}
	
	public static ArrayList<Annonce> rechercherAnnonceIdCategorieArray(String idCategorie){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try{
			Connection connexion = connectDB();
			
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce WHERE categorie= '" + idCategorie+ "';");
			while ( result.next()) {
	            String nom = result.getString( "nom" );
	            String telephone = result.getString( "telephone" );
	            String id = result.getString( "id" );
	            Adresse adresse = rechercherAdresse(id);
	            
	            Annonce annonce = new Annonce();
	            annonce.setId(id);
	            annonce.setIdCategorie(idCategorie);
	            annonce.setTelephone(telephone);
	            annonce.setAdresse(adresse);
	            annonce.setNom(nom);
	            annonces.add(annonce);
	        }
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return annonces;
	}
	
	public static String rechercherAnnonceVille( String ville){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM adresse WHERE ville= '" + ville + "';");
			while ( result.next()) {
				String idAnnonce = result.getString( "annonce" );
				Annonce annonce = rechercherAnnonceId(idAnnonce);
	            annonces.add(annonce);
	        }
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat="<Annonces>";
		for (Annonce annonce : annonces) {
			Resultat = Resultat + "<Annonce>"
				 + "<id>" + annonce.getId() + "</id>"
				 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
				 + "<nom>" + annonce.getNom()  + "</nom>"
				 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
				 + "<adresse>" 
				 + "<id>" + annonce.getAdresse().getId() + "</id>"
				 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
				 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
				 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
				 + "</adresse>"
				 + "</Annonce>";
		}
		Resultat = Resultat + "</Annonces>";
		return Resultat;
		
	}
	
	public static String rechercherAnnonceCategorie( String titreCategorie){
		String annonces="";
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM categorie WHERE titre= '" + titreCategorie + "';");
			while ( result.next()) {
				String idCategorie = result.getString( "id" );
				annonces = rechercherAnnonceIdCategorie(idCategorie);
	           
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return annonces;
		
	}
	
	public static String afficherCategories(){
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM categorie;");
			while ( result.next()) {
				String idCategorie = result.getString( "id" );
				String titre = result.getString( "titre" );
				ArrayList<Annonce> annonces = rechercherAnnonceIdCategorieArray(idCategorie);
				Categorie categorie = new Categorie();
				categorie.setAnnonce(annonces);
				categorie.setId(idCategorie);
				categorie.setTitre(titre);
				categories.add(categorie);
	        }
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat="<Categories>";
		for (Categorie categorie : categories) {
			Resultat = Resultat + "<Categorie>"
					 + "<id>" + categorie.getId() + "</id>"
					 + "<titre>" + categorie.getTitre()  + "</titre>";
			for (Annonce annonce : categorie.getAnnonce()) {
				Resultat = Resultat + "<Annonce>"
						 + "<id>" + annonce.getId() + "</id>"
						 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
						 + "<nom>" + annonce.getNom()  + "</nom>"
						 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
						 + "<adresse>" 
						 + "<id>" + annonce.getAdresse().getId() + "</id>"
						 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
						 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
						 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
						 + "</adresse>"
						 + "</Annonce>";
			}
			
			Resultat = Resultat + "</Categorie>";
					
		}
		Resultat = Resultat + "</Categories>";
		return Resultat;
		
	}
	
	public static String afficherAnnonces(){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			ResultSet result;
			statement = connexion.createStatement();
			result = statement.executeQuery("SELECT * FROM annonce;");
			while ( result.next()) {
				String idAnnonce = result.getString( "id" );
				String idCategorie = result.getString( "categorie" );
				String nom = result.getString( "nom" );
				String telephone = result.getString( "telephone" );
				Adresse adresse = new Adresse();
				adresse = rechercherAdresse(idAnnonce);
				Annonce annonce = new Annonce();
				annonce.setAdresse(adresse);
				annonce.setId(idAnnonce);
				annonce.setIdCategorie(idCategorie);
				annonce.setNom(nom);
				annonce.setTelephone(telephone);
				
				annonces.add(annonce);
	        }
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		String Resultat="<Annonces>";
		for (Annonce annonce : annonces) {
			Resultat = Resultat + "<Annonce>"
				 + "<id>" + annonce.getId() + "</id>"
				 + "<idCategorie>" + annonce.getIdCategorie() + "</idCategorie>"
				 + "<nom>" + annonce.getNom()  + "</nom>"
				 + "<telephone>" + annonce.getTelephone()  + "</telephone>"
				 + "<adresse>" 
				 + "<id>" + annonce.getAdresse().getId() + "</id>"
				 + "<rue>" + annonce.getAdresse().getRue() + "</rue>"
				 + "<ville>" + annonce.getAdresse().getVille() + "</ville>"
				 + "<code_postal>" + annonce.getAdresse().getCodePostal() + "</code_postal>"
				 + "</adresse>"
				 + "</Annonce>";
		}
		Resultat = Resultat + "</Annonces>";
		return Resultat;
		
	}
	  
}