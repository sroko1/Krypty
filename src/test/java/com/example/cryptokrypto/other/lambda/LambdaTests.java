package com.example.cryptokrypto.other.lambda;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTests {

    @Test
    void filteringTest() {
        var persons = List.of(
                new Person("maniek", "p.", 20),
                new Person("olaf", "w", 8));
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("maniek", "p.", 18));

        var adult = persons.stream()
                .filter(person -> person.age() >= 18)
                .collect(Collectors.toList());

        assertEquals(1, adult.size());

        List<Person> children = persons.stream()
                .filter(person -> person.age() < 18)
                .collect(Collectors.toList());
        assertEquals(1, children.size());
        assertEquals("olaf", children.get(0).name());
    }
}
