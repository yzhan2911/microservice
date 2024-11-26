package soapProjet;

public class valideur extends personne{
	public valideur(String id,String nom,String prenom){
	    super(id,nom,prenom);    
	  }
	  @Override
	public String toString() {
		return "Valideur :" + this.getId()+" "+this.getNom()+"  "+this.getPrenom();
	}
}

