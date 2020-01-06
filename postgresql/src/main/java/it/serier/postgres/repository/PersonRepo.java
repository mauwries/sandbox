package it.serier.postgres.repository;

import org.springframework.data.repository.CrudRepository;

import it.serier.postgres.domain.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {

    Person findByName(final String name);
}
