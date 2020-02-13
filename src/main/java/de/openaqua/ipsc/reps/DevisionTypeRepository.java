package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.DevisionType;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface DevisionTypeRepository extends PagingAndSortingRepository<DevisionType, Long> {
	DevisionType findByName(String unit);

	DevisionType findById(long id);

	Iterable<DevisionType> findAllByOrderByNameAsc();

	Iterable<DevisionType> findAllByOrderByNameDesc();

	Page<DevisionType> findAllByOrderByNameAsc(Pageable pageable);

	Page<DevisionType> findAllByOrderByNameDesc(Pageable pageable);
}
