package fr.insa.microservice.ManagementPersonneMs.model;

public class Demandeur extends Personne{
	 
	public Demandeur(int id, String nom, String prenom, int age,int role) {
		super(id, nom, prenom, age,role);
		role=1;
	}
	public Demandeur() {
		super();
	}
	public String toString() {
		return "Demandeur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- ";
	}
}
