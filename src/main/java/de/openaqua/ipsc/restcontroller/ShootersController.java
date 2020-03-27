package de.openaqua.ipsc.restcontroller;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.mail.EmailService;
import de.openaqua.ipsc.reps.ShootersRepository;

@RestController
@RequestMapping(path = "/api/shooters")
public class ShootersController extends AbstractIpscController<Shooter> {

	public ShootersController(ShootersRepository repository) {
		super(repository);

	}

	@Autowired
	ShootersRepository shootersRepository;

	@Autowired
	EmailService emailService;

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

	
	@Override
	@PostMapping(path = "/new", consumes = "application/json", produces = "application/json")
	@Transactional
	public Shooter createNewObject(@RequestBody Shooter in) {
		log.info("POST /new for email {}", in.email);

		// some tests
		if (in.email == null || in.email.length() == 0) {
			throw new IncompleteDataException("Shooter Data are incomplete: Missing Email");
		}
		if (shootersRepository.findShooterByEmail(in.email.toLowerCase()).isPresent()) {
			throw new IncompleteDataException("There is already a shooter with email address <" + in.email + ">");
		}
		if (!in.dsgvo) {
			throw new IncompleteDataException("DSGVO flag must be true");
		}

		// some preps and create new Shooter
		in.password = org.apache.commons.codec.digest.DigestUtils.sha256Hex(in.password);
		in.email = in.email.toLowerCase();
		in.dsgvo_date = Date.from(Instant.now());
		Shooter out = getRepository().save(in);
		log.debug("New Shooter with ID {} created", out.id);
		emailService.sendNewShooterRegistrationMail(out);
		return out;
	}

}