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


public class AfficherQuestionnaire extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	//private static final String CHAMP_SUJET  = "sujet";
	public static final String VUE              = "/administrateur/afficherQuestionnaire.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	
	 	
	 	Questionnaire questionnaire = test.rechercherQuestionnaireId(id);
		
		List<Question> questions = test.afficherQuestions(id);
		
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
