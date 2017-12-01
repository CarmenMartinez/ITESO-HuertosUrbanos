package com.weharvest2.weharvest20.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.weharvest2.weharvest20.beans.Plant;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ControlPlant {

    DataBaseHandler dh;
    ArrayList<Plant> p = new ArrayList<>();

    public ControlPlant (DataBaseHandler dh){
        this.dh = dh;
        p=getPlants();
    }

    public ArrayList<Plant> getPlants() {
        ControlMonth cm = new ControlMonth(dh);
        ArrayList<Plant> plants = new ArrayList<>();
        String selectQuery = "SELECT " + DataBaseHandler.KEY_PLANT_ID + ", "
                + DataBaseHandler.KEY_PLANT_NAME+ ", "
                + DataBaseHandler.KEY_PERIOD
                + " FROM " + DataBaseHandler.TABLE_PLANT;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Plant plant = new Plant();
            plant.setIdPlant(cursor.getInt(0));
            plant.setPlantName(cursor.getString(1));
            plant.setPeriod(cursor.getString(2));
            //plant.setMonths(cm.getAllMonthsByPlant(plant.getPlantName(), dh));
            plants.add(plant);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;

        return plants;
    }

    public Plant getPlantById(int id){
        return p.get(id-1);
    }

}
