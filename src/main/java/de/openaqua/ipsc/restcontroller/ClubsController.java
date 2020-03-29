package de.openaqua.ipsc.restcontroller;

import javax.validation.Valid;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Club;

@RestController
@RequestMapping(path = "/api/clubs")
public class ClubsController extends AbstractIpscController<Club> {

	public ClubsController(MongoRepository<Club, String> repository) {
		super(repository);
	}

	@Override
	protected Club getNew() {
		return new Club();
	}

	@Override
	public ResponseEntity<Club> patch(String id, @Valid Club c) {
		throw new NotImplementedException("patch(String id, @Valid Club c) ");
	}

}