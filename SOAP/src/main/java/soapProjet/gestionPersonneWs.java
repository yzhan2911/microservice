package soapProjet;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="gestionPersonne")
public class gestionPersonneWs {
	@WebMethod(operationName="addDemandeur")
	public personne addDemandeur(@WebParam(name="idDemandeur") String id, 
								 @WebParam(name="nomDemandeur") String nom, 
								 @WebParam(name="prenomDemandeur")String prenom) {
		user user = new user(id, nom, prenom);
		System.out.println("Nouveau demandeur ajouté! " + user.toString());
		return user;
	}
	@WebMethod(operationName="addBenevole")
	public personne addBenevole( @WebParam(name="idBenevole") String id, 
								 @WebParam(name="nomBenevole") String nom, 
								 @WebParam(name="prenomBenevole")String prenom){
		benevole benevole = new benevole(id, nom, prenom);
		System.out.println("Nouveau benevole ajouté! " + benevole.toString());
		return benevole;
	}
	@WebMethod(operationName="addValideur")
	public personne addValideur( @WebParam(name="idValideur") String id, 
								 @WebParam(name="nomValideur") String nom, 
								 @WebParam(name="prenomValideur")String prenom) {
		valideur valideur = new valideur(id, nom, prenom);
		System.out.println("Nouveau valideur ajouté! " + valideur.toString());
		return valideur;
	}
}
