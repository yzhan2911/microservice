package fr.insa.microservice.ManagementPersonneMs.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Personne {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("prenom")
	private String prenom;
	@JsonProperty("age")
	private Integer age;
	@JsonProperty("role")
	private String role;
	
	
	public Personne(Integer id, String nom, String prenom, Integer age,String role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.role= role;
	}
 
	
	public int getId() {
		return id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role=role;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Personne() {
	}
}
