package fr.insa.microservice.feedbackMs.model;

import java.util.List;

public class feedback {
    private int idmission;
    private List<String> comment;


    public feedback(int idmission, List<String>  comment ) {
		this.idmission = idmission;
		this.comment = comment;
	}
    public List<String>  getComment() {
        return comment;
    }
    public int getIdmission() {
        return idmission;
    }
    public void setComment(List<String>  comment) {
        this.comment = comment;
    }
    public void setIdmission(int idmission) {
        this.idmission = idmission;
    }

}
