package com.beans;

public class Adresse {
	private String id;
	private String idAnnonce;
	private String rue;
	private String ville;
	private String code_postal;
	
	public String getId(){
		return id;
	}
	public String getRue(){
		return rue;
	}
	public String getIdAnnonce(){
		return idAnnonce;
	}
	public String getVille(){
		return ville;
	}
	public String getCodePostal(){
		return code_postal;
	}
	
	
	public void setId(String id){
		this.id = id;
	}
	public void setIdAnnonce(String idAnnonce){
		this.idAnnonce = idAnnonce;
	}
	
	public void setRue(String rue){
		this.rue = rue;
	}
	public void setVille(String ville){
		this.ville = ville;
	}
	public void setCodePostal(String code_postal){
		this.code_postal = code_postal;
	}
	
}