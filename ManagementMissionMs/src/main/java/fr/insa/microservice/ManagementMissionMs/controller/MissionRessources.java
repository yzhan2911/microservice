package fr.insa.microservice.ManagementMissionMs.controller;


import java.util.List;

import org.springframework.web.bind.annotation.*;
import fr.insa.microservice.ManagementMissionMs.model.Mission;


@RestController
@RequestMapping("/missions")
public class MissionRessources {

    @GetMapping
	public List<Mission> getAllMission() {
		return managementMissionSQL.getAllMission();
	}

    @GetMapping(value = "/{idMission}")
	public Mission getMissionById(@PathVariable int idMission) {
		return managementMissionSQL.getMissionById(idMission);
	} 

	//idMission , idDemandeur et description sont suffit
    @PostMapping
	public Mission addMission(@RequestBody Mission m) {
		managementMissionSQL.addMission(m);
		return m;
	}

    @DeleteMapping(value = "/delete/{idMission}")
	public String deleteMission(@PathVariable int idMission) {
        boolean isDeleted = managementMissionSQL.deleteMission(idMission);
		if (isDeleted) {
			return "La mission avec ID " + idMission + " a été supprimée avec succès.";
		} else {
			return "Échec de la suppression. Aucune mission avec ID " + idMission + " n'a été trouvée.";
		}
	}


    @PutMapping(value="assign/{idMission}/{idBenevole}")
    public String assignMission(@PathVariable int idMission,@PathVariable int idBenevole) {
        boolean isAssigned =  managementMissionSQL.assignMission(idMission,idBenevole);
		if (isAssigned) {
			return "La mission avec ID " + idMission + " a été assigné à bénévole "+idBenevole+".";
		} else {
			return "Assignement échec !";
		}
	}

}
