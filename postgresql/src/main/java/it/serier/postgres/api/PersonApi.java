package it.serier.postgres.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import it.serier.postgres.core.CoreService;
import it.serier.postgres.domain.Person;
import it.serier.postgres.repository.PersonRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/persons")
@AllArgsConstructor
@Api(value = "Dit is een value")
public class PersonApi {

    private CoreService service;

    @GetMapping
    public Iterable<Person> getAllPerson() {
        return service.getAllPersons();
    }

    @GetMapping("/{PERSON_NAME}")
    public String getPersonByName(@PathVariable("PERSON_NAME") final String name) {
        final Person foundPerson = service.findPersonByName(name);
        if (foundPerson != null) {
            return foundPerson.toString();
        }
        return "Nope no results for user " + name;
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        service.savePerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
