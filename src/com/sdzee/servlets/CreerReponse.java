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


public class CreerReponse extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String POST              = "/administrateur/afficherQuestion.jsp";
	public static final String GET              = "/administrateur/creerReponse.jsp";
	
	
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Traitement de la requête et récupération du bean en résultant */
	 	
		HttpSession session = request.getSession();
	 	
	 	TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	Question question = test.rechercherQuestionId(id);
	 	
	 	request.setAttribute( "question", question );
	 	
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
    }

	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		 	HttpSession session = request.getSession();
		 	
		 	TestJDBC test = new TestJDBC();
		 	
		 	String libelle = getValeurChamp( request, "libelle" );
		 	String statut = getValeurChamp( request, "statut" );
		 	String idQuestion = getValeurChamp( request, "id" );
		 	String bonne = getValeurChamp( request, "bonne" );
		 	String ordre = getValeurChamp( request, "ordre" );
		 	
		 	Question question = test.rechercherQuestionId(idQuestion);
		 	
		 	test.creerReponse(libelle, statut, idQuestion, bonne, ordre);
			
			test.modifierQuestionStatut("1", idQuestion);
			question = test.rechercherQuestionId(idQuestion);
			
			List<Reponse> reponses = question.getReponse();
			
			request.setAttribute( "question", question );
			request.setAttribute("reponses", reponses);
			
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
