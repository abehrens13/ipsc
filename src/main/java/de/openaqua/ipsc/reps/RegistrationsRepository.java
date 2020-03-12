package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;
import de.openaqua.ipsc.entities.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface RegistrationsRepository extends MongoRepository<Registration, String> {
}
