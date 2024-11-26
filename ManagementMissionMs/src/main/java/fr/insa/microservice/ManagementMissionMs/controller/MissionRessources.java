package main.java.fr.insa.microservice.ManagementMissionMs.controller;

import java.util.List;

import main.java.fr.insa.microservice.ManagementMissionMs.Model.Mission;

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

    @PostMapping
	public Mission addMission(@RequestBody Mission m) {
		managementMissionSQL.addMission(m);
		return m;
	}

    @DeleteMapping(value = "/delete/{id}")
	public void deletePersonne(@PathVariable int idMission) {
        managementMissionSQL.deleteMission(idMission);
	}

    @PutMapping(value="assign/{idMission}")
    public void assignMission(@PathVariable int idMission,@RequestBody int idBenevole) {
        managementMissionSQL.assignMission(idMission,idBenevole);
	}

}
