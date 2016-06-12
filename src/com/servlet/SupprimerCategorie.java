package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.AdministrateurProxy;
import com.jdom.JDOM;



public class SupprimerCategorie extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String VUE              = "/gestionAnnuaire.jsp";
	
	 public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		 AdministrateurProxy admin = new AdministrateurProxy();
		 	
		 String idCategorie = getValeurChamp( request, "id" );
		 	
		 admin.supprimerCategorie(idCategorie);
		 
		 String categories = admin.afficherCategories();
			List<String> ids = JDOM.returnIdCategorie(categories);
			List<String> titres = JDOM.returnTitreCategorie(categories);
			
			request.setAttribute( "ids", ids );
			request.setAttribute( "titres", titres );
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
