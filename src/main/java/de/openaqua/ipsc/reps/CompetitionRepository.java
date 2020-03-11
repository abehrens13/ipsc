package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Competition;
import de.openaqua.ipsc.entities.CompetitionType;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {
	public Optional<Competition> findById(String id);
	public List<Competition> findByCompetitionType(CompetitionType type);
}
