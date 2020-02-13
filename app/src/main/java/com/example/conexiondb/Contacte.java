package com.example.conexiondb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class Contacte {

    int id;
    String nom, telefon;
    public Contacte(int id, String nom, String tel){
        this.id = id;
        this.nom = nom;
        this.telefon = tel;
    }

}

class ManeigBBDD extends SQLiteOpenHelper {
    public ManeigBBDD(Context context) {
        super(context, "contactes", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREA_TAULA = "CREATE TABLE CONTACTE(ID INTEGER PRIMARY KEY,NOM TEXT,TELEFON TEXT)";
        db.execSQL(CREA_TAULA); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


