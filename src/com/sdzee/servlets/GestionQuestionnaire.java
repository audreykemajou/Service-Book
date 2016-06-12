package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Questionnaire;
import com.sdzee.beans.Utilisateur;


public class GestionQuestionnaire extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private static final String CHAMP_SUJET  = "sujet";
	public static final String VUE              = "/administrateur/gestionQuestionnaire.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		TestJDBC test = new TestJDBC();
		List<Questionnaire> questionnaires = test.afficherQuestionnaires();
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		session.setAttribute("user", null);
		session.setAttribute("user", null);
		session.setAttribute("questionnaires", null);
		request.setAttribute( "questionnaires", questionnaires );
		
		for(Questionnaire questionnaire : questionnaires){
			String idAdmin = questionnaire.getIdAdmin();
			Utilisateur utilisateur = test.rechercherCompteId(idAdmin);
			utilisateurs.add(utilisateur);
		}
		
		request.setAttribute( "users", utilisateurs );
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}
	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	String sujet = getValeurChamp( request, CHAMP_SUJET );
		 
		 	Questionnaire questionnaire = test.rechercherQuestionnaire(sujet);
		 	String idAdmin = questionnaire.getIdAdmin();
		 	
		 	Utilisateur utilisateur = test.rechercherCompteId(idAdmin);
		 	request.setAttribute( "user", utilisateur );
		 	
	        /* Récupération de la session depuis la requête */
		 	request.setAttribute( "questionnaire", questionnaire );
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
