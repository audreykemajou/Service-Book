package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Question;
import com.sdzee.beans.Reponse;


public class SupprimerReponse extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/administrateur/afficherQuestion.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	String id = getValeurChamp( request, "id" );
		 	
		 	Reponse reponse = test.rechercherReponseId(id);
		 	String idQuestion = reponse.getIdQuestion();
		 	Question question = test.rechercherQuestionId(idQuestion);
		 	test.supprimerReponse(id); 
		 	
		 	List<Reponse> reponses = test.afficherReponses(idQuestion);
		 	
		 	if (reponses.isEmpty()){
		 		test.modifierQuestionStatut("0", idQuestion);
		 	}
			request.setAttribute( "reponses", reponses );
			request.setAttribute( "question", question );
			
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
