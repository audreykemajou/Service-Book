package com.sdzee.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.sdzee.bdd.TestJDBC;
import com.sdzee.beans.Questionnaire;
import com.sdzee.beans.Utilisateur;

//import com.sdzee.beans.Utilisateur;
public class VoirListeQuestionnaires extends HttpServlet{
    
	private static final long serialVersionUID = 1L;
	//private static final String CHAMP_SUJET  = "sujet";
	public static final String VUE              = "/stagiaire/voirListeQuestionnaires.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		TestJDBC test = new TestJDBC();
		
		//Affichage de la liste des questionnaires
		List<Questionnaire> questionnaires = test.afficherQuestionnairesActifs();
		request.setAttribute( "questionnaires", questionnaires );

		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Traitement de la requête et récupération du bean en résultant */
	 	HttpSession session = request.getSession();
	 	
	 	TestJDBC test = new TestJDBC();
	 	String sujet = getValeurChamp( request, "sujet" );
	 
	 	Questionnaire questionnaire = test.rechercherQuestionnaire(sujet);
	 	
        /* Récupération de la session depuis la requête */
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

