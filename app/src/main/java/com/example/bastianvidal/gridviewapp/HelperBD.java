package com.example.bastianvidal.gridviewapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HelperBD extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "create table sistema (" +
                    "id integer PRIMARY KEY," +
                    "nombre TEXT," +
                    "radio TEXT," +
                    "edad integer," +
                    "descripcion TEXT," +
                    "distancia_sol integer," +
                    "nombre_img TEXT)";

    public HelperBD(Context context) {
        super(context, "Market.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void deleteDB(SQLiteDatabase db){
        db.execSQL("drop table productos");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
