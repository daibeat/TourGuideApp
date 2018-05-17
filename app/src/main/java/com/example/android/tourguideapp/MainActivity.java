package com.example.android.tourguideapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle mDrawerToggle;

    private Context mMain;

    /**
     * Setup the 'home' screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);

        mDrawerList = (ListView) findViewById(R.id.navList);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        addDrawerItems();
        setupDrawer();

        // Show hamburger icon on the Action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(), this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Helper to start new intent
        mMain = this;

    }

    /**
     * Setup the navigation drawer list
     */
    private void addDrawerItems() {
        String[] navArray = {getString(R.string.city_map), getString(R.string.general_info),
                getString(R.string.transport)};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, navArray);
        mDrawerList.setAdapter(mAdapter);

        // Build the navigation header
        View headerView = View.inflate(this, R.layout.nav_header, null);
        ((ImageView) headerView.findViewById(R.id.image_nav)).setImageResource(R.drawable.gamba3b);
        ((TextView) headerView.findViewById(R.id.title_nav_drawer))
                .setText(getString(R.string.city_drawer));
        mDrawerList.addHeaderView(headerView);

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Make an Intent to the Main Activity
                // Show a short Toast message for the main screen
                if (position == 0) {
                    Intent intent = new Intent(mMain, MainActivity.class);
                    startActivity(intent);

                }
                // Make an Intent to the City Map Activity
                // Show a short Toast message for the main screen
                if (position == 1) {
                    Intent intent = new Intent(mMain, Maps.class);
                    startActivity(intent);

                }
                // Make an Intent to the GeneralInfo Activity
                // Show a short Toast message for the main screen
                if (position == 2) {
                    Intent intent = new Intent(mMain, GeneralInfo.class);
                    startActivity(intent);

                }
                // Make an Intent to the Transport Activity
                // Show a short Toast message for the main screen
                if (position == 3) {
                    Intent intent = new Intent(mMain, Transport.class);
                    startActivity(intent);
                }
            }
        });
    }


    private void setupDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, R.string.drawer_open,
                R.string.drawer_close) {
        };

        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawer.addDrawerListener(mDrawerToggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Activate the navigation drawer toggle
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
