package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdzee.beans.Utilisateur;
import com.sdzee.forms.connexionForm;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/index.jsp";
    public static final String ADMIN            = "/administrateur/administrateur.jsp";
    public static final String STAGIAIRE              = "/stagiaire/stagiaire.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        connexionForm form = new connexionForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Utilisateur utilisateur = form.connecterUtilisateur( request );
        System.out.println(utilisateur.getAdmin());
        System.out.println(utilisateur.getNom());
        System.out.println(utilisateur.getId());
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

     
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
        
        if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, utilisateur );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
       
        if (utilisateur.getAdmin() == 1){
        	this.getServletContext().getRequestDispatcher( ADMIN ).forward( request, response );
        }
        else{
        	this.getServletContext().getRequestDispatcher( STAGIAIRE ).forward( request, response );
        }
    }
}