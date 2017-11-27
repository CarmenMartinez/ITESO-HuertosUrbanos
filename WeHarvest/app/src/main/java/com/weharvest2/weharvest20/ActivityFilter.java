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

    protected Spinner plant;
    protected Spinner month;
    protected Spinner mode;
    protected Spinner state;
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        onCreateDrawer();

        plant = (Spinner) findViewById(R.id.activity_filter_plant);
        month = (Spinner) findViewById(R.id.activity_filter_month);
        mode = (Spinner) findViewById(R.id.activity_filter_mode);
        state = (Spinner) findViewById(R.id.activity_filter_state);

        button = (Button) findViewById(R.id.activity_filter_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.plant_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        plant.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        month.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.mode_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mode.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.state_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        state.setAdapter(adapter);



    }

    public void filter(View v) {
        // FILTRAR LOS DATOS DE BASE DE DATOS

        String plantSelect =  plant.getSelectedItem().toString();
        String monthSelect =  month.getSelectedItem().toString();
        String modeSelect =  mode.getSelectedItem().toString();
        String stateSelect =  state.getSelectedItem().toString();

        Intent intent = new Intent(this, ActivitySowingHarvesting.class);
        startActivity(intent);
    }
}
