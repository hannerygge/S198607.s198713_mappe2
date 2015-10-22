package com.example.hanne_000.s198607s198713_mappe2;


import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

public class ContactCP extends ContentProvider {

    public static final String _ID = "_id";
    public int ID;
    public static final String TITTEL = "Title";
    private static final String DB_NAVN = "Contacts";
    private static final int DB_VERSJON = 1;
    private static final String TABLE = "Kontakter";
    public final static String PROVIDER = "com.example.hanne_000.s198607s198713_mappe2";
    private static final int Contact = 1;
    private static final int Contacts = 2;

    SQLiteDatabase db;
    DBHandler dbh = new DBHandler(getContext());
    private static final UriMatcher uriMatcher;

    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER + "/Contact");

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER, "Contact", Contacts);
        uriMatcher.addURI(PROVIDER, "Contact/#", Contact);
    }

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

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(dbh.TABLE_CONTACTS);


        int uriType = uriMatcher.match(uri);

        switch (uriType){
            case 1:
                queryBuilder.appendWhere(dbh.KEY_ID + "=" + uri.getLastPathSegment());
                break;
            case 2:
                queryBuilder.appendWhere(dbh.KEY_ID + "=" + uri.getLastPathSegment());
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");

        }
        Cursor cursor = queryBuilder.query(dbh.getReadableDatabase(), projection,selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;

    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbh.getWritableDatabase();
        db.insert(TABLE, null, values);

        Cursor c = db.query(TABLE, null, null, null, null, null, null);
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

