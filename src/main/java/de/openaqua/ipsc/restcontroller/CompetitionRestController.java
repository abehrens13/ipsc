package de.openaqua.ipsc.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.reps.CompetitionRepository;

@RestController
@RequestMapping(path = "/api/competitions")
public class CompetitionRestController {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CompetitionRepository repository;

	@GetMapping("/")
	public Iterable<Competition> index() {
		return repository.findAllByOrderByDateStartAsc();

	}

	@GetMapping("/byId/{id}")
	public Competition byId(@PathVariable final long id) {
		return repository.findById(id);
	}

	// delete
	@GetMapping("/deleteCompetition/{id}")
	public void delCompetition(@PathVariable final long id) {
		repository.deleteById(id);
	}

	@GetMapping("/newCompetition")
	public Competition newCompetition(final Model model) {
		return new Competition();
	}

	@PostMapping("/newCompetition")
	public Competition newCompetition(@RequestBody Competition c) {
		return repository.save(c);
	}

}