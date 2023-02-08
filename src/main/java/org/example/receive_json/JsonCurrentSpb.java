package org.example.receive_json;

import org.json.JSONObject;
import static org.example.manage.ConstParam.*;


public class JsonCurrentSpb {

    private String temp;
    private String desc;
    private String wind;
    private String sunrise;
    private String sunset;

    public void getWeatherJson() {

        String output = UrlContent.getUrlContent(
                "http://api.openweathermap.org/data/2.5/weather?&q=Saint Petersburg,RU&appid=" +
                        API + "&units=metric&lang=ru");

        JSONObject json = new JSONObject(output);
        JSONObject jsonSpecific = json.getJSONObject("main");

        this.temp = jsonSpecific.getInt("feels_like") + DEGREE;

        jsonSpecific = json.getJSONArray("weather").getJSONObject(0);
        this.desc = jsonSpecific.get("description").toString();

        jsonSpecific = json.getJSONObject("wind");
        this.wind = jsonSpecific.get("speed").toString() + SPEED;

        jsonSpecific = json.getJSONObject("sys");
        this.sunrise = String.valueOf(jsonSpecific.getLong("sunrise"));

        jsonSpecific = json.getJSONObject("sys");
        this.sunset = String.valueOf(jsonSpecific.getLong("sunset"));

    }

    public String getTemp() {
        return temp;
    }

    public String getDesc() {
        return desc;
    }

    public String getWind() {
        return wind;
    }

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

}
