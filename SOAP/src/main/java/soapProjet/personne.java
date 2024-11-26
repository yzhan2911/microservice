package soapProjet;

public class personne {
	 private String Id;
	  private String nom;
	  private String prenom;


	  public personne(String Id,String nom,String prenom ) {
	      this.Id = Id;
	      this.nom =nom ;
	      this.prenom = prenom;
	  }

	  public  void setId(String id){
	    this.Id=id;
	  }

	  public  void setNom(String nom){
	    this.nom=nom;
	  }

	  public  void setPrenom(String prenom){
	    this.prenom=prenom;
	  }

	  public String getId() {
	    return this.Id;
	  }

	  public String getNom() {
	    return this.nom;
	  }

	  public String getPrenom() {
	    return this.prenom;
	  }


}
