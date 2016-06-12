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


public class CreerQuestion extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String POST              = "/administrateur/afficherQuestionnaire.jsp";
	public static final String GET              = "/administrateur/creerQuestion.jsp";
	
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Traitement de la requête et récupération du bean en résultant */
	 	
		HttpSession session = request.getSession();
	 	
	 	TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	Questionnaire questionnaire = test.rechercherQuestionnaireId(id);
	 	
	 	request.setAttribute( "questionnaire", questionnaire );
	 	
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
    }

	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	
		 	String libelle = getValeurChamp( request, "libelle" );
		 	String sujet = getValeurChamp( request, "sujet" );
		 	String ordre = getValeurChamp(request, "ordre");

		 	Questionnaire questionnaire = test.rechercherQuestionnaire(sujet);
		 	String idQuestionnaire = questionnaire.getId();
		 	
		 	test.creerQuestion(libelle, idQuestionnaire, ordre);
			List<Question> questions = test.afficherQuestions(idQuestionnaire);
			
			if(questionnaire.getStatut() == 0){
				test.modifierQuestionnaireStatut(idQuestionnaire, "1");
				questionnaire = test.rechercherQuestionnaire(idQuestionnaire);
			}
			
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
