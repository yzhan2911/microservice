package soapProjet;

public class missionAide {
	private String [] States = {"En Attente", "validée", "Refusée", "Terminée"};
	private String idmission;
	private user demandeur;
	private String state;
	private String comment;
	public missionAide(String id, user demandeur) {
		this.idmission = id;
		this.demandeur = demandeur;
		StateInitiale();
	}
	
	public String getIdmission() {
		return this.idmission;
	}
	public void setIdmission(String idmission) {
		this.idmission = idmission;
	}
	public user getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(user demandeur) {
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
    public String toString() {
		return "Mission :" + this.getIdmission()+" "+this.getState();
	}
}
