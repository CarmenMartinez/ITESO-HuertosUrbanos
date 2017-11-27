package com.weharvest2.weharvest20.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luisacfl on 26/11/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "MyCalendar.db";
    private static final int DATABASE_VERSION = 1;

    //Table names
    public static final String TABLE_MONTH ="month";
    public static final String TABLE_PLANT ="plant";
    public static final String TABLE_SOW_MONTH_PLANT ="sow";
    public static final String TABLE_HARVEST_MONTH_PLANT ="harvest";

    /*
    Se tendrían que crear dos tablas extra para los plazos, por ahora van a ser el mismo
    pero sería
    1 de plantas-plazo de siembra
    1 de plantas-plazo de cosecha

    y luego se relacionan esas con la de table sow month plant y table harvest, respectivamente
    Toda la info sacada de: https://www.ecoagricultor.com/calendario-de-siembra/
     */

    //Month
    public static final String  KEY_MONTH_ID = "idMonth";
    public static final String KEY_MONTH_NAME = "name";

    //Plant
    public static final String  KEY_PLANT_ID = "idMonth";
    public static final String KEY_PLANT_NAME = "name";
    public static final String  KEY_PERIOD= "period";

    private static DataBaseHandler dataBaseHandler;
    private DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public static DataBaseHandler getInstance(Context context){
        if(dataBaseHandler == null){
            dataBaseHandler = new DataBaseHandler(context);
        }
        return dataBaseHandler;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLANT_TABLE = "CREATE TABLE " + TABLE_PLANT + "("
                + KEY_PLANT_ID + " INTEGER PRIMARY KEY,"
                + KEY_PLANT_NAME + " TEXT,"
                + KEY_PERIOD + " TEXT)";

        db.execSQL(CREATE_PLANT_TABLE);

        String CREATE_MONTH_TABLE = "CREATE TABLE " + TABLE_MONTH + "("
                + KEY_MONTH_ID + " INTEGER PRIMARY KEY,"
                + KEY_MONTH_NAME + " TEXT)";

        db.execSQL(CREATE_MONTH_TABLE);

        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (1, 'January')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (2, 'February')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (3, 'March')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (4, 'April')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (5, 'May')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (6, 'June')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (7, 'July')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (8, 'August')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (9, 'September')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (10, 'October')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (11, 'November')");
        db.execSQL("INSERT INTO " + TABLE_MONTH + " (" + KEY_MONTH_ID + "," + KEY_MONTH_NAME + ") VALUES (12, 'December')");

        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (1, 'Acelga', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (2, 'Ajo', '8-4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (3, 'Alcachofa', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (4, 'Apio', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (5, 'Berenjena', '5-6 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (35, 'Borraja', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (36, 'Brócoli', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (6, 'Calabacin', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (7, 'Calabaza', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (37, 'Canónigos', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (8, 'Cardillo', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (9, 'Cardo', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (10, 'Cebolla', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (11, 'Cohollo', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (12, 'Col', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (13, 'Coliflor', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (14, 'Escarola', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (15, 'Espárrago', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (16, 'Espinaca', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (17, 'Fresas', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (18, 'Guisante', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (19, 'Haba', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (20, 'Judías', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (21, 'Lechuga', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (22, 'Maíz', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (23, 'Melón', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (24, 'Nabo', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (25, 'Patata', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (26, 'Pepino', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (41, 'Perejil', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (27, 'Pimiento', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (28, 'Puerro', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (29, 'Rabanilla', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (30, 'Rábano', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (31, 'Remolacha', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (32, 'Sandía', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (33, 'Tomate', '4 meses')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + ") VALUES (34, 'Zanahoria', '4 meses')");

        String CREATE_SOW_MONTH_PLANT_TABLE ="CREATE TABLE"+ TABLE_SOW_MONTH_PLANT + "("
                + KEY_MONTH_ID + " INTEGER,"
                + KEY_PLANT_ID + " INTEGER)";

        db.execSQL(CREATE_SOW_MONTH_PLANT_TABLE);

        //ENERO
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 2)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 4)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 5)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 35)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 36)");

        //FEBRERO
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 4)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 5)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 32)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 33)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 36)");

        String CREATE_HARVEST_MONTH_PLANT_TABLE ="CREATE TABLE"+ TABLE_HARVEST_MONTH_PLANT + "("
                + KEY_MONTH_ID + " INTEGER,"
                + KEY_PLANT_ID + " INTEGER)";

        db.execSQL(CREATE_HARVEST_MONTH_PLANT_TABLE);

        //ENERO
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 2)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 4)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 5)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 35)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (1, 36)");

        //FEBRERO
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 4)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 5)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 32)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 33)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 36)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
