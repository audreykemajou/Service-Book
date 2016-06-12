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


public class ModifierQuestion extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String GET              = "/administrateur/modifierQuestion.jsp";
	public static final String POST              = "/administrateur/afficherQuestionnaire.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	
	 	Question question = test.rechercherQuestionId(id);
	 	Questionnaire questionnaire = test.rechercherQuestionnaireId(question.getIdQuestionnaire());
		
		request.setAttribute( "question", question );
		request.setAttribute( "questionnaire", questionnaire );
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	 	
		TestJDBC test = new TestJDBC();
		String id = getValeurChamp( request, "id" );
	 	String idQuestionnaire = getValeurChamp( request, "idQuestionnaire" );
	 	String libelle = getValeurChamp( request, "libelle" );
	 	String ordre = getValeurChamp( request, "ordre" );
	 	
	 	test.modifierQuestion(id, idQuestionnaire, libelle, ordre);
	 	
	 	Questionnaire questionnaire = test.rechercherQuestionnaireId(idQuestionnaire);
		
		List<Question> questions = test.afficherQuestions(idQuestionnaire);
		
		request.setAttribute( "questions", questions );
		request.setAttribute( "questionnaire", questionnaire );

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
