package fr.insa.microservice.ManagementPersonneMs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.microservice.ManagementPersonneMs.model.Benevole;
import fr.insa.microservice.ManagementPersonneMs.model.Demandeur;
import fr.insa.microservice.ManagementPersonneMs.model.Personne;
import fr.insa.microservice.ManagementPersonneMs.model.Valideur;

@RestController
@RequestMapping("/personnes")
public class PersonneResource {
	public PersonnesControllerSQL personneControlle= new PersonnesControllerSQL();
	@GetMapping
	public List<Personne> getAllPersonne() {
		return personneControlle.getAllPersonnes();
	}

	@GetMapping(value = "/{id}")
	public Personne getPersonneById(@PathVariable int id) {
		return personneControlle.getPersonneById(id);
	}

	//roles: 1 demandeur, 2 benevole, 3 valideur
	@PostMapping(value = "/demandeur")
	public Personne addDemandeur(@RequestBody Personne P) {
		 P.setRole(1);
		 personneControlle.ajoutPersonne(P);
		 return P;
	}
	
	@GetMapping(value="/demandeur")
	public List<Demandeur> getDemandeurs() {
		return personneControlle.getAllDemandeurs();
	}

	@PostMapping(value = "/benevole")
	public Personne addBenevole(@RequestBody Personne P) {
		P.setRole(2);
		 personneControlle.ajoutPersonne(P);
		 return P;
	}
	@GetMapping(value="/benevole")
	public List<Benevole> getBenevoles() {
		return personneControlle.getAllBenevoles();
	}


	@PostMapping(value = "/valideur")
	public Personne addValideur(@RequestBody Personne P) {
		P.setRole(3);
		 personneControlle.ajoutPersonne(P);
		 return P;
	}
	
	@GetMapping(value="/valideur")
	public List<Valideur> getValidateurs() {
		return personneControlle.getAllValideurs();
	}
	
	@PutMapping(value = "/setRole/{id}/{role}")
	public Personne setRole(@PathVariable int id,@PathVariable String role) {
		switch (role) {
        case "demandeur":
        	 personneControlle.setRole(id, 1);
            break;
        case "benevole":
        	personneControlle.setRole(id, 2);
            break;
        case "valideur":
        	 personneControlle.setRole(id, 3);
            break;
        default:
            System.out.println("Rôle non valide : " + role);
            return personneControlle.getPersonneById(id);  
    }
		return personneControlle.getPersonneById(id);
		
	}
	

	@DeleteMapping(value = "/delete/{id}")
	public void deletePersonne(@PathVariable int id) {
		 personneControlle.supprimerPersonne(id);
	}
}
