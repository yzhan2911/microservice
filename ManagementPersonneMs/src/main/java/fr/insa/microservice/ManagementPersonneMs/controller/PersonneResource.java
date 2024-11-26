package fr.insa.microservice.ManagementPersonneMs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.microservice.ManagementPersonneMs.model.Personne;

@RestController
public class PersonneResource {
	public PersonnesControllerSQL personneControlle= new PersonnesControllerSQL();
	
	@GetMapping("/personnes")
	public List<Personne> getAllPersonne() {
		return personneControlle.getAllPersonnes();
	}
}
