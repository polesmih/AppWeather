package org.example.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import org.example.manage.OpenScene;
import org.example.manage.ReceiveDateTime;
import org.example.receive_json.JsonCurrentSpb;

import java.net.URL;
import java.util.ResourceBundle;

import static org.example.manage.ConstParam.*;

public class ControllerCurrentSpb {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text tempInfo;
    @FXML
    private Text sunrise;
    @FXML
    private Text cityName;
    @FXML
    private Text dataTime;
    @FXML
    private Text sunset;
    @FXML
    private Text description;
    @FXML
    private Text windInfo;
    @FXML
    private Button toReturn;

    JsonCurrentSpb jsonConnect = new JsonCurrentSpb();

    @FXML
    void initialize() {
        cityName.setText("Санкт-Петербург");

        dataTime.setText(ReceiveDateTime.getCurrentShortDate() +
                ", " + ReceiveDateTime.getCurrentTime());

        showWeather();

        toReturn.setOnAction(e -> {
            toReturn.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_start.fxml");
        });

    }

    //Порядок отображения сведений о погоде в СПб
    private void showWeather() {
        jsonConnect.getWeatherJson();
        tempInfo.setText(jsonConnect.getTemp());
        description.setText(jsonConnect.getDesc());
        windInfo.setText(jsonConnect.getWind());
        sunrise.setText(SUNRISE + jsonConnect.getSunrise());
        sunset.setText(SUNSET + jsonConnect.getSunset());

    }

}
