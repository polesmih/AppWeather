package org.example.receive_json.extendsJsonData;

import lombok.Getter;
import org.example.manage.ConfigSettings;
import org.example.manage.ReceiveDateTime;
import org.example.manage.WindDirection;
import org.example.receive_json.GettingJson;
import org.example.receive_json.JsonData;
import org.json.JSONObject;

import static org.example.manage.ConstParam.*;

@Getter
public class JsonCurrent extends JsonData {

    private final static ConfigSettings settings = ConfigSettings.getInstance();
    private final String city;
    private String feels;
    private String press;
    private String desc;
    private String wind;
    private String sunrise;
    private String sunset;


    public JsonCurrent(String city) {
        this.city = city;
    }

    @Override
    public String getWeatherJson() {

        JSONObject json = GettingJson.receiveJson(settings.getUrlCurrent()
                + city + "&appid=" + settings.getApi() + "&units=metric&lang=ru");

        JSONObject jsonSpecific = json.getJSONObject("main");

        StringBuilder data = new StringBuilder();

        this.feels = jsonSpecific.getInt("feels_like") + DEGREE;

        this.press = jsonSpecific.getDouble("pressure") * 0.75 + SCALE;

        jsonSpecific = json.getJSONArray("weather").getJSONObject(0);
        this.desc = jsonSpecific.get("description").toString();

        jsonSpecific = json.getJSONObject("wind");
        this.wind = jsonSpecific.get("speed").toString() + SPEED + ", " +
                WindDirection.directionText(jsonSpecific.getDouble("deg")) +
                WindDirection.directionSymb(jsonSpecific.getDouble("deg"));

        jsonSpecific = json.getJSONObject("sys");
        this.sunrise = ReceiveDateTime.getSunEventPiter(jsonSpecific.getLong("sunrise"));

        jsonSpecific = json.getJSONObject("sys");
        this.sunset = ReceiveDateTime.getSunEventPiter(jsonSpecific.getLong("sunset"));

        data.append("Температура: ").append(this.feels).append("\n");
        data.append("Давление: ").append(this.press).append("\n");
        data.append(this.desc).append("\n");
        data.append("Ветер: ").append(this.wind).append("\n");
        data.append("Восход: ").append(this.sunrise).append(" / Закат: ").append(this.sunset);

        return data.toString();
    }

}
