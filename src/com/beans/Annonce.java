package com.beans;

public class Annonce {
	private String id;
	private String nom;
	private String telephone;
	private Adresse adresse;
	
	public String getId(){
		return this.id;
	}
	public String getNom(){
		return this.nom;
	}
	public String getTelephone(){
		return this.telephone;
	}
	
	public Adresse getAdresse(){
		return this.adresse;
	}
	
	public void setId(String id){
		this.id = id;
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