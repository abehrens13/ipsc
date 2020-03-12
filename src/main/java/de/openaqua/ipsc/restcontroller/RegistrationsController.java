package de.openaqua.ipsc.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Registration;
import de.openaqua.ipsc.reps.RegistrationsRepository;


@RestController
@RequestMapping(path = "/api/registrations")
public class RegistrationsController extends IIpscController<Registration> {
	Logger LOG = LoggerFactory.getLogger(RegistrationsController.class);

	public RegistrationsController(RegistrationsRepository repository){
		super(repository);
		
	}

	@Override
	public Registration getNew() {
		return new Registration();
	}

}