package com.wallstreetsim.background;

import android.os.AsyncTask;
import android.util.Log;

import com.wallstreetsim.interfaces.OnTaskCompleted;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestMaker extends AsyncTask<String, Void, String> {
    private OnTaskCompleted listener;

    public RequestMaker(OnTaskCompleted listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... args) {
        String url = args[0];

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Cache-Control", "no-cache")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(response != null) {
            try {
                return response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
                return "failed";
            }
        } else
            return "failed";
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onRequestCompleted(result);
    }
}