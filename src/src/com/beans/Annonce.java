package com.beans;

public class Annonce {
	private String id;
	private String idCategorie;
	private String nom;
	private String telephone;
	private Adresse adresse;
	
	public String getId(){
		return id;
	}
	public String getIdCategorie(){
		return idCategorie;
	}
	public String getNom(){
		return nom;
	}
	public String getTelephone(){
		return telephone;
	}
	
	public Adresse getAdresse(){
		return adresse;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setIdCategorie(String idCategorie){
		this.idCategorie = idCategorie;
	}
	
	public void setNom(String nom){
		this.nom = nom;
	}
	
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}
	
	public void setAdresse(Adresse adresse){
		this.adresse = adresse;
	}
}