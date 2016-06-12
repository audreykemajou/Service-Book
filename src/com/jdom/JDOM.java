package com.jdom;

//import java.io.*;
import org.jdom2.*;
import org.jdom2.input.*;
//import org.jdom2.filter.*;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class JDOM{
	static org.jdom2.Document document;
	static Element racine;
	
	public static List<String> returnIdCategorie(String result){
		List<String> ids = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		
		try
		{
			
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		StringReader strReader=new StringReader(result);
		//ByteArrayInputStream file = new ByteArrayInputStream(result.getBytes());
		
		document = sxb.build(strReader);
		
		}
		
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listCategories = racine.getChildren("Categorie");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listCategories.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String id = courant.getChild("id").getText();
			ids.add(id);
		}
		return ids;
	}
	
	public static List<String> returnTitreCategorie(String result){
		List<String> titres = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listEtudiants = racine.getChildren("Categorie");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listEtudiants.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String titre = courant.getChild("titre").getText();
			titres.add(titre);
		}
		return titres;
	}
	
	public static List<String> returnNomAnnonce(String result){
		List<String> titres = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listEtudiants = racine.getChildren("Annonce");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listEtudiants.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String titre = courant.getChild("nom").getText();
			titres.add(titre);
		}
		return titres;
	}
	
	public static List<String> returnIdAnnonce(String result){
		List<String> ids = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listEtudiants = racine.getChildren("Annonce");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listEtudiants.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String id = courant.getChild("id").getText();
			ids.add(id);
		}
		return ids;
	}
	
	public static List<String> returnTelAnnonce(String result){
		List<String> tels = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listEtudiants = racine.getChildren("Annonce");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listEtudiants.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String tel = courant.getChild("telephone").getText();
			tels.add(tel);
		}
		return tels;
	}
	
	public static List<String> returnIdCategorieAnnonce(String result){
		List<String> tels = new ArrayList<String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		//On crée une List contenant tous les noeuds "etudiant" de l'Element racine
		List<Element> listEtudiants = racine.getChildren("Annonce");
		//On crée un Iterator sur notre liste
		Iterator<Element> i = listEtudiants.iterator();
		while(i.hasNext()){
			//On recrée l'Element courant à chaque tour de boucle afin de
			//pouvoir utiliser les méthodes propres aux Element comme :
			//selectionner un noeud fils, modifier du texte, etc.
			Element courant = (Element)i.next();
			//On affiche le nom de l'élément courant
			String tel = courant.getChild("idCategorie").getText();
			tels.add(tel);
		}
		return tels;
	}
	
	public static HashMap<String,String> returnAdresse(String result){
		HashMap<String,String> adresse = new HashMap<String,String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		String id = racine.getChild("id").getText();
		adresse.put("id", id);
		String idAnnonce = racine.getChild("idAnnonce").getText();
		adresse.put("idAnnonce", idAnnonce);
		String rue = racine.getChild("rue").getText();
		adresse.put("rue", rue);
		String ville = racine.getChild("ville").getText();
		adresse.put("ville", ville);
		String code_postal = racine.getChild("code_postal").getText();
		adresse.put("code_postal", code_postal);
			
		return adresse;
	}
	
	public static HashMap<String,String> returnCategorie(String result){
		HashMap<String,String> categorie = new HashMap<String,String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		String id = racine.getChild("id").getText();
		categorie.put("id", id);
		String titre = racine.getChild("titre").getText();
		categorie.put("titre", titre);
		
		return categorie;
	}
	
	public static HashMap<String,String> returnAnnonce(String result){
		HashMap<String,String> annonce = new HashMap<String,String>();
		//On crée une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		try
		{
		//On crée un nouveau document JDOM avec en argument le fichier XML
		//Le parsing est terminé ;)
		document = sxb.build(new ByteArrayInputStream(result.getBytes()));
		}
		catch(Exception e){}
		//On initialise un nouvel élément racine avec l'élément racine du document.
		racine = document.getRootElement();
		
		String id = racine.getChild("id").getText();
		annonce.put("id", id);
		String idCategorie = racine.getChild("idCategorie").getText();
		annonce.put("idCategorie", idCategorie);
		String nom = racine.getChild("nom").getText();
		annonce.put("nom", nom);
		String telephone = racine.getChild("telephone").getText();
		annonce.put("telephone", telephone);
		
		return annonce;
	}
}