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
import de.openaqua.ipsc.entities.Country;
import de.openaqua.ipsc.reps.CountryRepository;

@RestController
@RequestMapping(path = "/api/countries")
public class ContryRestController {
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CountryRepository repository;

	@GetMapping("/")
	public Iterable<Country> index() {
		return repository.findAllByOrderByCodeAsc();

	}

	@GetMapping("/byId/{id}")
	public Country byId(@PathVariable final long id) {
		return repository.findById(id);
	}

	@GetMapping("/byCode/{code}")
	public Country byId(@PathVariable final String unit) {
		return repository.findByCode(unit);
	}

	// delete
	@GetMapping("/deleteCountry/{id}")
	public void delCountry(@PathVariable final long id) {
		repository.deleteById(id);
	}

	@GetMapping("/newCountry")
	public Country newCountry(final Model model) {
		return new Country();
	}

	@PostMapping("/newCountry")
	public Country newCountry(@RequestBody Country c) {
		return repository.save(c);
	}
}