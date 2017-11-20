package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivitySowingHarvesting extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sowing_harvesting);

        onCreateDrawer();
    }

    public void filter(View v) {
        Intent intent = new Intent(this, ActivityFilter.class);
        startActivity(intent);
    }
}
