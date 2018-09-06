package com.wallstreetsim.models;
import java.util.LinkedHashMap;

public class Equity {
    private MetaData metaData;
    private TimeSeries timeSeries;

    @Deprecated
    public Equity(String[] metaData) {                                 //dont use this
        this.metaData = new MetaData(metaData);
    }
    @Deprecated
    public Equity(LinkedHashMap<String, String[]> timeSeriesData) {     //dont use this
        this.timeSeries = new TimeSeries(timeSeriesData);
    }

    public Equity(String[] metaData, LinkedHashMap<String, String[]> timeSeriesData) { //use this
        this.metaData = new MetaData(metaData);
        this.timeSeries = new TimeSeries(timeSeriesData);
    }


    public MetaData getMetaData() {
        return metaData;
    }
    public void setMetaData(String... args) {
        this.metaData.setInformation(args[0]);
        this.metaData.setSymbol(args[1]);
        this.metaData.setLastRefreshed(args[2]);
        this.metaData.setInterval(args[3]);
        this.metaData.setOutputSize(args[4]);
        this.metaData.setTimeZone(args[5]);
    }

    public TimeSeries getTimeSeries() {
        return timeSeries;
    }
}
