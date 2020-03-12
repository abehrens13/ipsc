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
import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.entities.Weapon;
import de.openaqua.ipsc.reps.CompetitionRepository;
import de.openaqua.ipsc.reps.WeaponsRepository;

@RestController
@RequestMapping(path = "/api/weapons")
public class WeaponRestController {
	Logger LOG = LoggerFactory.getLogger(WeaponRestController.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	WeaponsRepository repository;

	@GetMapping("/")
	public List<Weapon> index() {
		LOG.debug("index()");
		return repository.findAll();

	}

	@GetMapping("/byId/{id}")
	public Optional<Weapon> byId(@PathVariable final String id) {
		return repository.findById(id);
	}

	
}