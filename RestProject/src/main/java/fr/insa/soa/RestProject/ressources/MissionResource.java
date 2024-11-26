package fr.insa.soa.RestProject.ressources;

import java.util.ArrayList;
import java.util.List;

import fr.insa.soa.RestProject.Mission;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("mission")
public class MissionResource {
private static List<Mission> missions = new ArrayList<>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Mission> getAllMission() {
		return missions;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Mission getMissionById(@PathParam("id") int id) {
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
                return mission;  
            }
        }
        return null;  
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Mission addMission(Mission m) {
		missions.add(m);
		m.StateInitiale();
		return m;
	}
	
	@DELETE
	@Path("{id}")
	public void deleteMission(@PathParam("id") int id) {
		String message="Mission non trouvée"; 
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
            	if (missions.remove(mission)) {
            		message ="Mission supprimée!";
            		break;
            	}else {
            		message="Supprime avec erreur";
            		break;
            	}
            }   
		}
		System.out.println(message);
	}
	
	@PUT
	@Path("{id}/valide")
	@Consumes(MediaType.APPLICATION_JSON)
	public void valideMission(@PathParam("id") int id) {
		String message="Mission non trouvée"; 
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
            	mission.StateValide();
            	message="Mission validée!";
            		break;
            	}
            }   
		System.out.println(message);
	}
	
	@PUT
	@Path("{id}/refuse")
	@Consumes(MediaType.APPLICATION_JSON)
	public void refuseMission(@PathParam("id") int id,@PathParam("motif") String  motif) {
		String message="Mission non trouvée"; 
		for (Mission mission : missions) {
            if (mission.getIdmission() == id) {
            	mission.StateRefuse();
            	message="Mission refusé!";
            	mission.setComment(motif);
            		break;
            	}
            }   
		System.out.println(message);
	}
	
	 
	@PUT
	@Path("{id}/setAvis")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void setCommentaire(@PathParam("id") int id, String avis) {
	    for (Mission mission : missions) {
	        if (mission.getIdmission() == id) {
	            mission.setComment(avis);
	            mission.StateTermine();
	           
	        }
	    }
	    
	}

}
