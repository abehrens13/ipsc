package de.openaqua.ipsc.restcontroller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.reps.ShootersRepository;

@RestController
@RequestMapping(path = "/api/shooters")
public class ShootersController extends IipscController<Shooter> {

	public ShootersController(ShootersRepository repository) {
		super(repository);

	}

	@Autowired
	ShootersRepository shootersRepository;

	@Override
	protected Shooter getNew() {
		return new Shooter();
	}

	@PostMapping(path = "/resetPassword", consumes = "application/json", produces = "application/json")
	public void resetPassword(@RequestBody @Valid Shooter in) {
		log.info("POST /resetPassword for {}", in);
		Optional<Shooter> out = shootersRepository.findShooterByEmail(in.email);

		if (out.isPresent()) {
			log.debug("Found Shooter: {}", out.get());
			log.error("don't know how to send Mail to {}", out.get().email);
		} else {
			log.error("POST /resetPassword: Shooter Not Found for Mail: {}", in.email);
		}
	}

}