package com.pethouse.pethouseapp.units;

import com.pethouse.pethouseapp.PropertiesGetter;
import com.pethouse.pethouseapp.enums.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Animal extends TableUnit {

    private static ArrayList<String> animalNames = getAnimalNames();

    private static final Random rand = new Random();

    private final String TABLE_NAME;

    public Animal() {
        super(animalNames.get(rand.nextInt(animalNames.size())), Color.values()[rand.nextInt(5)],
                Gender.values()[rand.nextInt(2)], Size.values()[rand.nextInt(3)],
                Species.values()[rand.nextInt(2)]);
        this.TABLE_NAME = new PropertiesGetter().getDB_TABLE_ANIMAL();
    }

    public Animal(String name, Color color, Gender gender, Size size, Species species) {
        super(name, color, gender, size, species);
        this.TABLE_NAME = new PropertiesGetter().getDB_TABLE_ANIMAL();
    }

    private static ArrayList<String> getAnimalNames() {
        ArrayList<String> names = new ArrayList<>();
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/animalNames.txt"));
            while ((line = reader.readLine()) != null)
                names.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    @Override
    public String getDbFieldName() {
        return DbFieldAnimal.NAME.getStrField();
    }

    @Override
    public String getDbFieldSpecies() {
        return DbFieldAnimal.SPECIES.getStrField();
    }

    @Override
    public String getDbFieldGender() {
        return DbFieldAnimal.GENDER.getStrField();
    }

    @Override
    public String getDbFieldColor() {
        return DbFieldAnimal.COLOR.getStrField();
    }

    @Override
    public String getDbFieldSize() {
        return DbFieldAnimal.SIZE.getStrField();
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }
}
