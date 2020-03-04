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
import de.openaqua.ipsc.entities.Status;
import de.openaqua.ipsc.reps.StatusRepository;

@RestController
@RequestMapping(path = "/api/statuses")
public class StatusRestController {

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	StatusRepository repository;

	@GetMapping("/")
	public Iterable<Status> index() {
		return repository.findAll();

	}

	@GetMapping("/byId/{id}")
	public Status byId(@PathVariable final long id) {
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
	public Status newCompetition(@RequestBody Status c) {
		return repository.save(c);
	}

}