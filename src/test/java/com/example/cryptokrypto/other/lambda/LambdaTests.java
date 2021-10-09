package com.example.cryptokrypto.other.lambda;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
//        List<int> integers;
//        List<Integer> integers;

        int sum2 = persons.stream()
                .mapToInt(person -> person.age())
                .sum();

        assertEquals(28, sum2);
    }

    @Test
    public void carTest() {
        CarDealer advisor = new CarDealer();
        Car passat = Car.builder()
                .brand("VW")
                .model("Passat")
                .color("blue")
                .production(LocalDate.of(2021, 1, 1))
                .build();

        boolean decision = advisor.shouldIBuyThisCar(passat);
        assertTrue(decision);

        Car mazda = Car.builder()
                .brand("Mazda")
                .model("VI")
                .color("red")
                .production(LocalDate.of(2010, 1, 15))
                .build();

        decision = advisor.shouldIBuyThisCar(mazda, car -> car.getBrand().equals("Mazda"));
        assertTrue(decision);
    }

    @Test
    public void methodReferenceTest() {
        // with lambda
        // convert Person -> age
        // println
        persons.stream()
                .map(person -> person.age()) // Integer apply(Person p)
                .forEach(person -> System.out.println(person)); // void accept(Person p)
        // method reference
        persons.stream()
                .map(Person::age) // Integer apply(Person p)
                .forEach(System.out::println);
    }
}

class AdultsOnly implements Predicate<Person> {

    @Override
    public boolean test(Person o) {
        return o.age() >= 18;
    }
}

@Data
@Builder
class Car {
    String brand;
    String model;
    LocalDate production;
    String color;
}
