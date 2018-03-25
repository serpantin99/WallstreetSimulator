package com.ebproductions.www.wallstreetsimulator;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Michael on 25.03.2018.
 */

public class SettingsActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();   //kp warum wir das brauchen
        ab.setDisplayHomeAsUpEnabled(true);     //aber das gibt uns hierdurch den Zurück(Up)-Button
    }
}
