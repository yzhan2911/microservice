package main.java.fr.insa.microservice.ManagementMissionMs.Model;

public class Mission {
	private String [] States = {"En Attente", "Validée", "Refusée", "Terminée"};
	private int idmission;
	private int idDemandeur;
    private int idBenevole;
	private String state;
	private String comment;
	
	public Mission(int idmission, int idDemandeur , int idBenevole ) {
		this.idmission = idmission;
		this.idDemandeur = idDemandeur;
        this.idBenevole=idBenevole;
		StateInitiale();
	}
	
	public int getIdmission() {
		return idmission;
	}
	public void setIdmission(int idmission) {
		this.idmission = idmission;
	}
	public int getIdBenevole() {
        return idBenevole;
    }
    public void setIdBenevole(int idBenevole) {
        this.idBenevole = idBenevole;
    }
    public int getIdDemandeur() {
        return idDemandeur;
    }
    public void setIdDemandeur(int idDemandeur) {
        this.idDemandeur = idDemandeur;
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
}