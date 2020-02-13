package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Competition;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface CompetitionsRepository extends PagingAndSortingRepository<Competition, Long> {
	Competition findByName(String unit);

	Competition findById(long id);

	Iterable<Competition> findAllByOrderByNameAsc();

	Iterable<Competition> findAllByOrderByNameDesc();

	Page<Competition> findAllByOrderByNameAsc(Pageable pageable);

	Page<Competition> findAllByOrderByNameDesc(Pageable pageable);
}
