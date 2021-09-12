package com.pethouse.pethouseapp.javafxclasses;

import com.pethouse.pethouseapp.PetHouseMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstSceneController implements Initializable {
    @FXML
    private Button manuallyButton;

    @FXML
    private Button selectFromFileButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        manuallyButton.setOnAction(event -> changeScene("manuallySetScene.fxml", event));
        selectFromFileButton.setOnAction(event -> changeScene("fileSetScene.fxml", event));
    }

    public static void changeScene(String urlFileScene, ActionEvent event) {
        FXMLLoader root;
        Scene scene = null;
        root = new FXMLLoader(PetHouseMain.class.getResource(urlFileScene));
        try {
            scene = new Scene(root.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}