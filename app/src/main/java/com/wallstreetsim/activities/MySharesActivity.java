package com.wallstreetsim.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wallstreetsim.R;
import com.wallstreetsim.background.RequestMaker;

/**
 * Created by Michael on 28.03.2018.
 */

public class MySharesActivity extends AppCompatActivity
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
        RequestMaker rqm = new RequestMaker();

        String url = "https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency=BTC&to_currency=EUR&apikey=RSF9Z2UFYUI01LN1";
        rqm.execute(url);
    }
}
