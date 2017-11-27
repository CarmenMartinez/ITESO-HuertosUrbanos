package com.weharvest2.weharvest20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.weharvest2.weharvest20.gui.ActivityBase;

public class ActivityFilter extends ActivityBase {

    protected Spinner classification;
    protected Spinner cycle;
    protected Spinner season;
    protected Spinner state;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        onCreateDrawer();

        classification = (Spinner) findViewById(R.id.activity_filter_classification);
        cycle = (Spinner) findViewById(R.id.activity_filter_cycle);
        season = (Spinner) findViewById(R.id.activity_filter_season);
        state = (Spinner) findViewById(R.id.activity_filter_state);

        button = (Button) findViewById(R.id.activity_filter_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classification_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        classification.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.cycle_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        cycle.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.season_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        season.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.state_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        state.setAdapter(adapter);
    }

    public void filter(View v) {
        // FILTRAR LOS DATOS DE BASE DE DATOS

        Intent intent = new Intent(this, ActivitySowingHarvesting.class);
        startActivity(intent);
    }
}
