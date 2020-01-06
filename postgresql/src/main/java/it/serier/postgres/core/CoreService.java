package it.serier.postgres.core;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import it.serier.postgres.domain.Person;
import it.serier.postgres.repository.ChildRepo;
import it.serier.postgres.repository.PersonRepo;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class CoreService {

    private final PersonRepo personRepo;

    private final ChildRepo childRepo;

    public Person findPersonByName(String name){
        return personRepo.findByName(name);
    }

    public List<Person> getAllPersons(){
        return (List<Person>) personRepo.findAll();
    }

    public Person savePerson(Person personToSave){
        return personRepo.save(personToSave);
    }

}
