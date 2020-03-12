package de.openaqua.ipsc.restcontroller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Club;
import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.reps.ClubsRepository;


@RestController
@RequestMapping(path = "/api/clubs")
public class ClubController {
	Logger LOG = LoggerFactory.getLogger(ClubController.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	ClubsRepository repository;

	@GetMapping("/")
	public List<Club> index() {
		LOG.debug("index()");
		return repository.findAll();

	}

	@GetMapping("/byId/{id}")
	public Optional<Club> byId(@PathVariable final String id) {
		return repository.findById(id);
	}

	// delete
	@GetMapping("/delete/{id}")
	public void delCompetition(@PathVariable final String id) {
		repository.deleteById(id);
	}

	@GetMapping("/new")
	public Competition newCompetition() {
		return new Competition();
	}

	@PostMapping("/new")
	public Club newCompetition(@RequestBody Club c) {
		return repository.save(c);
	}

}