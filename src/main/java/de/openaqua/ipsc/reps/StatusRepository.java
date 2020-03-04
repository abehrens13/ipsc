package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Status;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
	Status findById(long id);
}
