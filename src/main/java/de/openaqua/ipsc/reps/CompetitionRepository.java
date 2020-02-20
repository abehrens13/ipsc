package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Competition;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CompetitionRepository extends CrudRepository<Competition, Long> {
	Competition findById(long id);
	Iterable<Competition> findAllByOrderByDateStartAsc();
}
