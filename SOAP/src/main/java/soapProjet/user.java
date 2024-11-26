package soapProjet;

public class user extends personne{
    public user(String Id,String nom,String prenom){
        super( Id,  nom,  prenom);
    }

   
    @Override
    public String toString() {
		return "Demandeur :" + this.getNom()+" "+this.getPrenom();
	}
   
}