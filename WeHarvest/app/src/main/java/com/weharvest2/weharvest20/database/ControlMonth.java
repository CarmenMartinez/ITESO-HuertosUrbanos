package com.weharvest2.weharvest20.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.weharvest2.weharvest20.beans.Month;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ControlMonth {
    public Month getMonthById(int idMonth, DataBaseHandler dh) {
        Month month = new Month();
        String selectQuery = "SELECT  S." + DataBaseHandler.KEY_MONTH_ID + ","
                + "S." + DataBaseHandler.KEY_MONTH_NAME
                + " FROM " + DataBaseHandler.TABLE_MONTH;
        
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

    public ArrayList<Month> getAllMonthsByPlant(String plant_name, DataBaseHandler dh) {
        ArrayList<Month> months = new ArrayList<Month>();
        String selectQuery = "SELECT  * FROM " + DataBaseHandler.TABLE_MONTH + " td, "
                + DataBaseHandler.TABLE_PLANT + " tg, " + DataBaseHandler.TABLE_SOW_MONTH_PLANT + " tt WHERE tg."
                + DataBaseHandler.KEY_PLANT_NAME + " = '" + plant_name + "'" + " AND tg." + DataBaseHandler.KEY_MONTH_ID
                + " = " + "tt." + DataBaseHandler.KEY_PLANT_ID + " AND td." + DataBaseHandler.KEY_PLANT_ID + " = "
                + "tt." + DataBaseHandler.KEY_MONTH_ID;

        //Log.e(LOG, selectQuery);

        SQLiteDatabase db = dh.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Month td = new Month();
                td.setIdMonth(c.getInt((c.getColumnIndex(DataBaseHandler.KEY_MONTH_ID))));
                td.setMonthName(c.getString(c.getColumnIndex(DataBaseHandler.KEY_MONTH_NAME)));

                // adding to todo list
                months.add(td);
            } while (c.moveToNext());
        }

        return months;
    }


    public ArrayList<Month> getMonths(DataBaseHandler dh) {
        ArrayList<Month> months = new ArrayList<>();
        String selectQuery = "SELECT  S." + DataBaseHandler.KEY_MONTH_ID + ","
                + "S." + DataBaseHandler.KEY_MONTH_NAME
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
