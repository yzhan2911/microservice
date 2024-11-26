package fr.insa.microservice.ManagementMissionMs.model;

public class Mission {
	private static final String [] States = {"En Attente", "Validée", "Refusée", "Terminée"};
	
	private int idmission;
	private int idDemandeur;
    private int idBenevole;
	private String state;
	private String comment;
	
	public Mission(int idmission, int idDemandeur ) {
		this.idmission = idmission;
		this.idDemandeur = idDemandeur;
		StateInitiale();
	}

	public Mission(int idmission, int idDemandeur , int idBenevole,int state,String comment ) {
		this.idmission = idmission;
		this.idDemandeur = idDemandeur;
        this.idBenevole=idBenevole;
		this.comment=comment;
		setStateByNumber(state);
	}
	
	public void setStateByNumber(int stateNumber) {
		if (stateNumber >= 0 && stateNumber < States.length) {
			this.state = States[stateNumber];
		} else {
			throw new IllegalArgumentException("Numéro d'état invalide : " + stateNumber);
		}
	}

	public int getStateNumber() {
		switch (getState()) {
			case "En Attente":
				return 0;
			case "Validée":
				return 1;
			case "Refusée":
				return 2; 
			case "Terminée":
				return 3; 
			default:
				break;
		}
		return 0;
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