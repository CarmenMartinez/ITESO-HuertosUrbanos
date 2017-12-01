package com.weharvest2.weharvest20;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.weharvest2.weharvest20.beans.Month;
import com.weharvest2.weharvest20.beans.Plant;
import com.weharvest2.weharvest20.database.DBManager;
import com.weharvest2.weharvest20.database.DataBaseHandler;
import com.weharvest2.weharvest20.gui.ActivityBase;

import java.util.ArrayList;

/**
 * Created by luisacfl on 30/11/17.
 */

public class ActivitySingleCard extends ActivityBase {

    private RecyclerView recyclerView;
    private SinglePlantAdapter adapter;
    private ArrayList<Plant> plantList;
    DataBaseHandler dh ;
    DBManager db;

    private String plant;
    private String month;
    private String mode;

    public ActivitySingleCard(){

    }
    public ActivitySingleCard(String plant, String month, String mode){
        this.plant = plant;
        this.month = month;
        this.mode = mode;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_card);

        onCreateDrawer();

        plant = getIntent().getStringExtra("plantSelect");
        month = getIntent().getStringExtra("monthSelect");
        mode = getIntent().getStringExtra("modeSelect");

        dh = DataBaseHandler.getInstance(this);
        db = new DBManager(dh, mode);
        

        recyclerView = (RecyclerView) findViewById (R.id.recycler_view);

        plantList = new ArrayList<>();


        adapter = new SinglePlantAdapter(this, plantList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        //recipeList=recipes.getRecipes();

        preparePlants();

    }

    public void preparePlants(){
        Plant p = new Plant();
        boolean bandera = true;
        //DBManager db = new DBManager(dh);
        if(!(plant.equals("Default")) && month.equals("Default")){
            //plantList = db.getPlantList();
            p=db.getPlantByName(plant);

        }
        else if(!(plant.equals("Default")) && !(month.equals("Default"))){
            //checar si hay match
            p=db.getPlantByName(plant);
            for(int i=0; i<p.getMonths().size(); i++){
                if(p.getMonths().get(i).getMonthName().equals(month)){
                    p=db.getPlantByName(plant);
                    bandera = false;
                }
            }
            if(bandera){
                Month m = new Month();
                m.setMonthName("No months");
                p.setMonths(null);
                p.setPeriod("No period");
                p.setPlantName("This match does not exist");
                p.setIdPlant(-1);
            }

        }
        plantList.add(p);
         /*
        Queries
        Si selecciona Planta (default) - Mes (default) - Sow ----------> Regresa todas las plantas (Cardview de la planta) LISTO
        Si selecciona Planta - Mes (default) - Sow --------------------> getAllMonthsByPlant en ControlMonth (Lista de meses)
        Si selecciona Planta (default)- Mes - Sow ---------------------> getAllPlantsByMonth (Card View de Planta con period) LISTO
        Si selecciona Planta - Mes - Sow ------------------------------> Si lo encuentra, un texto que diga->Possible

        /*
        Aquí recibiría la lista en donde estan guardadas las recetas
        y agregaria al arraylist local las que sean iguales a la categoria
        luego ya las imprimiría
         */
        adapter.notifyDataSetChanged();
    }
}
