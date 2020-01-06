package it.serier.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.serier.postgres.domain.Child;

public interface ChildRepo extends JpaRepository<Child, Long> {

    Child findByName(String name);
}
