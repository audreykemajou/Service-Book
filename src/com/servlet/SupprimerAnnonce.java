package com.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdministrateurProxy;
import com.jdom.JDOM;



public class SupprimerAnnonce extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/afficherCategorie.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		 AdministrateurProxy admin = new AdministrateurProxy();
		 	
		 String idAnnonce = getValeurChamp( request, "id" );
		 	
		 admin.supprimerAnnonce(idAnnonce);
		 
		 String result = admin.rechercherAnnonceIdString(idAnnonce);
	 	 HashMap<String,String> annonce = JDOM.returnAnnonce(result);
	 	
	 	 String idCategorie = annonce.get("idCategorie");
	 
		 String annonces = admin.rechercherAnnonceIdCategorie(idCategorie);
			
		 	List<String> ids = JDOM.returnIdAnnonce(annonces);
			List<String> titres = JDOM.returnNomAnnonce(annonces);
			List<String> tels = JDOM.returnTelAnnonce(annonces);
			
			request.setAttribute( "ids", ids );
			request.setAttribute( "titres", titres );
			request.setAttribute( "tels", tels );
			request.setAttribute( "idCategorie", idCategorie );
			
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
