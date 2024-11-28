package fr.insa.microservice.ManagementPersonneMs.model;

public class Demandeur extends Personne{
	 
	public Demandeur(int id, String nom, String prenom, int age,String role) {
		super(id, nom, prenom, age,role);
		role="Demandeur";
	}
	public Demandeur() {
		super();
	}
	public String toString() {
		return "Demandeur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- ";
	}
}
