package com.wallstreetsim.background;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestMaker extends AsyncTask<String, Void, Response> {
    protected Response doInBackground(String... args) {
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
        return response;
    }

    protected void onPostExecute(Response result) {
        try {
            Log.i("Response: ", result.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}