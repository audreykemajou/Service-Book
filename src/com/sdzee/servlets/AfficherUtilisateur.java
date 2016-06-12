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


public class AfficherUtilisateur extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private static final String CHAMP_SUJET  = "sujet";
	public static final String GET              = "/administrateur/afficherUtilisateur.jsp";	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
		String idUtilisateur = getValeurChamp( request, "id" );
		String email = test.rechercherCompteId(idUtilisateur).getEmail();
		
		ArrayList<Parcours> parcours_utilisateur = test.rechercherParcoursId(idUtilisateur);
		ArrayList<String> sujets = new ArrayList<String>();
		
		for (Parcours parcours : parcours_utilisateur){
			String idQuestionnaire = parcours.getIdQuestionnaire();
			Questionnaire questionnaire = test.rechercherQuestionnaireId(idQuestionnaire);
			String sujet = questionnaire.getSujet();
			sujets.add(sujet);
		}
		
		session.setAttribute( "parcours_utilisateur", parcours_utilisateur );
		request.setAttribute( "sujets", sujets );
		request.setAttribute( "email", email );

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
