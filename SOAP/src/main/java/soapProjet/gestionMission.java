package soapProjet;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
@WebService(serviceName = "GestionMission")
public class gestionMission {

	@WebMethod(operationName="addMission")
	public missionAide addMission(@WebParam(name="idMission")String id, @WebParam(name="demandeur")user demandeur) {
		missionAide mission = new missionAide(id, demandeur);
		mission.StateInitiale();
		mission.toString();
		return mission;
	}
	
	@WebMethod(operationName="valideMission")
	public void ValideMission(@WebParam(name="mission")missionAide mission) {
		mission.StateValide();
		mission.toString();
	}
	
	@WebMethod(operationName="refuseMission")
	public void RefuseMission(@WebParam(name="mission")missionAide mission,@WebParam(name="commentaire")String commentaire) {
		mission.StateRefuse();
		mission.setComment(commentaire);
		mission.toString();
	}

}
