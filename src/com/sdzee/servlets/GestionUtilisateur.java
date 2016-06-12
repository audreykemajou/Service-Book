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


public class GestionUtilisateur extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_EMAIL  = "email";
	public static final String VUE              = "/administrateur/gestionUtilisateur.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TestJDBC test = new TestJDBC();
		List<Utilisateur> utilisateurs = test.afficherUtilisateur();
		
		session.setAttribute( "users", utilisateurs );
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}
	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	TestJDBC test = new TestJDBC();
		 	String email = getValeurChamp( request, CHAMP_EMAIL );
		 
		 	Utilisateur utilisateur = test.rechercherCompte(email);
	        /* Récupération de la session depuis la requête */
		 	request.setAttribute( "user", utilisateur );
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
