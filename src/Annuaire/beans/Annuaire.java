package Annuaire.beans;

public class Annuaire {

		private Annuaire(){}
		
		//Création de l'instance unique
		private static Annuaire annuaire = new Annuaire();		
		
		private static Annuaire getAnnuaire(){
			return annuaire;
		}
}