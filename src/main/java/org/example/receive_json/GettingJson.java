package org.example.receive_json;

import org.json.JSONObject;

public class GettingJson {


    public static JSONObject receiveJson (String url) {
        return new JSONObject(UrlContent.getUrlContent(url));

    }

}
