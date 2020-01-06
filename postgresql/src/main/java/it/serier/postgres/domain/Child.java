package it.serier.postgres.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Child {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Integer id;

    private final String name;

}
