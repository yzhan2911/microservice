package fr.insa.microservice.feedbackMs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import fr.insa.microservice.feedbackMs.model.feedback;

@RestController
@RequestMapping("/feedback")
public class feedbackRessource {
	@Autowired
	private RestTemplate restTemplate;

    @GetMapping
	public List<feedback> getAllComments() {
		return feedbackSQL.getAllComments();
	}

    @PutMapping(value="valide/{idMission}")
    public String valideMission(@PathVariable int idMission) {
        feedbackSQL.valideMission(idMission);
        return "Mission "+idMission+" a été validé";
	}

    @PutMapping(value="refuse/{idMission}/{comment}")
    public feedback refuseMission(@PathVariable int idMission,@PathVariable String comment) {
        return feedbackSQL.refuseMission(idMission,comment);
	}

    @PutMapping(value="setAvis/{idMission}/{comment}")
    public feedback setAvis(@PathVariable int idMission,@PathVariable String comment) {
        return feedbackSQL.setAvis(idMission,comment);
	}
}
