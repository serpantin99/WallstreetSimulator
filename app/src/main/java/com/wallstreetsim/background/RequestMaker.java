package com.wallstreetsim.background;

import android.os.AsyncTask;

import com.wallstreetsim.interfaces.OnTaskCompleted;

public class RequestMaker extends AsyncTask<String, Void, String> {
    private OnTaskCompleted listener;

    public RequestMaker(OnTaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... args) {
        return args[0];
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    @Override
    protected void onPostExecute(String result) {
        listener.onRequestCompleted(result);
    }
}