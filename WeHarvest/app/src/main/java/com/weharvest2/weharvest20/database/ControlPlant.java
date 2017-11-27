package com.weharvest2.weharvest20.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.weharvest2.weharvest20.beans.Month;
import com.weharvest2.weharvest20.beans.Plant;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ControlPlant {
    public Plant getPlantById(int idPlant, DataBaseHandler dh) {
        Plant plant = new Plant();
        String selectQuery = "SELECT  S." + DataBaseHandler.KEY_PLANT_ID + ","
                + "S." + DataBaseHandler.KEY_PLANT_NAME+","
                +" S." + DataBaseHandler.KEY_PERIOD
                + " FROM " + DataBaseHandler.TABLE_PLANT;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            plant.setIdPlant(cursor.getInt(0));
            plant.setPlantName(cursor.getString(1));
            plant.setPeriod(cursor.getString(2));
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        // return store
        return plant;
    }

    public Month getMonthByPlantId(int idPlant, DataBaseHandler dh) {
        Month month = new Month();
        String selectQuery = "SELECT  S." + DataBaseHandler.KEY_PLANT_ID + ","
                + "S." + DataBaseHandler.KEY_PLANT_NAME
                + " FROM " + DataBaseHandler.TABLE_PLANT  + " C, "
                + DataBaseHandler.TABLE_SOW_MONTH_PLANT + " SP WHERE SP."
                + DataBaseHandler.KEY_PLANT_ID + " = " + idPlant + " AND SP." +
                DataBaseHandler.KEY_PLANT_ID + "= S." + DataBaseHandler.KEY_PLANT_ID;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            month.setIdMonth(cursor.getInt(0));
            month.setMonthName(cursor.getString(1));
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        // return store
        return month;
    }

    public ArrayList<Month> getMonths(DataBaseHandler dh) {
        ArrayList<Month> months = new ArrayList<>();
        String selectQuery = "SELECT  S." + DataBaseHandler.KEY_PLANT_ID + ","
                + "S." + DataBaseHandler.KEY_PLANT_NAME
                + " FROM " + DataBaseHandler.TABLE_MONTH;

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {
            Month month = new Month();
            month.setIdMonth(cursor.getInt(0));
            month.setMonthName(cursor.getString(1));
            months.add(month);
        }
        try {
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        db = null;
        cursor = null;
        // return store
        return months;
    }


}
