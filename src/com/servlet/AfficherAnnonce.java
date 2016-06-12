package com.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdministrateurProxy;
import com.jdom.JDOM;


public class AfficherAnnonce extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String VUE              = "/afficherAnnonce.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministrateurProxy admin = new AdministrateurProxy();
	 	String idAnnonce = getValeurChamp(request, "id");
		
	 	String result = admin.rechercherAdresseString(idAnnonce);
	 	HashMap<String,String> adresse = JDOM.returnAdresse(result);
	 	
		request.setAttribute( "adresse", adresse );
		request.setAttribute( "idAnnonce", idAnnonce );

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
