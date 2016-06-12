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


public class ModifierAnnonce extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String GET              = "/modifierAnnonce.jsp";
	public static final String POST              = "/afficherCategorie.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdministrateurProxy admin = new AdministrateurProxy();
	 	String idAnnonce = getValeurChamp( request, "id" );
	 	
	 	String result = admin.rechercherAnnonceIdString(idAnnonce);
	 	HashMap<String,String> annonce = JDOM.returnAnnonce(result);
	 	
	 	String idCategorie = annonce.get("idCategorie");
	 	
	 	String result2 = admin.rechercherCategorieString(idCategorie);
	 	HashMap<String,String> categorie = JDOM.returnCategorie(result2);
	 	
	 	String result3 = admin.rechercherAdresseString(idAnnonce);
	 	HashMap<String,String> adresse = JDOM.returnAdresse(result3);
		
	 	request.setAttribute( "annonce", annonce );
		request.setAttribute( "categorie", categorie );
		request.setAttribute( "adresse", adresse );
		
		this.getServletContext().getRequestDispatcher( GET ).forward( request, response );
		
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		AdministrateurProxy admin = new AdministrateurProxy();
		
	 	String idCategorie = getValeurChamp( request, "idCategorie" );
	 	String idAnnonce = getValeurChamp( request, "idAnnonce" );
	 	String nom = getValeurChamp( request, "nom" );
	 	String telephone = getValeurChamp( request, "telephone" );
	 	String rue = getValeurChamp( request, "rue" );
	 	String ville = getValeurChamp( request, "ville" );
	 	String code_postal = getValeurChamp( request, "code_postal" );
	 	
	 	admin.modifierAnnonce(idAnnonce, nom, telephone, idCategorie, rue, ville, code_postal);
	 	
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
