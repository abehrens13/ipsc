package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Country;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
	Country findByCode(String code);

	Country findById(long id);

	Iterable<Country> findAllByOrderByCodeAsc();

	Iterable<Country> findAllByOrderByCodeDesc();

	Page<Country> findAllByOrderByCodeAsc(Pageable pageable);

	Page<Country> findAllByOrderByCodeDesc(Pageable pageable);
}
