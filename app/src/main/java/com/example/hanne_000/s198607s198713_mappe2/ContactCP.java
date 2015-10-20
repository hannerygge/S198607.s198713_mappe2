package com.example.hanne_000.s198607s198713_mappe2;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class ContactCP extends ContentProvider {

    public static final String _ID = "_id";
    public static final String TITTEL = "Title";
    private static final String DB_NAVN = "Contacts.db";
    private static final int DB_VERSJON = 1;
    private static final String TABELL = "Kontakter";
    public final static String PROVIDER = "com.example.hanne_000.s198607s198713_mappe2";

    SQLiteDatabase db;
    DBHandler dbh = new DBHandler(getContext());

    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER + "/Contact");

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor cursor = null;
        cursor = db.query(TABELL,projection, _ID + " = " + uri.getPathSegments().get(1), selectionArgs, null, null, sortOrder);

    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbh.getWritableDatabase();
        db.insert(TABELL, null, values);

        Cursor c = db.query(TABELL, null, null, null, null, null, null);
        c.moveToLast();
        long minid = c.getLong(0);
        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, minid);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}

