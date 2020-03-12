package de.openaqua.ipsc.reps;

import org.springframework.stereotype.Repository;

import de.openaqua.ipsc.entities.Weapon;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface WeaponsRepository extends MongoRepository<Weapon, String> {
}