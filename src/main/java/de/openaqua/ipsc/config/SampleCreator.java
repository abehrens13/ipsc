package de.openaqua.ipsc.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.openaqua.ipsc.reps.ClubsRepository;
import de.openaqua.ipsc.reps.CompetitionRepository;
import de.openaqua.ipsc.reps.RegistrationsRepository;
import de.openaqua.ipsc.reps.ShootersRepository;

@Component
public class SampleCreator {
	Logger log = LoggerFactory.getLogger(SampleCreator.class);

	@Autowired
	CompetitionRepository repository;

	@Autowired
	ClubsRepository clubsRepository;

	@Autowired
	RegistrationsRepository regRep;

	@Autowired
	ShootersRepository shootersRep;

	SampleCreator() {
		super();
	}

	protected Date getDate(final String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			log.error(e.toString());
			return null;
		}
	}

	public void createSampleClubs() {
		// for later

	}

	public void createSampleCompetition() {
		// for later
	}

	public void createSampleRegistrations() {
		// for later
	}

	public void createSampleShooters() {
		// for later
	}

	public void deleteOldData() {
		log.info("deleteOldData()");
		shootersRep.deleteAll();
	}

	public void createSampleData() {
		log.info("createSampleData()");
		createSampleCompetition();
		createSampleClubs();
		createSampleRegistrations();
		createSampleShooters();
	}
}