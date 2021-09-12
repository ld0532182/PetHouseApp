package com.pethouse.pethouseapp.javafxclasses;

import com.pethouse.pethouseapp.ReadPersonFile;
import com.pethouse.pethouseapp.SQLService;
import com.pethouse.pethouseapp.units.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FileSceneController implements Initializable {

    @FXML
    private Button button;

    @FXML
    private Label labelField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> personNames = Container.getPersonNames();
        ArrayList<String> animalNames = Container.getAnimalNames();
        try {
            ArrayList<Person> personsFromFile = ReadPersonFile.getPersonsFromFile();
            for (Person p : personsFromFile) {
                SQLService.pushUnit(p);
            }
            SQLService.deleteAllPairAnimalPerson();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        button.setOnAction(event -> {
            if (personNames.isEmpty()) {
                labelField.setText("It was all the people who got the animal");
                return;
            }
            labelField.setText(personNames.remove(0) + " takes " + animalNames.remove(0));
        });

    }
}
