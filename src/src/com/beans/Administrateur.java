package com.beans;

import com.bdd.JDBC;

public class Administrateur {
	public static void creerCategorie(String titre){
		JDBC.creerCategorie(titre);
	}

	public static void modifierCategorie(String titre,String id){
		JDBC.modifierCategorie(titre, id);
	}
	
	public static void supprimerCategorie(String id){
		JDBC.supprimerCategorie(id);
	}
	
	public static void creerAdresse(String rue, String ville, String code_postal, String annonce){
		JDBC.creerAdresse(rue, ville, code_postal, annonce);
	}
	
	public static void modifierAdresse(String id,String rue, String ville, String code_postal, String annonce){
		JDBC.modifierAdresse(id, rue, ville, code_postal, annonce);
	}
	
	public static void supprimerAdresse(String id){
		JDBC.supprimerAdresse(id);
	}
	
	public static void creerAnnonce(String nom, String telephone, String categorie, String rue, String ville, String code_postal){
		JDBC.creerAnnonce(nom, telephone, categorie, ville, rue, code_postal);
	}
	
	public static void modifierAnnonce(String id, String nom, String telephone, String categorie, String rue, String ville, String code_postal){
		JDBC.modifierAnnonce(id, nom, telephone, categorie, rue, ville, code_postal);
	}
	
	public static void supprimerAnnonce(String id){
		JDBC.supprimerAnnonce(id);
	}
	
	public static String rechercherAnnonceNom(String nom){
		String annonce = JDBC.rechercherAnnonceNom(nom);
		return annonce;
	}
	
	public static String rechercherAnnonceVille( String ville){
		String annonces = JDBC.rechercherAnnonceVille(ville);
		return annonces;
	}
	
	public static String rechercherAnnonceCategorie( String titreCategorie){
		String annonces = JDBC.rechercherAnnonceCategorie(titreCategorie);
		return annonces;
	}
	
	public static String afficherCategories(){
		String categories = JDBC.afficherCategories();
		return categories;
	}
	
	public static String afficherAnnonces(){
		String annonces = JDBC.afficherAnnonces();
		return annonces;
	}
	
	public static String rechercherAdresseString(String idAnnonce){
		String adresse = JDBC.rechercherAdresseString(idAnnonce);
		return adresse;
	}
	
	public static String rechercherAnnonceIdCategorie(String idCategorie){
		String annonces = JDBC.rechercherAnnonceIdCategorie(idCategorie);
		return annonces;
	}
	
	public static String rechercherAdresseStringId(String idAdresse){
		String adresse = JDBC.rechercherAdresseStringId(idAdresse);
		return adresse;
	}
	
	public static String rechercherCategorieString(String idCategorie){
		String categorie = JDBC.rechercherCategorieString(idCategorie);
		return categorie;
	}
	
	public static String rechercherAnnonceIdString(String idAnnonce){
		String annonce = JDBC.rechercherAnnonceIdString(idAnnonce);
		return annonce;
	}
}
