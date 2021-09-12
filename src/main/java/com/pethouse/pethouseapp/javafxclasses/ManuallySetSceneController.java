package com.pethouse.pethouseapp.javafxclasses;

import com.pethouse.pethouseapp.PetHouseMain;
import com.pethouse.pethouseapp.SQLService;
import com.pethouse.pethouseapp.enums.Color;
import com.pethouse.pethouseapp.enums.Gender;
import com.pethouse.pethouseapp.enums.Size;
import com.pethouse.pethouseapp.enums.Species;
import com.pethouse.pethouseapp.units.Person;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManuallySetSceneController implements Initializable {

    @FXML
    private ChoiceBox<Color> colorChoiceBox;

    @FXML
    private ChoiceBox<Size> sizeChoiceBox;

    @FXML
    private ChoiceBox<Gender> genderChoiceBox;

    @FXML
    private ChoiceBox<Species> speciesChoiceBox;

    @FXML
    private TextField nameField;

    @FXML
    private Button confirmButton;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colorChoiceBox.getItems().addAll(Color.values());
        sizeChoiceBox.getItems().addAll(Size.values());
        genderChoiceBox.getItems().addAll(Gender.values());
        speciesChoiceBox.getItems().addAll(Species.values());

        confirmButton.setOnAction(event -> {
            pushPerson();
            FirstSceneController.changeScene("manuallyScene2.fxml", event);
        });
    }

    private synchronized void pushPerson() {
        if ("Your name".equals(nameField.getText()) || "".equals(nameField.getText())) {
            shake(nameField);
            return;
        }
        Person person = new Person(nameField.getText(), colorChoiceBox.getValue(), genderChoiceBox.getValue(),
                sizeChoiceBox.getValue(), speciesChoiceBox.getValue());
        Container.addPerson(person);
        SQLService.pushUnit(person);
    }

    private static void shake(Node node) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(70), node);
        tt.setFromX(0f);
        tt.setByY(10f);
        tt.setCycleCount(4);
        tt.setAutoReverse(true);
        tt.playFromStart();
    }

}
