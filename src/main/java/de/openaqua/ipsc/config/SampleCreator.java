package de.openaqua.ipsc.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.entities.Club;
import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.entities.Registration;
import de.openaqua.ipsc.entities.Shooter;
import de.openaqua.ipsc.entities.Weapon;
import de.openaqua.ipsc.reps.ClubsRepository;
import de.openaqua.ipsc.reps.CompetitionRepository;
import de.openaqua.ipsc.reps.RegistrationsRepository;
import de.openaqua.ipsc.reps.ShootersRepository;
import de.openaqua.ipsc.types.CompetitionType;
import de.openaqua.ipsc.types.DevisionType;
import de.openaqua.ipsc.types.OpenType;
import de.openaqua.ipsc.types.PowerFactorType;

@Component
public class SampleCreator {
	Logger log = LoggerFactory.getLogger(SampleCreator.class);

	@Autowired
	CompetitionRepository repository;

	@Autowired
	ClubsRepository clubsRepository;

	SampleCreator() {
		super();
	}

	protected Date getDate(final String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void createSampleClubs() {
		Club a = new Club();
		a.name = "High Noon Bonn";
		a.website = "https://www.google.com";
		a.email = "sample@boom.com";
		a.address.setStreet("Shooters Street 1");
		a.address.setCity("Bonn");
		a.address.setCountry("DE");
		a.address.setPostCode("12456");
		clubsRepository.save(a);

		a.id = null;
		a.name = "High Noon Guests";
		clubsRepository.save(a);

		a.id = null;
		a.name = "Black Gun";
		a.address.setStreet("Shooters Street 1");
		a.address.setCity("Heidenau");
		a.address.setCountry("DE");
		a.address.setPostCode("65432");
		clubsRepository.save(a);

	}

	public void createSampleCompetition() {

	}

	@Autowired
	RegistrationsRepository regRep;

	public void createSampleRegistrations() {
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));
		regRep.save(new Registration("shooterSampleId", "competitionSampleId"));

	}

	public void run(String... args) throws Exception {

	}

	@Autowired
	ShootersRepository shootersRep;

	public void createSampleShooters() {
	}

	public void createSampleData() {
		shootersRep.deleteAll();
		createSampleCompetition();
		createSampleClubs();
		createSampleRegistrations();
		createSampleShooters();
	}

}