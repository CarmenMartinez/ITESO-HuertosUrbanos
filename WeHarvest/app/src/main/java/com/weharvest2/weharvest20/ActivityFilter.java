package com.weharvest2.weharvest20;

import android.content.Intent;
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
    protected Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        onCreateDrawer();

        plant = (Spinner) findViewById(R.id.activity_filter_plant);
        month = (Spinner) findViewById(R.id.activity_filter_month);
        mode = (Spinner) findViewById(R.id.activity_filter_mode);

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



    }

    public void filter(View v) {

        // FILTRAR LOS DATOS DE BASE DE DATOS

        String plantSelect =  plant.getSelectedItem().toString();
        String monthSelect =  month.getSelectedItem().toString();
        String modeSelect =  mode.getSelectedItem().toString();
                /*
    Queries
    Si selecciona Planta (default) - Mes (default) - Sow ----------> Regresa todas las plantas (Cardview de la planta) YA
    Si selecciona Planta - Mes (default) - Sow --------------------> getAllMonthsByPlant en ControlMonth (Lista de meses)
    Si selecciona Planta (default)- Mes - Sow ---------------------> getAllPlantsByMonth (Card View de Planta con period) YA
    Si selecciona Planta - Mes - Sow ------------------------------> Si lo encuentra, un texto que diga->Possible*/
        if(plantSelect.equals("Default")){
            Intent intent = new Intent(this, ActivityShowFilter.class);
            intent.putExtra("plantSelect", plantSelect);
            intent.putExtra("monthSelect", monthSelect);
            intent.putExtra("modeSelect", modeSelect);
            startActivity(intent);
        }
        else {
            //getAllMonthsByPlant en ControlMonth (Lista de meses)
            Intent intent = new Intent(this, ActivitySingleCard.class);
            intent.putExtra("plantSelect", plantSelect);
            intent.putExtra("monthSelect", monthSelect);
            intent.putExtra("modeSelect", modeSelect);
            startActivity(intent);
        }

    }
}
