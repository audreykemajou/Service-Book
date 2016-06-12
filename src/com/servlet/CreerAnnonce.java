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



public class CreerAnnonce extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public static final String POST              = "/afficherCategorie.jsp";
	public static final String GET              = "/creerAnnonce.jsp";
		
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        
		AdministrateurProxy admin = new AdministrateurProxy();
		
	 	String idCategorie = getValeurChamp( request, "id" );
	 	
	 	String result = admin.rechercherCategorieString(idCategorie);
	 	HashMap<String,String> categorie = JDOM.returnCategorie(result);
	 	
	 	request.setAttribute( "categorie", categorie );
	 	
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
    }
	
	 public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

		 AdministrateurProxy admin = new AdministrateurProxy();
		 	
		 	String nom = getValeurChamp( request, "nom" );
		 	String idCategorie = getValeurChamp( request, "idCategorie" );
		 	String telephone = getValeurChamp(request, "telephone");
		 	String rue = getValeurChamp(request, "rue");
		 	String ville = getValeurChamp(request, "ville");
		 	String code_postal = getValeurChamp(request, "code_postal");
		 	
		 	admin.creerAnnonce(nom, telephone, idCategorie, rue, ville, code_postal);
		 	
		 	String annonces = admin.rechercherAnnonceIdCategorie(idCategorie);
			
		 	List<String> ids = JDOM.returnIdAnnonce(annonces);
			List<String> titres = JDOM.returnNomAnnonce(annonces);
			List<String> tels = JDOM.returnTelAnnonce(annonces);
			
			request.setAttribute( "ids", ids );
			request.setAttribute( "titres", titres );
			request.setAttribute( "tels", tels );
			request.setAttribute( "idCategorie", idCategorie );
			
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
