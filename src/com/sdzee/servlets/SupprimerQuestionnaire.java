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


public class SupprimerQuestionnaire extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/administrateur/gestionQuestionnaire.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	String id = getValeurChamp( request, "id" );
		 	
		 	
		 	test.supprimerQuestionnaire(id); 
		 	
		 	List<Questionnaire> questionnaires = test.afficherQuestionnaires();
			List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
			
			request.setAttribute( "questionnaires", questionnaires );
			
			for(Questionnaire questionnaire : questionnaires){
				String idAdmin = questionnaire.getIdAdmin();
				Utilisateur user = test.rechercherCompteId(idAdmin);
				utilisateurs.add(user);
			}
			
			request.setAttribute( "users", utilisateurs );
			
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
