package it.serier.postgres.domain;

import static javax.persistence.GenerationType.AUTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Person {

    public Person(){
        this.name = "dummie";
    }

    public Person(String name){
        this.name=name;
    }

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    private final String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Child> children;
}

