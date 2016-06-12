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


public class ModifierReponse extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String GET              = "/administrateur/modifierReponse.jsp";
	public static final String POST              = "/administrateur/afficherQuestion.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	
	 	Reponse reponse = test.rechercherReponseId(id);
	 	Question question = test.rechercherQuestionId(reponse.getIdQuestion());
		
		request.setAttribute( "question", question );
		request.setAttribute( "reponse", reponse );
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	 	
		TestJDBC test = new TestJDBC();
		String id = getValeurChamp( request, "id" );
	 	String idQuestion = getValeurChamp( request, "idQuestion" );
	 	String libelle = getValeurChamp( request, "libelle" );
	 	String statut = getValeurChamp( request, "statut" );
	 	String bonne = getValeurChamp( request, "bonne" );
	 	String ordre = getValeurChamp( request, "ordre" );
	 	
	 	test.modifierReponse(id, idQuestion, libelle, statut, bonne, ordre);
	 	
		Question question = test.rechercherQuestionId(idQuestion);
	 	List<Reponse> reponses = question.getReponse();
		
		request.setAttribute( "reponses", reponses );
		request.setAttribute( "question", question );

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
