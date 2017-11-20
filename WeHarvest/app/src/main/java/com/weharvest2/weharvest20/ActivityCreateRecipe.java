package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityCreateRecipe extends ActivityBase {

    protected Spinner spinner;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        onCreateDrawer();

        spinner = (Spinner) findViewById(R.id.activity_create_recipe_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.types_recipes, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public void create(View v) {
        // CREACION DE RECETA EN BASE DE DATOS

        Intent intent = new Intent(this, ActivityRecipes.class);
        startActivity(intent);
    }


}
