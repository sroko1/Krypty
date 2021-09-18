package com.example.cryptokrypto.other.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Auto {
    private String colour;
    private int price;
    private String brand;
    private String model;

    public Auto(String colour, int price) {
        this.colour = colour;
        this.price = price;
    }

    public Auto(String colour, int price, String brand, String model) {
        this.colour = colour;
        this.price = price;
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "colour='" + colour + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public String getColour() {
        return colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return price == auto.price && Objects.equals(colour, auto.colour) && Objects.equals(brand, auto.brand) && Objects.equals(model, auto.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, price, brand, model);
    }
}

class CollectionTest {
    // ordered, unordered, sorted, unsorted

    @Test
    void testSets() {
        // sets - unique items
        // unordered, unsorted
        Set<Auto> autos1 = new HashSet<>();

        // ordered, unsorted
        Set<Auto> autos2 = new LinkedHashSet<>();

        Set<Auto> sortedSet = new TreeSet<>(Comparator.comparingInt(Auto::getPrice));
        var auto = new Auto("blue", 1);
        var auto2 = new Auto("blue", 1);
        sortedSet.add(auto);
        sortedSet.add(auto2);
        assertEquals(auto, auto2);
        assertEquals(1, sortedSet.size());

    }

    @Test
    void testLists() {
        // all lists are ordered
        // do I need hashCode/equals contract here??
        // easier iteration/ more difficult iteration
        var toFind = new Auto("blue", 1);
        List<Auto> autos = new ArrayList<>();
        autos.add(new Auto("blue", 1));
        autos.add(new Auto("pink", 1_000));

        autos.forEach(auto -> System.out.println("my car: " + auto));

        // easier adding / more difficult iteration :)
        List<Auto> autosLinked = new LinkedList<>();

        // cache friendly makes using of ArrayList more performant !!!
        assertEquals(2, autos.size());
        assertEquals(true, autos.contains(toFind));
        // ==
    }

    @Test
    void testMaps() {
        // maps belong to collection framework, but don't implement Collection interface

        // unordered, unsorted
        // different iterations can give us elements in different order!!!
        Map<Auto, String> myAutos = new HashMap<>();

        // ordered, unsorted
        Map<Auto, String> myAuto3 = new LinkedHashMap<>();

        // ordered, sorted
//        Map<Auto, String> myAuto2 = new TreeMap<>((o1, o2) -> o2.getPrice() - o1.getPrice());
        Map<Auto, String> myAuto2 = new TreeMap<>(Comparator.comparingInt(Auto::getPrice).reversed());
        myAuto2.put(new Auto("blue", 1_000), "maniek");
        myAuto2.put(new Auto("pink", 2_000), "maniek");
        assertEquals(2, myAuto2.size());
        myAuto2.forEach((auto, s) -> System.out.println("Auto: " + auto));
    }

    @Test
    void sortingTest() {
        var age = 4L; // wrong!!!
        List<Auto> autos = new ArrayList<>();
        var myAutos = new ArrayList<Auto>();
        myAutos.add(new Auto("metalic", 100, "Toyota", "Karola"));
        myAutos.add(new Auto("metalic", 1_000, "Mazda", "VI"));
        myAutos.add(new Auto("metalic", 1_000, "Toyota", "Karola v2"));
        myAutos.sort(Comparator
                .comparingInt(Auto::getPrice).reversed()
                .thenComparing(Comparator.comparing(Auto::getBrand).reversed())
                .thenComparing(Auto::getColour));
        System.out.println("After sorting...");
        myAutos.forEach(auto -> System.out.println("My auto: " + auto));
        assertEquals(new Auto("metalic", 1_000, "Toyota", "Karola v2"), myAutos.get(0));
    }

    @Test
    void printStringTest() {
        // from left to right
        // number + number = number
        // number + string = numberstring
        // string + number = stringnumber
        // string + string = stringstring
        String s  = 40 + 40 + "text" + (50 + 50);
        // 80  + "text" + 50 + 50
        // "80text" + 50 + 50
        // "80text50" + 50
        // "80text5050"
        System.out.println(s);
        assertEquals("80text100", s);
    }
}
