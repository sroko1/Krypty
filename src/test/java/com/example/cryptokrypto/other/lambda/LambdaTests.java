package com.example.cryptokrypto.other.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTests {

    private List<Person> persons;

    @BeforeEach
    private void initPersons() {
        persons = List.of(
                new Person("maniek", "p.", 20),
                new Person("olaf", "w", 8));
    }

    @Test
    void filteringTest() {

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

    @Test
    void filteringTestWithObject() {
        var adults = persons.stream()
                .filter(new AdultsOnly())
                .collect(Collectors.toList());

        persons.stream()
                .filter((Person p) -> {
                    return p.age() == 18;
                });

        int sum = persons.stream()
                .map(person -> person.age())
                .reduce(0, (integer, integer2) -> integer + integer2);
        // reduce is the same as
        // int identity = 0; // identity is integer
        // for (Integer integer2: ages) {
        //   identity += integer2;
        //}

        assertEquals(28, sum);
    }
}

class AdultsOnly implements Predicate<Person> {

    @Override
    public boolean test(Person o) {
        return o.age() >= 18;
    }
}
