package org.example.receive_json.extendsJsonData;

import org.example.manage.ConfigSettings;
import org.example.manage.ReceiveDateTime;
import org.example.manage.WindDirection;
import org.example.receive_json.GettingJson;
import org.example.receive_json.JsonData;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.example.manage.ConstParam.*;

public class JsonForecast extends JsonData {

    private final static ConfigSettings settings = ConfigSettings.getInstance();
    private final String city;
    private String dateTime;
    private String feels;
    private String desc;
    private String wind;

    public JsonForecast(String city) {
        this.city = city;
    }

    @Override
    public String getWeatherJson() {

        JSONObject json = GettingJson.receiveJson(settings.getUrlForecast()
                + city + "&appid=" + settings.getApi() + "&units=metric&lang=ru");

        JSONArray list = (JSONArray) json.get("list");

        StringBuilder data = new StringBuilder();

        for (Object o : list) {

            JSONObject forecast = (JSONObject) o;

            this.dateTime = ReceiveDateTime.formattingDateTime(forecast.get("dt_txt").toString()) + ": ";

            if (this.dateTime.contains("09:00") || this.dateTime.contains("18:00")) {

                JSONObject main = (JSONObject) forecast.get("main");
                this.feels = main.getInt("feels_like") + DEGREE + ", ";

                JSONObject desk = forecast.getJSONArray("weather").getJSONObject(0);
                this.desc = desk.get("description") + ", ";

                JSONObject wind = forecast.getJSONObject("wind");
                this.wind = wind.get("speed").toString() + SPEED + " "
                        + WindDirection.directionSymb(wind.getDouble("deg"));

                data.append(this.dateTime);
                data.append(this.feels);
                data.append(this.desc);
                data.append(this.wind);
                data.append("\n");

            }
        }
        return data.toString();
    }
}
