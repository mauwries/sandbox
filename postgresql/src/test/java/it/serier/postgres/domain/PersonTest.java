package it.serier.postgres.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PersonTest {

    private Person sut;

    @Test
    public void should_set_and_get_correct_name() {
        final String personName = "testName";

        sut = new Person(personName);

        assertThat(sut.getName()).isEqualTo(personName);
    }

}
