package de.openaqua.ipsc.restcontroller;

import java.util.Optional;

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
	public Optional<Status> byId(@PathVariable final String id) {
		return repository.findById(id);
	}

}