package org.example.controllers;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.manage.OpenScene;
import org.example.manage.ReceiveDateTime;
import org.example.receive_json.JsonCurrent;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.manage.ConstParam.*;

public class ControllerCurrentSearch {

    JsonCurrent jsonConnect;
    String citySet;

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField cityName;
    @FXML
    private Text exceptionField;
    @FXML
    private Text timeInfo;
    @FXML
    private Text tempInfo;
    @FXML
    private Text tempFeelsInfo;
    @FXML
    private Text pressInfo;
    @FXML
    private Text descriptionInfo;
    @FXML
    private Text windInfo;
    @FXML
    private Button getWeather;
    @FXML
    private Button clear;
    @FXML
    private Button toReturn;
    @FXML
    private Button help;


    @FXML
    void initialize() {

        cityName.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                setWeatherInfo();
            }
        });

        help.setOnAction(e -> {
            showHelp();
        });

        getWeather.setOnAction(e -> {
            setWeatherInfo();
        });

        toReturn.setOnAction(e -> {
            toReturn.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_start.fxml");
        });


        clear.setOnAction(e -> {
            reset();
        });

    }


    // отображение информации
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

    // отображение сообщений об ошибках запроса города
    private void showErrors(String message) {
        exceptionField.setText(message);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), exceptionField);
        fadeIn.setToValue(1);
        fadeIn.setFromValue(0);
        fadeIn.play();

        fadeIn.setOnFinished(event -> {
            PauseTransition pause = new PauseTransition(Duration.seconds(2));
            pause.play();
            pause.setOnFinished(event2 -> {
                FadeTransition fadeOut = new FadeTransition(Duration.seconds(2), exceptionField);
                fadeOut.setToValue(0);
                fadeOut.setFromValue(1);
                fadeOut.play();
            });
        });
    }

    // Порядок получения информации о погоде в конкретном городе
    private void setWeatherInfo() {
        if (cityName.getText().equals("")) {
            showErrors(ENTER_CITY);
        } else {
            try {
                exceptionField.setText("");
                this.citySet = cityName.getText().trim();
                jsonConnect = new JsonCurrent(citySet);
                showWeather();
            } catch (Exception e) {
                showErrors(NOT_FOUND);
            }
        }
    }


    //Порядок отображения сведений о погоде в конкретном городе
    private void showWeather() {
        timeInfo.setText("погода на " + ReceiveDateTime.getCurrentTime() + " ч. " +
                ReceiveDateTime.getCurrentShortDate() + ":");
        jsonConnect.getWeatherJson();
        tempFeelsInfo.setText(FEELS + jsonConnect.getFeels());
        pressInfo.setText(PRESS + jsonConnect.getPress());
        descriptionInfo.setText(jsonConnect.getDesc());
        windInfo.setText(WIND + jsonConnect.getWind());
    }

    private void reset() {
        cityName.setText("");
        timeInfo.setText("");
        tempInfo.setText("");
        tempFeelsInfo.setText("");
        pressInfo.setText("");
        descriptionInfo.setText("");
        windInfo.setText("");
    }
}