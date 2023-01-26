package org.example.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.manage.OpenScene;
import org.example.manage.ReceiveDateTime;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerCurrentSpb {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text temp_info, sunrise, cityName, data_time,
            sunset, description, wind_info;

    @FXML
    private Button to_return;


    @FXML
    void initialize() {
        cityName.setText("Санкт-Петербург");

        data_time.setText(ReceiveDateTime.getCurrentShortDate() +
                ", " + ReceiveDateTime.getCurrentTime());

        showWeather();

        to_return.setOnAction(e -> {
            to_return.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_start.fxml");
        });

    }


    //Порядок отображения сведений о погоде в текущем городе
    private void showWeather() {

    }

}
