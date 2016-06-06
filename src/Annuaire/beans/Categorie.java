package Annuaire.beans;

public class Categorie {
	private String id;
	private String titre;
	
	public String getId(){
		return this.id;
	}
	public String getTitre(){
		return this.titre;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setTitre(String titre){
		this.titre = titre;
	}
}