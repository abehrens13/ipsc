package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Club;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ClubsRepository extends MongoRepository<Club, String> {
	public Optional<Club> findById(String id);
}
