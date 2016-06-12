package com.sdzee.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Parcours;
import com.sdzee.beans.Questionnaire;
import com.sdzee.beans.Utilisateur;


public class VoirParcours extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private static final String CHAMP_SUJET  = "sujet";
	public static final String GET              = "/stagiaire/afficherParcours.jsp";	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
	 	
	 	Utilisateur user = (Utilisateur) session.getAttribute("sessionUtilisateur");
	 	
		String IdUtilisateur = user.getId();
		String email = test.rechercherCompteId(IdUtilisateur).getEmail();
		ArrayList<Parcours> parcours_utilisateur = test.rechercherParcoursId(IdUtilisateur);
		ArrayList<String> sujets = new ArrayList<String>();
	
		for (Parcours parcours : parcours_utilisateur){
			
			String idQuestionnaire = parcours.getIdQuestionnaire();
			Questionnaire questionnaire = test.rechercherQuestionnaireId(idQuestionnaire);
			String sujet = questionnaire.getSujet();
			sujets.add(sujet);
		}
		
		session.setAttribute( "parcours_utilisateur", parcours_utilisateur );
		session.setAttribute( "sujets", sujets );
		session.setAttribute( "email", email );

		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
			
		}
	
}
