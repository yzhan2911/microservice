package fr.insa.microservice.ManagementPersonneMs.controller;

import java.util.List;


import org.springframework.web.bind.annotation.*;
import fr.insa.microservice.ManagementPersonneMs.model.*;


@RestController
@RequestMapping("/personnes")
public class PersonneResource {
	public PersonnesControllerSQL personneControlle= new PersonnesControllerSQL();
	@GetMapping
	public List<Personne> getAllPersonne() {
		return personneControlle.getAllPersonnes();
	}

	@GetMapping(value = "/{idPersonne}")
	public Personne getPersonneById(@PathVariable int idPersonne) {
		return personneControlle.getPersonneById(idPersonne);
	}

	//roles: 1 demandeur, 2 benevole, 3 valideur
    @PostMapping(value = "/demandeur")
    public Personne addDemandeur(@RequestBody Personne demandeur) {
		demandeur.setRole("Demandeur");
        personneControlle.ajoutPersonne(demandeur);
        return demandeur;
    }
	
	@GetMapping(value="/demandeur")
	public List<Demandeur> getDemandeurs() {
		return personneControlle.getAllDemandeurs();
	}

	@PostMapping(value = "/benevole")
	public Personne addBenevole(@RequestBody Personne benevole) {
		benevole.setRole("Bénévole");
		personneControlle.ajoutPersonne(benevole);
		 return benevole;
	}

	@GetMapping(value="/benevole")
	public List<Benevole> getBenevoles() {
		return personneControlle.getAllBenevoles();
	}

	@PostMapping(value = "/valideur")
	public Personne addValideur(@RequestBody Personne valideur) {
		valideur.setRole("Valideur");
		 personneControlle.ajoutPersonne(valideur);
		 return valideur;
	}
	
	@GetMapping(value="/valideur")
	public List<Valideur> getValidateurs() {
		return personneControlle.getAllValideurs();
	}
	
	@PutMapping(value = "/setRole/{idPersonne}/{role}")
	public String setRole(@PathVariable int idPersonne,@PathVariable String role) {
		switch (role) {
        case "Demandeur":
        	 personneControlle.setRole(idPersonne, "Demandeur");
            break;
        case "Bénévole":
        	personneControlle.setRole(idPersonne, "Bénévole");
            break;
        case "Valideur":
        	 personneControlle.setRole(idPersonne, "Valideur");
            break;
        default:
            return "Rôle non valide : " + role;  
    }
		return "Bien modifié le rôle de idPersonne "+idPersonne +" à "+role;
		
	}
	

	@DeleteMapping(value = "/delete/{idPersonne}")
	public String deletePersonne(@PathVariable int idPersonne) {
		boolean isDeleted = personneControlle.supprimerPersonne(idPersonne);
		 if (isDeleted) {
			return "La mission avec ID " + idPersonne + " a été supprimée avec succès.";
		} else {
			return "Échec de la suppression. Aucune personne avec ID " + idPersonne + " n'a été trouvée.";
		}
		 
	}
}
