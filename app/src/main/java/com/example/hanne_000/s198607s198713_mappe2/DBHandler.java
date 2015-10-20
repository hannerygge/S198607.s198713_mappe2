package com.example.hanne_000.s198607s198713_mappe2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;

/**
 * Created by hanne_000 on 20.10.2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    static String TABLE_CONTACTS = "Kontakter";
    static String KEY_ID = "_ID";
    static String NAME = "Name";
    static Date BIRTHDAY;
    static String PHONENUMBER = "Phone";
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "Contacts";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"  + BIRTHDAY + " DATE," + PHONENUMBER + " TEXT" + ")";
        Log.d("SQL", CREATE_TABLE);
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
