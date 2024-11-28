package fr.insa.microservice.ManagementPersonneMs.model;

public class Valideur extends Personne{
	public Valideur(int id, String nom, String prenom, int age,String role) {
		super(id, nom, prenom, age,role);
		role="Valideur";
	}
	public Valideur() {
		super();
	}
	public String toString() {
		return "Valideur :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- " ;
	}
}
