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
import com.sdzee.beans.Questionnaire;


public class SupprimerQuestion extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/administrateur/afficherQuestionnaire.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

	        /* Traitement de la requête et récupération du bean en résultant */
		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	String id = getValeurChamp( request, "id" );
		 	
		 	Question question = test.rechercherQuestionId(id);
		 	String idQuestionnaire = question.getIdQuestionnaire();
		 	Questionnaire questionnaire = test.rechercherQuestionnaireId(idQuestionnaire);
		 	test.supprimerQuestion(id); 
		 	
		 	List<Question> questions = test.afficherQuestions(idQuestionnaire);
		 	
		 	if (questions.isEmpty()){
		 		test.modifierQuestionnaireStatut(idQuestionnaire, "0");
		 	}
			
			request.setAttribute( "questions", questions );
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
