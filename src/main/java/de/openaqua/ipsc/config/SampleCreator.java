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
import de.openaqua.ipsc.entities.CompetitionType;
import de.openaqua.ipsc.entities.CountryType;
import de.openaqua.ipsc.entities.DevisionType;
import de.openaqua.ipsc.entities.OpenType;
import de.openaqua.ipsc.reps.ClubsRepository;
import de.openaqua.ipsc.reps.CompetitionRepository;

@Component
public class SampleCreator {
	Logger LOG = LoggerFactory.getLogger(SampleCreator.class);

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
		a.address.street = "Shooters Street 1";
		a.address.city = "Bonn";
		a.address.postCode = "12345";
		a.address.country = CountryType.DE;
		clubsRepository.save(a);

		a.id = null;
		a.name = "High Noon Guests";
		clubsRepository.save(a);

		a.id = null;
		a.name = "Black Gun";
		a.address.city = "Heidenau";
		a.address.postCode = "45678";
		clubsRepository.save(a);

	}

	public void createSampleCompetition() {
		List<DevisionType> standard = new ArrayList<DevisionType>();
		standard.add(DevisionType.CLASSIC);
		standard.add(DevisionType.STANDARD);
		standard.add(DevisionType.RIMFIRE);

		List<DevisionType> production = new ArrayList<DevisionType>();
		production.add(DevisionType.PRODUCTION);
		production.add(DevisionType.PRODUCTION_OPTICS);

		Competition test = new Competition();
		test.berths = 80;
		test.bulletCounts = 120;
		test.competitionType = CompetitionType.IPSCHandgun;
		test.country = CountryType.DE;
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

	public void run(String... args) throws Exception {

	}

	public void createSampleData() {
		createSampleCompetition();
		createSampleClubs();
	}

}