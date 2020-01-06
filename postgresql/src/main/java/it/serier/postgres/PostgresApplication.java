package it.serier.postgres;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import it.serier.postgres.domain.Person;
import it.serier.postgres.repository.PersonRepo;

@SpringBootApplication
public class PostgresApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresApplication.class, args);
    }

    @Bean
    ApplicationRunner init(PersonRepo repository) {
        String[] data = { "Jan", "Klaas", "Joris", "Error" };
        return args -> {
            Stream.of(data)
                    .forEach(foundPerson -> {
                        Person person = new Person(foundPerson);
                        repository.save(person);
                    });
            repository.findAll()
                    .forEach(System.out::println);
        };
    }
}
