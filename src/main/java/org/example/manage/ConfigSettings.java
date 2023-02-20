package org.example.manage;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
public class ConfigSettings {
    public static final String FILE_NAME = "config.properties";
    private static ConfigSettings instance = new ConfigSettings();
    private Properties properties;
    private String api;
    private String urlSpb;
    private String urlCurrent;
    private String urlForecast;

    public static ConfigSettings getInstance() {
         return instance;
    }

    {
        try {
            properties = new Properties();

            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME)) {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new IOException(String.format("Error loading properties file '%s'", FILE_NAME));
            }

            api = properties.getProperty("api");
            if (api == null) {
                throw new RuntimeException("Api value is null");
            }

            urlSpb = properties.getProperty("urlSpb");
            if (urlSpb == null) {
                throw new RuntimeException("Url value is null");
            }

            urlCurrent = properties.getProperty("urlCurrent");
            if (urlCurrent == null) {
                throw new RuntimeException("Url value is null");
            }

            urlForecast = properties.getProperty("urlForecast");
            if (urlForecast == null) {
                throw new RuntimeException("Url value is null");
            }


        } catch (RuntimeException | IOException e) {
            throw new RuntimeException("App initialisation error: " + e.getMessage());
        }
    }


}
