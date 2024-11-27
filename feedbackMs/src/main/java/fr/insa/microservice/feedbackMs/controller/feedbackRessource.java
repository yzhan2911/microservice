package fr.insa.microservice.feedbackMs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public void valideMission(@PathVariable int idMission) {
        feedbackSQL.valideMission(idMission);
	}

    @PutMapping(value="refuse/{idMission}")
    public void refuseMission(@PathVariable int idMission,@RequestBody String comment) {
        feedbackSQL.refuseMission(idMission,comment);
	}

    @PutMapping(value="setAvis/{idMission}")
    public void setAvis(@PathVariable int idMission,@RequestBody String comment) {
        feedbackSQL.setAvis(idMission,comment);
	}
}
