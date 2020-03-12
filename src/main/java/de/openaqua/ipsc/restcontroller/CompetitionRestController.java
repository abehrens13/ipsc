package de.openaqua.ipsc.restcontroller;

import java.util.Date;
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
import de.openaqua.ipsc.entities.CompetitionType;
import de.openaqua.ipsc.entities.CountryType;
import de.openaqua.ipsc.entities.DevisionType;
import de.openaqua.ipsc.reps.CompetitionRepository;

@RestController
@RequestMapping(path = "/api/competitions")
public class CompetitionRestController {
	Logger LOG = LoggerFactory.getLogger(CompetitionRestController.class);
	
	
	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	CompetitionRepository repository;

	@GetMapping("/")
	public List<Competition> index() {
		LOG.debug("index()");
		return repository.findAll();

	}

	@GetMapping("/byId/{id}")
	public Optional<Competition> byId(@PathVariable final String id) {
		return repository.findById(id);
	}

	// delete
	@GetMapping("/deleteCompetition/{id}")
	public void delCompetition(@PathVariable final String id) {
		repository.deleteById(id);
	}

	@GetMapping("/newCompetition")
	public Competition newCompetition() {
		return new Competition();
	}

	@PostMapping("/newCompetition")
	public Competition newCompetition(@RequestBody Competition c) {
		return repository.save(c);
	}

	@GetMapping("/newSample")
	public Competition newSampleCompetition() {
		LOG.info("newSampleCompetition()");
		Competition test = new Competition();
		test.setBulletCounts(50);
		test.setCompetitionType(CompetitionType.IPSCHandgun);
		test.setCountry(CountryType.DE);
		test.setDateEnd( new Date());
		test.setDateStart( new Date());
		test.setDevisionType(DevisionType.OPEN);
		test.setLevel("1");
		test.setLoad_Factor(50);
		test.setRegClose(new Date());
		test.setRegOpen(new Date());
		test.setStages(4);
		test.setTitle("Ganz am Anfang");
		LOG.info("new Sample=()"+test.toString());
		return repository.save(test);
	}

}