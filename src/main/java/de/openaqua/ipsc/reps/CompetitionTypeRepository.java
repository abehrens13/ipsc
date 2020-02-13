package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.CompetitionType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface CompetitionTypeRepository extends PagingAndSortingRepository<CompetitionType, Long> {
	CompetitionType findByName(String unit);

	CompetitionType findById(long id);

	Iterable<CompetitionType> findAllByOrderByNameAsc();

	Iterable<CompetitionType> findAllByOrderByNameDesc();

	Page<CompetitionType> findAllByOrderByNameAsc(Pageable pageable);

	Page<CompetitionType> findAllByOrderByNameDesc(Pageable pageable);
}
