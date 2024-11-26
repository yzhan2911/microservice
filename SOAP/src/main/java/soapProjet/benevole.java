package soapProjet;

public class benevole extends personne{
    public benevole(String Id,String nom,String prenom){
        super( Id,  nom,  prenom);
    }
 
    @Override
    public String toString() {
		return "Benevole :" + this.getNom()+" "+this.getPrenom();
	}

  
}
