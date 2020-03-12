package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;
import de.openaqua.ipsc.entities.Shooter;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ShootersRepository extends MongoRepository<Shooter, String> {
}
