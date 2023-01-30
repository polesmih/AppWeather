package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/weather_start.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 406, 552);
        stage.setTitle("Weather");

        InputStream iconStream = getClass().getResourceAsStream("/img/weather_icon.png");
        Image image = new Image(iconStream);
        stage.getIcons().add(image);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}