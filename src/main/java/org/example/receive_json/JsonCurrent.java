package org.example.receive_json;

import org.example.manage.ReceiveDateTime;
import org.example.manage.WindDirection;
import org.json.JSONObject;

import static org.example.manage.ConstParam.*;

public class JsonCurrent {
    private final String city;
    private String temp;
    private String feels;
    private String press;
    private String desc;
    private String wind;
    private String sunrise;
    private String sunset;


    public JsonCurrent(String city) {
        this.city = city;
    }

    public void getWeatherJson() {

        JSONObject json = GettingJson.receiveJson("http://api.openweathermap.org/data/2.5/weather?&q="
                + city + "&appid=" + API + "&units=metric&lang=ru");

        JSONObject jsonSpecific = json.getJSONObject("main");

        this.temp = jsonSpecific.getInt("temp") + DEGREE;

        this.feels = jsonSpecific.getInt("feels_like") + DEGREE;

        this.press = jsonSpecific.getDouble("pressure") * 0.75 + SCALE;

        jsonSpecific = json.getJSONArray("weather").getJSONObject(0);
        this.desc = jsonSpecific.get("description").toString();

        jsonSpecific = json.getJSONObject("wind");
        this.wind = jsonSpecific.get("speed").toString() + SPEED + ", " +
                WindDirection.directionText(jsonSpecific.getDouble("deg")) +
                        WindDirection.directionSymb(jsonSpecific.getDouble("deg"));

        jsonSpecific = json.getJSONObject("sys");
        this.sunrise = ReceiveDateTime.getSunEventPiter(jsonSpecific.getLong("sunrise")) ;

        jsonSpecific = json.getJSONObject("sys");
        this.sunset = ReceiveDateTime.getSunEventPiter(jsonSpecific.getLong("sunset"));

    }

    public String getFeels() {
        return feels;
    }

    public String getPress() {
        return press;
    }

    public String getDesc() {
        return desc;
    }

    public String getWind() {
        return wind;
    }


}
