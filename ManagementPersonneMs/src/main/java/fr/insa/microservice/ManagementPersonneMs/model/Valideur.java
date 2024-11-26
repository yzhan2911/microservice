package fr.insa.microservice.ManagementPersonneMs.model;

public class Valideur extends Personne{
	public Valideur(int id, String nom, String prenom, int age,int role) {
		super(id, nom, prenom, age,role);
		role=3;
	}
	public Valideur() {
		super();
	}
	public String toString() {
		return "Valideur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- " ;
	}
}
