package com.wallstreetsim.services;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MetaDataParser {
    public static String[] parse(String data) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);

        String json = jsonObject.get("Meta Data").toString();

        String[] result = new String[6];

        for(int i=0; i<result.length; i++) {
            result[i] = json.split("\",\"")[i].split("\":\"")[1].replaceAll("[\"}]", "");
        }

        return result;
    }
}
