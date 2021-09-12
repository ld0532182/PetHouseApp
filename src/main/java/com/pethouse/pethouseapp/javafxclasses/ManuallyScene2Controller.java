package com.pethouse.pethouseapp.javafxclasses;

import com.pethouse.pethouseapp.SQLService;
import com.pethouse.pethouseapp.units.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ManuallyScene2Controller implements Initializable {

    @FXML
    private Button findAnimal;

    @FXML
    private Text userText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findAnimal.setOnAction(event -> {
            ArrayList<Person> persons = Container.getPersons();
            ArrayList<String> animalNames = Container.getAnimalNames();
            Person person = persons.get(persons.size() - 1);
            int checkDelete = 1;
            try {
                checkDelete = SQLService.deleteOnePairAnimalPerson(person);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (checkDelete == 1){
                userText.setText("We can't find an animal for you");
            } else {
                userText.setText("Your animal's name is " + animalNames.get(animalNames.size() - 1));
            }
        });

    }
}
