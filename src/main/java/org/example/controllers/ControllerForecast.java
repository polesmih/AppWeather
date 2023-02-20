package org.example.controllers;

import org.example.manage.OpenScene;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class ControllerForecast {

    String citySet;
    @FXML
    public Button toReturn;
    @FXML
    public Button help;
    @FXML
    public Button getWeather;
    @FXML
    public Button clear;
    @FXML
    public TextField cityName;
    @FXML
    public Text exceptionField;
    @FXML
    public Text forecast;

    @FXML
    void initialize() {


        help.setOnAction(e -> {
            showHelp();
        });


        toReturn.setOnAction(e -> {
            toReturn.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_start.fxml");
        });

    }

    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Справка");
        alert.setHeaderText(null);
        alert.setContentText("Название города можно вводить на русском " +
                "либо на английском языке.\n" +
                "Для уточнения страны, через запятую необходимо ввести ее аббревитуру по-английски.\n" +
                "Например: рим, it");
        alert.showAndWait();
    }


}
