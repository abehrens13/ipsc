package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Shooter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface ShooterRepository extends PagingAndSortingRepository<Shooter, Long> {
	Shooter findByUsername(String code);

	Shooter findById(long id);

	Iterable<Shooter> findAllByOrderByLastnameAsc();

	Iterable<Shooter> findAllByOrderByLastnameDesc();

	Iterable<Shooter> findAllByOrderByUsernameAsc();

	Iterable<Shooter> findAllByOrderByUsernameDesc();

	Page<Shooter> findAllByOrderByLastnameAsc(Pageable pageable);

	Page<Shooter> findAllByOrderByLastnameDesc(Pageable pageable);

	Page<Shooter> findAllByOrderByUsernameAsc(Pageable pageable);

	Page<Shooter> findAllByOrderByUsernameDesc(Pageable pageable);
}
