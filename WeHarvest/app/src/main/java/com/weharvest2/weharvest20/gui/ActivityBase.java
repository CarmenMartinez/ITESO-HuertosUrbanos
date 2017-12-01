package com.weharvest2.weharvest20.gui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.weharvest2.weharvest20.ActivityAboutUs;
import com.weharvest2.weharvest20.ActivityEvents;
import com.weharvest2.weharvest20.ActivityLogin;
import com.weharvest2.weharvest20.ActivityMain;
import com.weharvest2.weharvest20.ActivityProfile;
import com.weharvest2.weharvest20.ActivityRecipes;
import com.weharvest2.weharvest20.ActivitySowingHarvesting;
import com.weharvest2.weharvest20.R;
import com.weharvest2.weharvest20.beans.Session;
import com.weharvest2.weharvest20.common.Utils;

/**
 * Created by fernando on 26/10/17.
 */

public class ActivityBase extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected Toolbar mToolbar;
    protected String[] mActivitiesTitles;
    protected DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    protected ImageView mPhoto;
    protected TextView mEmail;
    protected TextView mName;
    protected View mNavHeader;

    protected void onCreateDrawer() {
        mActivitiesTitles = getResources().getStringArray(R.array.titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        mNavHeader = mNavigationView.getHeaderView(0);

        //mPhoto = (ImageView) mNavHeader.findViewById(R.id.imageView);
        mName = (TextView) mNavHeader.findViewById(R.id.name);
        mEmail = (TextView) mNavHeader.findViewById(R.id.email);

        loadNavHeader();
    }

    private void loadNavHeader() {
        // name, website
        //Bitmap photo = BitmapFactory.decodeResource(this.getResources(),R.drawable.profile);

        //mPhoto.setImageBitmap(Utils.getRoundedShape(photo));
        mName.setText(Session.getUserSession().getUsername());
        mEmail.setText(Session.getUserSession().getEmail());
    }

    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        switch (item.getItemId()) {
            case R.id.nav_explore:
                intent = new Intent(this, ActivityMain.class);
                startActivity(intent);
                break;
            case R.id.nav_recipe:
                intent = new Intent(this, ActivityRecipes.class);
                startActivity(intent);
                break;
            case R.id.nav_us:
                intent = new Intent(this, ActivityAboutUs.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                clearPreferences();
                break;
            case R.id.nav_profile:
                intent = new Intent(this, ActivityProfile.class);
                startActivity(intent);
                break;
            case R.id.nav_events:
                intent = new Intent(this, ActivityEvents.class);
                startActivity(intent);
                break;
            case R.id.nav_sowing_harvesting:
                intent = new Intent(this, ActivitySowingHarvesting.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void clearPreferences(){
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.PDDM_Sesion13.CACAHUATE",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();

        Intent intent = new Intent(this, ActivityLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
