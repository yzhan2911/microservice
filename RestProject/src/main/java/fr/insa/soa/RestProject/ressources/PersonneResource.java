package fr.insa.soa.RestProject.ressources;


import java.util.ArrayList;
import java.util.List;

import fr.insa.soa.RestProject.Benevole;
import fr.insa.soa.RestProject.Demandeur;
import fr.insa.soa.RestProject.Personne;
import fr.insa.soa.RestProject.Valideur;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("personne")
public class PersonneResource {
	private static List<Personne> personnes = new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Personne> getAllPersonne() {
		return personnes;
	}

	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Personne getPersonneById(@PathParam("id") int id) {
		for (Personne personne : personnes) {
            if (personne.getId() == id) {
                return personne; //  
            }
        }
        return null;  
	}
	
	@POST
    @Path("/demandeur")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)  
    public Demandeur addDemandeur(Demandeur p ) {
        personnes.add(p);
        System.out.println("Adding Demandeur to list: " + p);

        return p;
    }

    @POST
    @Path("/Valideur")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)  
    public Valideur addValidateur(Valideur p) {
         personnes.add(p);
         System.out.println("Adding Valideur to list: " + p);

         return p;
    }

    @POST
    @Path("/benevole")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)  
    public Benevole addBenevole( Benevole p) {
         personnes.add(p);
         System.out.println("Adding Benevole to list: " + p);
         return p;
    }
    
	@DELETE
	@Path("{id}")
	public void deletePersonne(@PathParam("id") int id) {
		String message="Personne non trouvée"; 
		for (Personne personne : personnes) {
            if (personne.getId() == id) {
            	if (personnes.remove(personne)) {
            		message="Personne supprimé!!";
            		break;
            	}else {
            		message="Supprime avec erreur";
            		break;
            	}
            }
        }
		System.out.println(message);
	}
}
