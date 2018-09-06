package com.wallstreetsim.models;

import java.util.LinkedHashMap;

public class TimeSeries {
    String[] key;
    LinkedHashMap<String, String[]> data;

    public TimeSeries(LinkedHashMap<String, String[]> timeSeriesData) {
        key = timeSeriesData.keySet().toArray(new String[timeSeriesData.size()]);
        data = timeSeriesData;
    }

    public String getKey(int index) {
        return key[index];
    }
    public int getLength() {
        return key.length;
    }
    public String[] getValuesByKey(String key) {
        return data.get(key);
    }
    public String[] getValuesByIndex(int index) {
        return data.get(key[index]);
    }
}
