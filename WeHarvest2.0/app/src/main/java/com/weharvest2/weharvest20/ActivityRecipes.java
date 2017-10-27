package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityRecipes extends ActivityBase {

    protected Button seeds;
    protected Button ground;
    protected Button compound;
    protected Button verticalOrchard;
    protected FloatingActionButton create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        onCreateDrawer();

        seeds = (Button) findViewById(R.id.activity_recipes_seeds);
        ground = (Button) findViewById(R.id.activity_recipes_ground);
        compound = (Button) findViewById(R.id.activity_recipes_compound);
        verticalOrchard = (Button) findViewById(R.id.activity_recipes_vertical_orchard);
        create = (FloatingActionButton) findViewById(R.id.activity_recipe_create);

        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        compound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        verticalOrchard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}