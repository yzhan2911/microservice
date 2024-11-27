package fr.insa.microservice.feedbackMs.model;

public class feedback {
    private int idmission;
	private String comment;

    public feedback(int idmission, String comment ) {
		this.idmission = idmission;
		this.comment = comment;
	}
    public String getComment() {
        return comment;
    }
    public int getIdmission() {
        return idmission;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public void setIdmission(int idmission) {
        this.idmission = idmission;
    }

}
