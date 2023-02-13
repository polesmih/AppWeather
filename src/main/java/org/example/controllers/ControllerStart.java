package org.example.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.manage.OpenScene;
import org.example.manage.ReceiveDateTime;

import java.net.URL;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class ControllerStart {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Text currentDate;
    @FXML
    private Text currentTime;
    @FXML
    private Button getWorld;
    @FXML
    private Button getSpb;
    @FXML
    private Button getForecast;

    @FXML
    void initialize() {

        currentDate.setText(ReceiveDateTime.getCurrentDate());
        getRunningTime();

        getSpb.setOnAction(e -> {
            getSpb.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_current_spb.fxml");
        });

        getWorld.setOnAction(e -> {
            getWorld.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_current_search.fxml");
        });

        getForecast.setOnAction(e -> {
            getWorld.getScene().getWindow().hide();
            OpenScene.openScene("/fxml/weather_forecast.fxml");
        });
    }

    public void getRunningTime() {

        final DateFormat format = DateFormat.getTimeInstance();
        final Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        final Calendar cal = Calendar.getInstance();
                        currentTime.setText(format.format(cal.getTime()));
                    }
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
