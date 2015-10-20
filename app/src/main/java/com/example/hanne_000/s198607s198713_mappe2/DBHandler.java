package com.example.hanne_000.s198607s198713_mappe2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by hanne_000 on 20.10.2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    static String TABLE_CONTACTS = "Kontakter";
    static String KEY_ID = "_ID";
    static String NAME = "Name";
    static String BIRTHDAY = "Birthday";
    static String PHONENUMBER = "Phone";
    static String MESSAGE = "Message";
    static int DATABASE_VERSION = 1;
    static String DATABASE_NAME = "Contacts";
    SQLiteDatabase db;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"  + BIRTHDAY + " DATE,"+ PHONENUMBER + " TEXT" + MESSAGE + " TEXT,"  + ")";
        Log.d("SQL", CREATE_TABLE);
        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CONTACTS);
        onCreate(db);

    }

    public void addContact(Contact newcontact)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME, newcontact.getName());
        values.put(BIRTHDAY, newcontact.getBirthday());
        values.put(PHONENUMBER, newcontact.getPhonerNr());
        values.put(MESSAGE, newcontact.getMessage());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();

    }

    public int update(Contact contact)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, contact.getName());
        values.put(BIRTHDAY, contact.getBirthday());
        values.put(PHONENUMBER, contact.getPhonerNr());
        values.put(MESSAGE, contact.getMessage());


        int updated = db.update(TABLE_CONTACTS, values, KEY_ID + "=?", new String[]{String.valueOf(contact.getId())});
        db.close();
        return updated;
    }

    public void deleteContact(Contact contact)
    {
        db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "=?", new String[]{String.valueOf(contact.getId())});
        db.close();
    }

}
