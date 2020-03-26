package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;
import de.openaqua.ipsc.entities.Shooter;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@Repository
public interface ShootersRepository extends MongoRepository<Shooter, String> {

	@Query(value = "{'email': ?0}")
	Optional<Shooter> findShooterByEmail(String email);

}
