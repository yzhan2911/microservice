package fr.insa.microservice.ManagementMissionMs.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.microservice.ManagementMissionMs.model.Mission;


@RestController
@RequestMapping("/missions")
public class MissionRessources {

    @GetMapping
	public List<Mission> getAllMission() {
		return managementMissionSQL.getAllMission();
	}

    @GetMapping(value = "/{id}")
	public Mission getMissionById(@PathVariable int id) {
		return managementMissionSQL.getMissionById(id);
	} 

	//idMission , idDemandeur et description sont suffit
    @PostMapping
	public Mission addMission(@RequestBody Mission m) {
		managementMissionSQL.addMission(m);
		return m;
	}

    @DeleteMapping(value = "/delete/{idMission}")
	public void deleteMission(@PathVariable int idMission) {
        managementMissionSQL.deleteMission(idMission);
	}


    @PutMapping(value="assign/{idMission}/{idBenevole}")
    public void assignMission(@PathVariable int idMission,@PathVariable int idBenevole) {
        managementMissionSQL.assignMission(idMission,idBenevole);
	}

}
