package com.wallstreetsim.models;

public class MetaData {
    private String information;
    private String symbol;
    private String lastRefreshed;
    private String interval;
    private String outputSize;
    private String timeZone;

    public MetaData(String... args) {
        information = args[0];
        symbol = args[1];
        lastRefreshed = args[2];
        interval = args[3];
        outputSize = args[4];
        timeZone = args[5];
    }


    public void setInformation(String information) {
        this.information = information;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }
    public void setInterval(String interval) {
        this.interval = interval;
    }
    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }


    public String getInformation() {
        return information;
    }
    public String getSymbol() {
        return symbol;
    }
    public String getLastRefreshed() {
        return lastRefreshed;
    }
    public String getInterval() {
        return interval;
    }
    public String getOutputSize() {
        return outputSize;
    }
    public String getTimeZone() {
        return timeZone;
    }
}