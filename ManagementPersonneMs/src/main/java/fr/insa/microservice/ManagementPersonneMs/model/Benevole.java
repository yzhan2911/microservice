package fr.insa.microservice.ManagementPersonneMs.model;

public class Benevole extends Personne{
	public Benevole(int id, String nom, String prenom, int age) {
		super(id, nom, prenom, age);
	}
	public Benevole() {
		super();
	}
	public String toString() {
		return "Benevole :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- ";
	}
}
