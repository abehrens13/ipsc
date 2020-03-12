package de.openaqua.ipsc.restcontroller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Club;

@RestController
@RequestMapping(path = "/api/clubs")
public class ClubsController extends IIpscController<Club> {

	public ClubsController(MongoRepository<Club, String> repository) {
		super(repository);
	}

	@Override
	protected Club getNew() {
		return new Club();
	}

}