package fr.insa.microservice.ManagementPersonneMs.model;

public class Benevole extends Personne{
	public Benevole(int id, String nom, String prenom, int age,int role) {
		super(id, nom, prenom, age,role);
		role=2;
	}
	public Benevole() {
		super();
	}
	public String toString() {
		return "Benevole :" + this.getNom()+" "+this.getPrenom()+" ---- "+this.getAge()+" ans ---- ";
	}
}
