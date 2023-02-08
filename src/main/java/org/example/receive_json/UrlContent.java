package org.example.receive_json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlContent {


    public static String getUrlContent(String urlAdress) {

        StringBuilder content = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
                     (new URL(urlAdress).openConnection().getInputStream()))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}


