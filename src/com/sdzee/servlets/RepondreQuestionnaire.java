package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Parcours;
import com.sdzee.beans.Question;
import com.sdzee.beans.Reponse;
import com.sdzee.beans.Utilisateur;


public class RepondreQuestionnaire extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private static final String CHAMP_SUJET  = "sujet";
	public static final String GET              = "/stagiaire/repondreQuestionnaire.jsp";
	public static final String POST             = "/stagiaire/voirParcours.jsp";	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
	 	String id = getValeurChamp( request, "id" );
	 	
	 	
	 	Utilisateur user = (Utilisateur) session.getAttribute("sessionUtilisateur");
	 	
	 	Parcours parcours = new Parcours();
		DateTime debut = new DateTime();
		int score = 0;
		parcours.setDebut(debut);
		parcours.setScore(score);
		parcours.setIdQuestionnaire(id);
		parcours.setIdUtilisateur(user.getId());
		session.setAttribute( "parcours", parcours );
	 	
	 	List<Question> questions = test.afficherQuestions(id);
	 	
	 	session.setAttribute( "question", questions.get(0) );
	 	request.setAttribute( "index", "0" );

		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TestJDBC test = new TestJDBC();
		HttpSession session = request.getSession();
		
	 	
	 	Parcours parcours = (Parcours) session.getAttribute("parcours");
	 	Question question = (Question) session.getAttribute("question");
	 	
	 	String idQuestionnaire = parcours.getIdQuestionnaire();
	 	String idUtilisateur = parcours.getIdUtilisateur();
	 	String idQuestion = question.getId();
	 	String ordreQuestion = question.getOrdre();
	 	int score = parcours.getScore();
	 	System.out.println(score);
	 	
	 	ArrayList<Question> questions = test.afficherQuestions(idQuestionnaire);
	 	ArrayList<Question> questionsP = test.afficherQuestionsP(idQuestionnaire);
	 	HashMap <String, String> question_reponse = new HashMap <String, String>();
	 	
	 	String reponse_donne = getValeurChamp( request, idQuestion );
	 	System.out.println(reponse_donne);
	 	Reponse reponse = test.rechercherBonneReponse(reponse_donne);
	 	int bonne = reponse.getBonne();
	 	System.out.println(bonne);
	 	if(bonne == 1){
	 		score = score + 1;
	 		parcours.setScore(score);
	 	}
	 	question_reponse.put(ordreQuestion, reponse_donne);
	 	String index_recup = getValeurChamp( request, "index" );
	 	if(Integer.parseInt(index_recup) < questions.size()-1){
	 		int index = Integer.parseInt(index_recup) + 1 ;
		 	request.setAttribute("index", index);
		 	session.setAttribute("question", questions.get(index));
		 	session.setAttribute( "questions", questions );
	 	}
	 	
	 	
	 	if(Integer.parseInt(index_recup) == questions.size()-1){
	 		DateTime fin = new DateTime();
	 		parcours.setFin(fin);
		 	DateTime debut = parcours.getDebut();
		 	int duree = fin.getSecondOfDay() - debut.getSecondOfDay();
		 	parcours.setDuree(duree);
		 	parcours.setReponse(question_reponse);
		 	score = parcours.getScore();
		 	test.creerParcours(score, duree, idQuestionnaire, idUtilisateur); 
		 	session.setAttribute( "parcours", parcours );
		 	request.setAttribute( "questions", questionsP );
		 	this.getServletContext().getRequestDispatcher( POST ).forward( request, response );
	 	}
	
	 	
	 	this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
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
