package de.openaqua.ipsc.restcontroller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.openaqua.ipsc.entities.Competition;

@RestController
@RequestMapping(path = "/api/competitions")
public class CompetitionsController extends AbstractIpscController<Competition> {

	public CompetitionsController(MongoRepository<Competition, String> repository) {
		super(repository);
	}

	@Override
	protected Competition getNew() {
		return new Competition();
	}

}