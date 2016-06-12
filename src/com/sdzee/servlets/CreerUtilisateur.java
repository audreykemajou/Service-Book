package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Utilisateur;


public class CreerUtilisateur extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/administrateur/gestionUtilisateur.jsp";
	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	String email = getValeurChamp( request, "email" );
		 	String nom = getValeurChamp( request, "nom" );
		 	String prenom = getValeurChamp( request, "prenom" );
		 	String motDePasse = getValeurChamp( request, "motdepasse" );
		 	String societe = getValeurChamp( request, "societe" );
		 	String telephone = getValeurChamp( request, "telephone" );
		 	String admin = getValeurChamp( request, "admin" );
		 	String statut = getValeurChamp( request, "statut" );
		 	
		 	test.creerCompte(email, nom, prenom, motDePasse, societe, telephone, admin, statut);
		 	
		 	List<Utilisateur> utilisateurs = test.afficherUtilisateur();
			
			session.setAttribute( "users", utilisateurs );
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
	 
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	
		 	HttpSession session = request.getSession();
		 	
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
	 
	 private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	        String valeur = request.getParameter( nomChamp );
	        if ( valeur == null || valeur.trim().length() == 0 ) {
	            return null;
	        } else {
	            return valeur;
	        }
	    }
}
