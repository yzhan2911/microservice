package fr.insa.microservice.ManagementPersonneMs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneResource {
	@GetMapping("/personnes")
	public int getAllPersonne() {
		return 200;
	}
}
