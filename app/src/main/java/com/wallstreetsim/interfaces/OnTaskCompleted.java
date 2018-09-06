package com.wallstreetsim.interfaces;

import java.util.LinkedHashMap;

public interface OnTaskCompleted {
    void onRequestCompleted(String data);
    void onParseCompleted(String[] md, LinkedHashMap<String, String[]> ts);
}
