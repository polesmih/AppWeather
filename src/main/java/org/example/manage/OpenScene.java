package org.example.manage;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class OpenScene {

    public static void openScene(String window) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(OpenScene.class.getResource(window));
        try {
            loader.load();
        }catch (IOException e) {
            e.printStackTrace();
        }

        Parent root  = loader.getRoot();
        Stage stage = new Stage();

        stage.setTitle("Weather");

        InputStream iconStream = OpenScene.class.getResourceAsStream("/img/weather_icon.png");
        assert iconStream != null;
        Image image = new Image(iconStream);
        stage.getIcons().add(image);


        stage.setScene(new Scene(root));
        stage.show();
    }
}
