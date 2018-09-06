package com.wallstreetsim.background;

import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;

import com.wallstreetsim.interfaces.OnTaskCompleted;
import com.wallstreetsim.services.MetaDataParser;
import com.wallstreetsim.services.TimeSeriesParser;

import java.util.LinkedHashMap;

public class BackgroundParser extends AsyncTask<String, Void, Pair<String[], LinkedHashMap<String, String[]>>>{
    private OnTaskCompleted listener;

    public BackgroundParser(OnTaskCompleted listener) {
        this.listener = listener;
    }
    @Override
    protected Pair<String[], LinkedHashMap<String, String[]>> doInBackground(String... args) {
        String data = args[0];
        String[] md = MetaDataParser.parse(data);
        LinkedHashMap<String, String[]> ts = TimeSeriesParser.parse(data);

        return Pair.create(md, ts);
    }

    @Override
    protected void onPostExecute(Pair<String[], LinkedHashMap<String, String[]>> p) {
        listener.onParseCompleted(p.first,  p.second);
    }
}
