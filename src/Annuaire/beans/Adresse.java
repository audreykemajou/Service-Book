package Annuaire.beans;

public class Adresse {
	private String id;
	private String rue;
	private String ville;
	private int code_postal;
	
	public String getId(){
		return this.id;
	}
	public String getRue(){
		return this.rue;
	}
	public String getVille(){
		return this.ville;
	}
	public int getCodePostal(){
		return this.code_postal;
	}
	
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setRue(String rue){
		this.rue = rue;
	}
	public void setVille(String ville){
		this.ville = ville;
	}
	public void setCodePostal(int code_postal){
		this.code_postal = code_postal;
	}
	
}