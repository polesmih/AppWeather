package org.example.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.manage.OpenScene;
import org.example.manage.ReceiveDateTime;
import org.example.receive_json.extendsJsonData.JsonCurrentSpb;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.manage.ConstParam.*;

public class ControllerCurrentSpb {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Text cityName;
    @FXML
    private Text dataTime;
    @FXML
    private Text weatherInfo;
    @FXML
    private Button toReturn;

    JsonCurrentSpb jsonConnect = new JsonCurrentSpb();

    @FXML
    void initialize() {
        cityName.setText("Санкт-Петербург");

        dataTime.setText(ReceiveDateTime.getCurrentDate() +
                ", " + ReceiveDateTime.getCurrentTime());

        weatherInfo.setText(jsonConnect.getWeatherJson());

        toReturn.setOnAction(e -> {
            toReturn.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_start.fxml");
        });
    }

}
