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
		List<DevisionType> standard = new ArrayList<>();
		standard.add(DevisionType.CLASSIC);
		standard.add(DevisionType.STANDARD);
		standard.add(DevisionType.RIMFIRE);

		List<DevisionType> production = new ArrayList<>();
		production.add(DevisionType.PRODUCTION);
		production.add(DevisionType.PRODUCTION_OPTICS);

		Competition test = new Competition();
		test.berths = 80;
		test.bulletCounts = 120;
		test.competitionType = CompetitionType.IPSCHandgun;
		test.country = "DE";
		test.dateStart = getDate("2020-01-01");
		test.dateEnd = getDate("2020-01-02");
		test.devisionType = standard;
		test.level = "1";
		test.openFor = OpenType.INTERNATIONAL;
		test.regOpen = getDate("2019-12-01");
		test.regClose = getDate("2019-12-31");
		test.title = "Ready for Beginners";
		repository.save(test);

		test.title = "Ready for Advanced";
		test.devisionType = production;

		repository.save(test);
		repository.save(test);
		repository.save(test);
		repository.save(test);
		repository.save(test);
		repository.save(test);
		repository.save(test);
		repository.save(test);

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
		Shooter a = new Shooter();
		a.country = "DE";
		a.address.setCity("Bonn");
		a.address.setCountry("DE");
		a.address.setPostCode("12456");
		a.email = "foo@nowhere.com";
		a.name = "Tom Sawyer";
		a.password = "xxx";
		a.ipscLicence = "1241231";

		Weapon b = new Weapon();
		b.setCaliber("9mm Luger");
		b.setGunType("Walther PPQ Q4");
		b.setPowerFactor(PowerFactorType.MINOR);
		b.setPrefDevisionType(DevisionType.PRODUCTION_OPTICS);
		b.setSerialNumber("ABC01234");

		a.weapons.add(b);

		shootersRep.save(a);

		a.id = null;
		a.name = "User Name";
		a.email = "foobar@openaqua.de";
		shootersRep.save(a);
	}

	public void createSampleData() {
		shootersRep.deleteAll();
		createSampleCompetition();
		createSampleClubs();
		createSampleRegistrations();
		createSampleShooters();
	}

}