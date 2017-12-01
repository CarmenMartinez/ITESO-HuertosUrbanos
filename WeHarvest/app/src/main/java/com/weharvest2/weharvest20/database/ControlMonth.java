package com.weharvest2.weharvest20.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.weharvest2.weharvest20.beans.Month;

import java.util.ArrayList;

/**
 * Created by luisacfl on 27/11/17.
 */

public class ControlMonth {
    DataBaseHandler dh;
    ArrayList<Month> myMonths;

    public ControlMonth(DataBaseHandler dh){
        this.dh = dh;
        myMonths = getMonths();
    }

    public ArrayList<Month> getMonths() {
        ArrayList<Month> months = new ArrayList<>();
        String selectQuery = "SELECT " + DataBaseHandler.KEY_MONTH_ID + ", "
                + DataBaseHandler.KEY_MONTH_NAME
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
        return months;
    }

    public Month getMonthById(int idMonth) {
        return myMonths.get(idMonth-1);
    }

}
