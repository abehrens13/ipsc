package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;
import de.openaqua.ipsc.entities.CompetitionType;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompetitionTypeRepository extends MongoRepository<CompetitionType, String> {
}
