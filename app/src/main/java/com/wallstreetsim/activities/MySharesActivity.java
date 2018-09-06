package com.wallstreetsim.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wallstreetsim.R;
import com.wallstreetsim.background.BackgroundParser;
import com.wallstreetsim.background.RequestMaker;
import com.wallstreetsim.interfaces.OnTaskCompleted;
import com.wallstreetsim.models.Equity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class MySharesActivity extends AppCompatActivity implements OnTaskCompleted
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myshares);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void reqTest(View v) {
        RequestMaker rqm = new RequestMaker(this);
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=APC&interval=60min&datatype=json&apikey=RSF9Z2UFYUI01LN1";
        rqm.execute(url);

        //new RequestMaker().execute(url);
    }

    @Override
    public void onRequestCompleted(String data) {
        if(data.equals("failed"))
            Log.i("", "failed");
        else
            new BackgroundParser(this).execute(data);
    }

    @Override
    public void onParseCompleted(String[] md, LinkedHashMap<String, String[]> ts) {
        Equity eq = new Equity(md, ts);

        ListView lv = (ListView) findViewById(R.id.listView);
        List<String> s = new ArrayList<String>();
        for(int i=0; i<eq.getTimeSeries().getLength(); i++) {
            s.add(eq.getTimeSeries().getKey(i));
            for(int j=0; j<5; j++) {
                s.add(eq.getTimeSeries().getValuesByIndex(i)[j]);
            }
        }

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, s);
        lv.setAdapter(itemsAdapter);
    }
}
