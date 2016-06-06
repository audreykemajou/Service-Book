package com.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import Annuaire.beans.Annonce;

public class TestJDBC {

	public static void main(String[] args) {
			
			try{
				//Connection connexion = connectDB();
				String categorie = "Immobilier";
				/*String id = "3";
				String rue ="1 Impasse Victor Hugo";
				String ville ="Paris";
				String code_postal ="75020";
				String annonce ="3";
				String nom = "Assistante maternelle";
				String telephone ="0412347689";
				String categorie = "1";*/
				JDBC.creerCategorie(categorie);
				//modifierCategorie(categorie,id);
				//supprimerCategorie(id);
				//creerAdresse(rue, ville, code_postal, annonce);
				//modifierAdresse(id,rue, ville, code_postal, annonce);
				//supprimerAdresse(id);
				//creerAnnonce(nom, telephone, categorie);
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