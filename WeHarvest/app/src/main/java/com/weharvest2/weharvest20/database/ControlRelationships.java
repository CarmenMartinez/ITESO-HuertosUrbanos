package com.weharvest2.weharvest20.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ControlRelationships {
    String mode;
    DataBaseHandler dh;
    ArrayList<Integer[]> r = new ArrayList<>();
    String selectQuery = "";

    public ControlRelationships(DataBaseHandler dh, String mode) {
        this.dh = dh;
        this.mode = mode;
        setAllRelationships();
    }

    public void setAllRelationships(){
        if(mode.equals("Sow")){
            selectQuery = "SELECT " + DataBaseHandler.KEY_MONTH_ID + ", "
                    + DataBaseHandler.KEY_PLANT_ID
                    + " FROM " + DataBaseHandler.TABLE_SOW_MONTH_PLANT;
        }
        else {
            selectQuery = "SELECT " + DataBaseHandler.KEY_MONTH_ID + ", "
                    + DataBaseHandler.KEY_PLANT_ID
                    + " FROM " + DataBaseHandler.TABLE_HARVEST_MONTH_PLANT;
        }

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Integer[] relation = new Integer[2];

            relation[0]= cursor.getInt(0);
            relation[1]= cursor.getInt(1);

            //plant.setMonths(cm.getAllMonthsByPlant(plant.getPlantName(), dh));
            r.add(relation);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
    }


    public ArrayList<Integer[]> getAllRelationships(DataBaseHandler dh){
        return r;
    }

}
