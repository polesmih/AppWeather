package org.example.receive_json;

public abstract class JsonData {

    private String city;

    public abstract String getWeatherJson();

    public String getCity() {
        return city;
    }


}
