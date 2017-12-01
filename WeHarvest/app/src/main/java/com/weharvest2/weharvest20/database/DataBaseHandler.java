package com.weharvest2.weharvest20.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by luisacfl on 26/11/17.
 */

public class DataBaseHandler extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "other.db";
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
    public static final String KEY_MONTH_ID = "idMonth";
    public static final String KEY_MONTH_NAME = "name";

    //Plant
    public static final String  KEY_PLANT_ID = "idPlant";
    public static final String KEY_PLANT_NAME = "name";
    public static final String  KEY_PERIOD= "period";
    public static final String KEY_DESCRIPTION = "description";

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
                + KEY_PERIOD +" TEXT,"
                + KEY_DESCRIPTION+" TEXT)";

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

        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (1, 'Acelga', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (2, 'Ajo', '8-4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (3, 'Alcachofa', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (4, 'Apio', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (5, 'Berenjena', '5-6 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (6, 'Borraja', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (7, 'Brócoli', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (8, 'Calabacin', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (9, 'Calabaza', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (10, 'Canónigos', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (11, 'Cardillo', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (12, 'Cardo', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (13, 'Cebolla', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (14, 'Cohollo', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (15, 'Col', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (16, 'Coliflor', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (17, 'Escarola', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (18, 'Espárrago', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (19, 'Espinaca', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (20, 'Fresas', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (21, 'Guisante', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (22, 'Haba', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (23, 'Judías', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (24, 'Lechuga', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (25, 'Maíz', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (26, 'Melón', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (27, 'Nabo', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (28, 'Patata', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (29, 'Pepino', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (30, 'Perejil', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (31, 'Pimiento', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (32, 'Puerro', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (33, 'Rabanilla', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (34, 'Rábano', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (35, 'Remolacha', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (36, 'Sandía', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (37, 'Tomate', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");
        db.execSQL("INSERT INTO " + TABLE_PLANT + " (" + KEY_PLANT_ID + "," + KEY_PLANT_NAME + "," + KEY_PERIOD  + "," + KEY_DESCRIPTION + ") VALUES (38, 'Zanahoria', '4 meses', 'This is an example of a description. This plant is very good for your health. Eat it.')");


        String CREATE_SOW_MONTH_PLANT_TABLE ="CREATE TABLE "+ TABLE_SOW_MONTH_PLANT + "("
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
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (2, 4)");

        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 5)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 32)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 33)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 36)");

        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 1)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 2)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 3)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 4)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 5)");

        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 6)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 7)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 8)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 9)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 10)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 11)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 12)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 13)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 14)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 15)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 16)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 17)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 18)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 19)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 20)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 4)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 5)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 32)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 33)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 36)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 21)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 22)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 23)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 24)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 25)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 26)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 27)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 28)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 29)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 30)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 31)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 32)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 33)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 34)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 5)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 6)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 7)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 8)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 9)");
        db.execSQL("INSERT INTO " + TABLE_SOW_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 10)");

        String CREATE_HARVEST_MONTH_PLANT_TABLE ="CREATE TABLE "+ TABLE_HARVEST_MONTH_PLANT + "("
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

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 4)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 5)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 32)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 33)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (3, 36)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 6)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 5)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 3)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 2)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (4, 2)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 1)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 38)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 37)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 36)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (5, 35)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 34)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 35)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 33)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 32)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (6, 31)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 30)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 29)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 28)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 27)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (7, 26)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 25)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 24)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 23)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 22)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (8, 21)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 20)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 19)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 18)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 17)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (9, 16)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 14)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 15)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 13)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 12)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (10, 11)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 10)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 9)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 8)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 7)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (11, 6)");

        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 5)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 4)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 3)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 2)");
        db.execSQL("INSERT INTO " + TABLE_HARVEST_MONTH_PLANT + " ("+KEY_MONTH_ID+","+KEY_PLANT_ID+") VALUES (12, 1)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
