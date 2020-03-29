package de.openaqua.ipsc.restcontroller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Registration;
import de.openaqua.ipsc.reps.RegistrationsRepository;


@RestController
@RequestMapping(path = "/api/registrations")
public class RegistrationsController extends AbstractIpscController<Registration> {
	public RegistrationsController(RegistrationsRepository repository){
		super(repository);
		
	}

	@Override
	public Registration getNew() {
		return new Registration();
	}

	@Override
	public ResponseEntity<Registration> patch(String id, @Valid Registration c) {
		throw new NotImplementedException("patch(String id, @Valid Club c) ");
	}

}