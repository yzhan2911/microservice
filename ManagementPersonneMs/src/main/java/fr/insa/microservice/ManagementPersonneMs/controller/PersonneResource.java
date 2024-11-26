package fr.insa.microservice.ManagementPersonneMs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.insa.microservice.ManagementPersonneMs.model.Personne;

@RestController
public class PersonneResource {
	public PersonnesControllerSQL personneControlle= new PersonnesControllerSQL();
	
	@GetMapping("/personnes")
	public List<Personne> getAllPersonne() {
		return personneControlle.getAllPersonnes();
	}

	@GetMapping(value = "/personne/{id}")
	public Personne getPersonneById(@PathVariable int id) {
		return personneControlle.getPersonneById(id);
	}

	//1 demandeur, 2 benevole, 3 valideur
	@PostMapping(value = "/addDemandeur/{id}")
	public void addDemandeur(@PathVariable int id) {
		 personneControlle.setRole(id, 1);
	}

	@PostMapping(value = "/addBenevole/{id}")
	public void addBenevole(@PathVariable int id) {
		 personneControlle.setRole(id, 2);
	}

	@PostMapping(value = "/addValidatuer/{id}")
	public void addValidatuer(@PathVariable int id) {
		 personneControlle.setRole(id, 3);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void deletePersonne(@PathVariable int id) {
		 personneControlle.supprimerPersonne(id);
	}


// deletePersonne

}
