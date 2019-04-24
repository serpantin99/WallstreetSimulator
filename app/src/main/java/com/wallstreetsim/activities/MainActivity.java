package com.wallstreetsim.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.wallstreetsim.R;
import com.wallstreetsim.fragments.DepotFragController;
import com.wallstreetsim.fragments.MarketFragController;
import com.wallstreetsim.fragments.NewsFragController;
import com.wallstreetsim.fragments.SettingsFragController;

public class MainActivity extends AppCompatActivity
{
    private NavigationView navigationView;

    private DrawerLayout mDrawerLayout;
    private DepotFragController depotFragment;
    private MarketFragController marketFragment;
    private NewsFragController newsFragment;
    private SettingsFragController settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        depotFragment = new DepotFragController();
        marketFragment = new MarketFragController();
        newsFragment = new NewsFragController();
        settingsFragment = new SettingsFragController();

        if(savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_frame, depotFragment);
            transaction.addToBackStack(null);    //start-Fragment wird dem Backstack hinzugefügt
            transaction.commit();
        }


        mDrawerLayout = findViewById(R.id.activity_main);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_myShares);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);

                        switch(menuItem.getItemId()) {
                            case R.id.nav_myShares:
                                if(getSupportFragmentManager().findFragmentById(R.id.content_frame) != depotFragment)
                                    transaction.replace(R.id.content_frame, depotFragment);          //content_frame -> main content@activity_main
                                break;
                            case R.id.nav_market:
                                if(getSupportFragmentManager().findFragmentById(R.id.content_frame) != marketFragment)
                                    transaction.replace(R.id.content_frame, marketFragment);
                                break;
                            case R.id.nav_news:
                                if(getSupportFragmentManager().findFragmentById(R.id.content_frame) != newsFragment)
                                    transaction.replace(R.id.content_frame, newsFragment);
                                break;
                            case R.id.nav_settings:
                                if(getSupportFragmentManager().findFragmentById(R.id.content_frame) != settingsFragment)
                                    transaction.replace(R.id.content_frame, settingsFragment);
                                break;
                        }

                        transaction.commit();
                        return true;
                    }
                });
    }

    public void test(View view) {
        Log.i("In", "activity");
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if(count == 0)
            super.onBackPressed();
        else {
            if(mDrawerLayout.isDrawerOpen(GravityCompat.START))     //wenn drawer offen ist, nur drawer schließen
                mDrawerLayout.closeDrawers();
            else {                                                  //zum start-Fragment zurückkehren, wenn nicht bereits offen
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);

                if (currentFragment != null && currentFragment.isVisible() && currentFragment != depotFragment) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                    transaction.replace(R.id.content_frame, depotFragment);
                    transaction.commit();

                    navigationView.getMenu().getItem(0).setChecked(true);   //richtiges Element in Drawer markieren
                } else if (currentFragment != null && currentFragment.isVisible() && currentFragment == depotFragment) {
                    finish();   //schließt app
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}