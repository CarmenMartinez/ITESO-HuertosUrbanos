package com.weharvest2.weharvest20;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weharvest2.weharvest20.beans.Plant;
import com.weharvest2.weharvest20.database.DBManager;
import com.weharvest2.weharvest20.database.DataBaseHandler;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ActivityShowFilter extends ActivityBase {


    /*
    Hacer dos card views
    Cuando se seleccione la planta
    se buscan todos los meses que se relacionan con la planta
     */

    /*
    Queries
    Si selecciona Planta (default) - Mes (default) - Sow ----------> Regresa todas las plantas (Cardview de la planta)
    Si selecciona Planta - Mes (default) - Sow --------------------> getAllMonthsByPlant en ControlMonth (Lista de meses)
    Si selecciona Planta (default)- Mes - Sow ---------------------> getAllPlantsByMonth (Card View de Planta con period)
    Si selecciona Planta - Mes - Sow ------------------------------> Si lo encuentra, un texto que diga->Possible

    Si selecciona Planta (default) - Mes (default) - Harvest
    Si selecciona Planta - Mes (default) - Harvest
    Si selecciona Planta (default)- Mes - Harvest
    Si selecciona Planta - Mes - Harvest

    DEJARLO AL FINAL
    Si selecciona Planta (default) - Mes (default) - Sow&Harvest
    Si selecciona Planta - Mes (default) - Sow&Harvest
    Si selecciona Planta (default)- Mes - Sow&Harvest
    Si selecciona Planta - Mes - Sow&Harvest


     */

    private RecyclerView recyclerView;
    private PlantAdapter adapter;
    private ArrayList<Plant> plantList;
    DataBaseHandler dh ;
    DBManager db;

    private String plant;
    private String month;
    private String mode;

    public ActivityShowFilter(){

    }
    public ActivityShowFilter(String plant, String month, String mode){
        this.plant = plant;
        this.month = month;
        this.mode = mode;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_filter);

        onCreateDrawer();

        plant = getIntent().getStringExtra("plantSelect");
        month = getIntent().getStringExtra("monthSelect");
        mode = getIntent().getStringExtra("modeSelect");

        dh = DataBaseHandler.getInstance(this);
        db = new DBManager(dh, mode);

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        plantList = new ArrayList<>();


        adapter = new PlantAdapter(this, plantList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        //recipeList=recipes.getRecipes();

        preparePlants();

    }

    public void preparePlants(){

        //DBManager db = new DBManager(dh);
        if(plant.equals("Default") && month.equals("Default")){
            //plantList = db.getPlantList();
            for(int i=0; i<db.getPlantList().size(); i++){
                plantList.add(db.getPlantList().get(i));
            }

        }
        else if(plant.equals("Default") && !(month.equals("Default"))){
            for(int i=0; i<db.getPlantListFromMonth(db.getMonthByName(month)).size(); i++){
                plantList.add(db.getPlantListFromMonth(db.getMonthByName(month)).get(i));
            }
        }

         /*
        Queries
        Si selecciona Planta (default) - Mes (default) - Sow ----------> Regresa todas las plantas (Cardview de la planta) LISTO
        Si selecciona Planta - Mes (default) - Sow --------------------> getAllMonthsByPlant en ControlMonth (Lista de meses)
        Si selecciona Planta (default)- Mes - Sow ---------------------> getAllPlantsByMonth (Card View de Planta con period)
        Si selecciona Planta - Mes - Sow ------------------------------> Si lo encuentra, un texto que diga->Possible

        /*
        Aquí recibiría la lista en donde estan guardadas las recetas
        y agregaria al arraylist local las que sean iguales a la categoria
        luego ya las imprimiría
         */
        adapter.notifyDataSetChanged();
    }
}
