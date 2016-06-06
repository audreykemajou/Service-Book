package com.bdd;

import java.util.ArrayList;
import java.util.List;

import com.beans.Annuaire;
import com.beans.Annonce;
import com.beans.Adresse;
import com.beans.Categorie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
			System.out.println("Connexion �tablie");
			
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
			int result;
			
			statement = connexion.createStatement();
			result = statement.executeUpdate("INSERT INTO categorie (titre,annuaire) VALUES ('"+ titre +"','1')");
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
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("UPDATE categorie SET  titre ='"+titre+"' WHERE id ='"+id+"'");
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
		
			Statement statement;
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("DELETE FROM categorie WHERE id ='"+id+"'");
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
			int result;
			
			statement = connexion.createStatement();
			result = statement.executeUpdate("INSERT INTO adresse (rue,ville,code_postal,annonce) VALUES ('"+ rue +"','"+ ville +"','"+ code_postal +"','"+ annonce +"')");
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
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("UPDATE adresse SET  rue ='"+rue+"', ville ='"+ville+"' , code_postal ='"+code_postal+"' , annonce ='"+annonce+"' WHERE id ='"+id+"'");
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
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("DELETE FROM adresse WHERE id ='"+id+"'");
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
	public static void creerAnnonce(String nom, String telephone, String categorie){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("INSERT INTO annonce (nom,telephone,categorie) VALUES ('"+nom+"','"+telephone+"','"+categorie+"') ");
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
	public static void modifierAnnonce(String id, String nom, String telephone, String categorie){
		try{
			Connection connexion = connectDB();
		
			Statement statement;
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("UPDATE annonce SET nom = '"+nom+"',telephone ='"+telephone+"',categorie = '"+categorie+"' WHERE id = '"+id+"' ");
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
			Connection connexion = connectDB();
		
			Statement statement;
			int result;
			statement = connexion.createStatement();
			result = statement.executeUpdate("DELETE FROM annonce WHERE id = '"+id+"' ");
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
	public static void rechercherAnnonceNom(){
		
	}
	public static void rechercherAnnonceVille(){
		
	}
	  
}