package com.weharvest2.weharvest20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityCreateRecipe extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        onCreateDrawer();
    }
}
