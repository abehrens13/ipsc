package de.openaqua.ipsc.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.openaqua.ipsc.beans.SerialGenerator;
import de.openaqua.ipsc.entities.Country;
import de.openaqua.ipsc.entities.CountryJSON;
import de.openaqua.ipsc.reps.CountryRepository;

@RestController
@RequestMapping(path = "/api/countries")
public class ContryRestController {
	private static final Log LOG = LogFactory.getLog(ContryRestController.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	SerialGenerator serialGenerator;

	@Autowired
	CountryRepository repository;

	@GetMapping("/")
	public Iterable<Country> index() {
		LOG.debug("GET /");
		return repository.findAllByOrderByCodeAsc();

	}

	@GetMapping("/byId/{id}")
	public Country byId(@PathVariable final long id) {
		LOG.debug("/byId/{id}");
		return repository.findById(id);
	}

	@GetMapping("/byCode/{code}")
	public Country byId(@PathVariable final String unit) {
		LOG.debug("GET /byCode/");
		return repository.findByCode(unit);
	}

	// delete
	@GetMapping("/deleteCountry/{id}")
	public void delCountry(@PathVariable final long id) {
		LOG.debug("/deleteCountry " + id);
		repository.deleteById(id);
		// TODO: what to return?
		// return "redirect:/countries";
	}

	@DeleteMapping("/deleteCountry/{id}")
	public Map<String, Boolean> deleteCountry(@PathVariable(value = "id") Long id) throws NoSuchCountryException {

		Country c = repository.findById(id)
				.orElseThrow(() -> new NoSuchCountryException("Country not found for this ID: " + id));
		repository.delete(c);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
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