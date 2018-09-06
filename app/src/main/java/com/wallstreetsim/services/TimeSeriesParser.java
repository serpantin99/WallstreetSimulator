package com.wallstreetsim.services;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.LinkedHashMap;

public class TimeSeriesParser {
    public static LinkedHashMap<String, String[]> parse(String data, int minutes) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
        Log.i("", String.valueOf(data.length()));
        String json = jsonObject.get("Time Series (" + minutes + "min)").toString();
        Log.i("", String.valueOf(jsonObject.toString().length()));
        Log.i("", String.valueOf(json.length()));

        LinkedHashMap<String, String[]> timeSeriesData = new LinkedHashMap<String, String[]>();
        json = json.substring(1);

        int length = json.split("[{]").length;

        for(int i=0; i<length/2; i++) {
            String key = json.split("[{}]")[i*2].replaceAll("[,\":]", "");
            String[] s = key.split(" ");
            key = s[0] + " " + s[1].substring(0, 2) + ":" + s[1].substring(2, 4) + ":" + s[1].substring(4,6);

            String[] value = new String[5];

            for(int j=0; j<5; j++) {
                value[j] = json.split("[{}]")[i*2+1].split("\":\"")[j+1].substring(0,7).replaceAll("\"", "");
            }

            timeSeriesData.put(key, value);
        }

        return timeSeriesData;
    }
}
