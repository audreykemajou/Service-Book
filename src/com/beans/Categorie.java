package com.beans;

import java.util.ArrayList;

public class Categorie {
	private String id;
	private String titre;
	private ArrayList<Annonce> annonces;
	
	public String getId(){
		return id;
	}
	public String getTitre(){
		return titre;
	}
	public ArrayList<Annonce> getAnnonce(){
		return annonces;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setTitre(String titre){
		this.titre = titre;
	}
	
	public void setAnnonce(ArrayList<Annonce> annonces){
		this.annonces = annonces;
	}
}