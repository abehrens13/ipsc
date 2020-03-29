package de.openaqua.ipsc.restcontroller;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.openaqua.ipsc.entities.LoginToken;
import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.mail.EmailService;
import de.openaqua.ipsc.reps.ShootersRepository;

@RestController
@RequestMapping(path = "/api/shooters")
public class ShootersController extends AbstractIpscController<Shooter> {
	Logger Log = LoggerFactory.getLogger(ShootersController.class);

	@Autowired
	private EmailService emailService;

	@Autowired
	private ShootersRepository shootersRepository;

	public ShootersController(ShootersRepository repository) {
		super(repository);

	}

	@Override
	public Shooter getNew() {
		return new Shooter();
	}

	@PostMapping(path = "?resetPassword", consumes = "application/json", produces = "application/json")
	public void resetPassword(@RequestBody @Valid Shooter in) {
		log.info("POST /resetPassword for {}", in);
		Optional<Shooter> out = shootersRepository.findShooterByEmail(in.getEmail());

		if (out.isPresent()) {
			log.debug("Found Shooter: {}", out.get());
			log.error("don't know how to send Mail to {}", out.get().getEmail());
		} else {
			log.error("POST /resetPassword: Shooter Not Found for Mail: {}", in.getEmail());
		}
	}

	@Override
	public ResponseEntity<Shooter> patch(String id, @Valid Shooter c) {
		Log.info("Patch Shooter for id {}", id);
		Shooter tmp = voidtestObjectId(id, c);
		if (!c.isDsgvo()) {
			throw new IncompleteDataException("DSGVO-Flat cannot be removed");
		}
		if (c.getAddress() != null) {
			// TODO: Patch for parts of address necessary?
			tmp.setAddress(c.getAddress());
		}

		if (!c.getAssociation().isEmpty()) {
			tmp.setAssociation(c.getAssociation());
		}
		if (c.getClubs() != null && !c.getClubs().isEmpty()) {
			// TODO: Patch for single clubs necessary?
			tmp.setClubs(c.getClubs());
		}
		if (c.getDsgvoDate() != null) {
			tmp.setDsgvoDate(c.getDsgvoDate());
		}
		if (!c.getEmail().isEmpty()) {
			tmp.setEmail(c.getEmail());
		}
		if (!c.getIpscLicence().isEmpty()) {
			tmp.setIpscLicence(c.getIpscLicence());
		}
		if (!c.getName().isEmpty()) {
			tmp.setName(c.getName());
		}
		if (!c.getCountry().isEmpty()) {
			tmp.setCountry(c.getCountry());
		}
		if (!c.getPassword().isEmpty()) {
			tmp.setPassword(makeHashedPassword(c.getPassword()));
		}
		if (c.getWeapons() != null && !c.getWeapons().isEmpty()) {
			// TODO: Patch for single weapons necessary?
			tmp.setWeapons(c.getWeapons());
		}
		return put(id, tmp);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Shooter> put(@PathVariable(value = "id") String id, @Valid @RequestBody Shooter in) {
		log.info("PUT existing Shooter with id {} ", id);

		// some tests
		if (in.getEmail() == null || in.getEmail().length() == 0) {
			throw new IncompleteDataException("Shooter Data are incomplete: Missing Email");
		}
		if (!in.isDsgvo()) {
			throw new IncompleteDataException("DSGVO flag must be true");
		}

		// some preps and create new Shooter
		in.setPassword(makeHashedPassword(in.getPassword()));
		in.setEmail(in.getEmail().toLowerCase());
		if (in.getDsgvoDate() == null) {
			in.setDsgvoDate(Date.from(Instant.now()));
		}
		return super.put(id, in);
	}

	@Override
	public ResponseEntity<Shooter> put(final @Valid @RequestBody Shooter in) {
		log.info("PUT /new for email {}", in.getEmail());

		// some tests
		if (in.getEmail() == null || in.getEmail().length() == 0) {
			throw new IncompleteDataException("Shooter Data are incomplete: Missing Email");
		}
		if (shootersRepository.findShooterByEmail(in.getEmail().toLowerCase()).isPresent()) {
			throw new IncompleteDataException("There is already a shooter with email address <" + in.getEmail() + ">");
		}
		if (!in.isDsgvo()) {
			throw new IncompleteDataException("DSGVO flag must be true");
		}

		// some preps and create new Shooter
		in.setPassword(makeHashedPassword(in.getPassword()));
		in.setEmail(in.getEmail().toLowerCase());
		in.setDsgvoDate(Date.from(Instant.now()));

		// store / create new user
		ResponseEntity<Shooter> out = super.put(in);
		log.debug("New Shooter with ID {} created", out.getBody().getId());

		// send email
		emailService.sendNewShooterRegistrationMail(out.getBody());

		return out;

	}

	private static String makeHashedPassword(final String in) {
		return org.apache.commons.codec.digest.DigestUtils.sha256Hex(in);
	}

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginToken login(@RequestBody @Valid Shooter in) {
		log.info("GET /login for email {}", in.getEmail());

		// some tests
		if (in.getEmail() == null || in.getEmail().isEmpty()) {
			throw new IncompleteDataException("Shooter Data are incomplete: Missing Email");
		}

		Optional<Shooter> out = shootersRepository.findShooterByEmail(in.getEmail().toLowerCase());
		if (!out.isPresent()) {
			throw new IncompleteDataException("Either Email or Password is incorrect");
		}
		if (!makeHashedPassword(in.getPassword()).equals(out.get().getPassword())) {
			throw new IncompleteDataException("Either Email or Password is incorrect");
		}

		return new LoginToken(out.get().getId());
	}

}