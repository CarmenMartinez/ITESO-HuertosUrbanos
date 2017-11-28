package com.weharvest2.weharvest20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.weharvest2.weharvest20.beans.Session;
import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityProfile extends ActivityBase {

    protected TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        username = (TextView) findViewById(R.id.activity_profile_username);

        username.setText(Session.getUserSession().getUsername());

        onCreateDrawer();
    }
}
