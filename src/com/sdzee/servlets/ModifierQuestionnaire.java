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


public class ModifierQuestionnaire extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String GET              = "/administrateur/modifierQuestionnaire.jsp";
	public static final String POST              = "/administrateur/gestionQuestionnaire.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	
	 	Questionnaire questionnaire = test.rechercherQuestionnaireId(id);
		
		request.setAttribute( "questionnaire", questionnaire );
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	 	Utilisateur user = (Utilisateur) session.getAttribute("sessionUtilisateur");/* Traitement de la requête et récupération du bean en résultant */
		
	 	TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	System.out.println(id);
	 	String sujet = getValeurChamp( request, "sujet" );
	 	String idCreateur = user.getId();
	 	
	 	test.modifierQuestionnaire(id, sujet, idCreateur);
	 	
	 	List<Questionnaire> questionnaires = test.afficherQuestionnaires();
		List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		session.setAttribute( "questionnaires", questionnaires );
		
		for(Questionnaire questionnaire : questionnaires){
			String idAdmin = questionnaire.getIdAdmin();
			Utilisateur utilisateur = test.rechercherCompteId(idAdmin);
			utilisateurs.add(utilisateur);
		}
		
		request.setAttribute( "users", utilisateurs );

		this.getServletContext().getRequestDispatcher( POST ).forward( request, response );
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
