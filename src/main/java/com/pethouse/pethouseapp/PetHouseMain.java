package com.pethouse.pethouseapp;

import com.pethouse.pethouseapp.enums.Gender;
import com.pethouse.pethouseapp.enums.Species;
import com.pethouse.pethouseapp.units.Animal;
import com.pethouse.pethouseapp.units.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PetHouseMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PetHouseMain.class.getResource("firstScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Pet House App!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        while (true) {
            try {
                if (SQLService.animalsCount() >= 20) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Animal animal = new Animal();
            SQLService.pushUnit(animal);
        }
        launch();
    }
}

