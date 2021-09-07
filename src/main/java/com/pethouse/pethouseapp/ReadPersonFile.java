package com.pethouse.pethouseapp;

import com.pethouse.pethouseapp.enums.Color;
import com.pethouse.pethouseapp.enums.Gender;
import com.pethouse.pethouseapp.enums.Size;
import com.pethouse.pethouseapp.enums.Species;
import com.pethouse.pethouseapp.units.Person;

import java.io.*;
import java.util.ArrayList;

public class ReadPersonFile {

    private static final String PATH_TO_FILE = "src/main/resources/persons.txt";

    private static ArrayList<String> readFile() throws IOException {
        ArrayList<String> persons = new ArrayList<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(PATH_TO_FILE));
        while ((line = reader.readLine()) != null) {
            persons.add(line);
        }
        return persons;
    }

    public static ArrayList<Person> getPersonsFromFile() throws IOException {
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<String> strPersons = readFile();
        for (String p : strPersons) {
            String[] split = p.split(" ");
            persons.add(new Person(split[0], Color.valueOf(split[1]), Gender.valueOf(split[2]),
                    Size.valueOf(split[3]), Species.valueOf(split[4])));
        }
        return persons;
    }
}
