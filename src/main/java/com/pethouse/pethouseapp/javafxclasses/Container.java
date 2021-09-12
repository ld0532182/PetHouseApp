package com.pethouse.pethouseapp.javafxclasses;

import com.pethouse.pethouseapp.units.Person;
import java.util.ArrayList;

public final class Container {

    private static ArrayList<Person> persons = new ArrayList<>();
    public static ArrayList<Person> getPersons() {
        return persons;
    }
    public static void addPerson(Person person) {
        persons.add(person);
    }

    private static ArrayList<String> animalNames = new ArrayList<>();
    public static ArrayList<String> getAnimalNames() {
        return animalNames;
    }
    public static void addAnimalName(String name) { animalNames.add(name); }

    private static ArrayList<String> personNames = new ArrayList<>();
    public static ArrayList<String> getPersonNames() { return personNames;  }
    public static void addPersonName(String name) {
        personNames.add(name);
    }
}
