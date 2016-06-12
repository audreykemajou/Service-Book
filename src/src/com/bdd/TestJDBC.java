package com.bdd;

import java.util.ArrayList;

import com.beans.Annonce;

public class TestJDBC {

	public static void main(String[] args) {
			
			try{
				//Connection connexion = connectDB();
				//String categorie = "Immobilier";
				/*String id = "3";
				String rue ="1 Impasse Victor Hugo";
				String ville ="Paris";
				String code_postal ="75020";
				String annonce ="3";
				String nom = "Assistante maternelle";
				String telephone ="0412347689";
				String categorie = "1";*/
				//JDBC.creerCategorie(categorie);
				String annonces = JDBC.rechercherAnnonceIdCategorie("3");
				System.out.println(annonces);
				
				//modifierCategorie(categorie,id);
				//supprimerCategorie(id);
				//JDBC.creerAdresse("test", "test", "code_postal", "3");
				//modifierAdresse(id,rue, ville, code_postal, annonce);
				//supprimerAdresse(id);
				//JDBC.creerAnnonce("testest", "0201562302", "3");
				//modifierAnnonce(id, nom, telephone, categorie);
				//supprimerAnnonce(id);
				/*Statement statement;
				ResultSet result;
				
				statement = connexion.createStatement();
				result = statement.executeQuery("SELECT * FROM annuaire");
				
				while(result.next()){
					System.out.print(result.getInt("id"));
				}*/
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
}