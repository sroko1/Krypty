package com.example.cryptoclient;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectionsClassTest {

    @Test
    void stringClassTest() {
        String me = "maniek";

        assertEquals(String.class, me.getClass());
    }

    @Test
    void collectionsClassTest() {
        List objects = new ArrayList();
        objects.add(new Object());
        if (objects.get(0) instanceof String) {
            String nick = (String) objects.get(0);
        }

        assertEquals(ArrayList.class, objects.getClass());
        System.out.println("objects class: " + objects.getClass());
    }

    @Test
    void genericCollectionClassTest() {
        ArrayList<String> strings = new ArrayList<>();
//        strings.add(new Dog());
//        strings.add((String)new Dog()); // this is how compiler works
        System.out.println("strings class: " + strings.getClass()); // java.util.ArrayList<String> ???
        addElementToCollection(strings);
//        String name = strings.get(0);
//        String name2 = (String)strings.get(0); // this is how compiler works

        ArrayList objects = new ArrayList();
        System.out.println("objects class: " + objects.getClass());

        Object[] objectsArray = new Object[1];
        System.out.println("objectsArray class: " + objectsArray.getClass());

        String[] stringArray = new String[1];
        System.out.println("stringArray class: " + stringArray.getClass());
        // addElementToArray(stringArray); // arrays knows at runtime their type
    }

    @Test
    void castingExample() {
        Object o = "maniek"; // upcasting = polymorphism - always safe:)
//        String string = (String)new Dog();
        String s = (String) o; // downcasting - not always safe!!!!
        Object dog = new Dog(); // upcasting
        casting(dog);
//        String maybeString = (String) dog; // casting without control is stupid:)
    }

    private void casting(Object o) {
        if (o instanceof String) {
            // always safe!!!
            String maybeString = (String) o;
        } else {
            System.out.println("cann't cast");
        }
    }
    private static void addElementToArray(String[] objects) {
        objects[0] = "new Dog()";
    }

    private static void addElementToArray(Object[] objects) {
        objects[0] = new Dog();
    }

//    private static void addElementToCollection(List<Dog> objects) {
//        objects.add(new Dog());
//    }

    private static void addElementToCollection(List objects) {
        objects.add(new Dog());
    }
}

record Dog() {}