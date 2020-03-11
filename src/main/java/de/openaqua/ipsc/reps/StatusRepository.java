package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Status;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface StatusRepository extends MongoRepository<Status, String> {
}
