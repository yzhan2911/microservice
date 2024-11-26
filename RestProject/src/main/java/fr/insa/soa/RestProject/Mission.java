package fr.insa.soa.RestProject;
 

public class Mission {
	private String [] States = {"En Attente", "Validée", "Refusée", "Terminée"};
	private int idmission;
	private Demandeur demandeur;
	private String state;
	private int score;
	private String comment;
	
	public Mission(int id, Demandeur demandeur) {
		this.idmission = id;
		this.demandeur = demandeur;
		StateInitiale();
	}
	
	public Mission() {
		
	}
	public int getIdmission() {
		return idmission;
	}
	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}
	public Demandeur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Demandeur demandeur) {
		this.demandeur = demandeur;
	}
	public String getState() {
		return state;
	}
	public void StateInitiale() {
		this.state = States[0];
	}
	public void StateValide() {
		this.state = States[1];
	}
	public void StateRefuse() {
		this.state = States[2];
	}
	public void StateTermine() {
		this.state = States[3];
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
