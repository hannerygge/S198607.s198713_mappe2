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
    DBHandler dbh;
    private static final UriMatcher uriMatcher;

    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER + "/Contact");

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER, "Contact", Contacts);
        uriMatcher.addURI(PROVIDER, "Contact/#", Contact);
    }

    public ContactCP(){
        Context test = getContext();
        if(test == null) {throw new IndexOutOfBoundsException();}
        dbh = new DBHandler(test);
        if(dbh == null) {throw new IndexOutOfBoundsException();}
        db = dbh.getReadableDatabase();
        if(db == null) {throw new IndexOutOfBoundsException();}
    }


    /*private static class DatabaseHelper extends SQLiteOpenHelper{ // prøver noe

        public DatabaseHelper(Context context) {
            super(context, DB_NAVN, null, DB_VERSJON);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
             String CREATE_TABLE = "CREATE TABLE " + TABLE + "(" + _ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"  + BIRTHDAY + " TEXT,"+ PHONENUMBER + " TEXT," + MESSAGE + " TEXT"  + ")";
            Log.d("SQL", CREATE_TABLE);
            db.execSQL(CREATE_TABLE);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
*/
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public boolean onCreate() {

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Cursor cur = null;
        if(uriMatcher.match(uri) == Contact)
        {
            if(db == null) {throw new IndexOutOfBoundsException();}
            cur = this.db.query(TABLE, projection, _ID + " = " + uri.getPathSegments().get(1), selectionArgs, null, null, sortOrder);
        }
        else
        {
            if(db == null) {throw new IndexOutOfBoundsException();}
            cur = this.db.query(TABLE, null, null, null, null, null, null, null);
        }

        /*SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        queryBuilder.setTables(dbh.TABLE_CONTACTS);


        int uriType = uriMatcher.match(uri);

        switch (uriType){
            case 1:
                queryBuilder.appendWhere(dbh.KEY_ID + "=" + uri.getLastPathSegment());
                break;
            case 2:
                break;
            default:
                throw new IllegalArgumentException("Unknown URI");

        }
        Cursor cursor = queryBuilder.query(dbh.getReadableDatabase(), projection,selection, selectionArgs, null, null, sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(), uri);*/
        return cur;

    }

    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case Contacts:
                return "vnd.android.cursor.dir/com.example.hanne_000.s198607s198713_mappe2";
            case Contact:
                return "vnd.android.cursor.item/com.example.hanne_000.s198607s198713_mappe2";
            default:
                throw new IllegalArgumentException("Ugyldig URI: " + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db2 = dbh.getWritableDatabase();
        db2.insert(TABLE, null, values);

        Cursor c = db2.query(TABLE, null, null, null, null, null, null);
        c.moveToLast();
        long minid = c.getLong(0);
        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, minid);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
    public Cursor getAllContacts(){
        String[] mProjection = {"Name"};
        String mSelectionClause = null;
        String[] mSelectionArgs = null;
        String sortOrder = "Name";
        Cursor test = query(CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, sortOrder);
        if(null == test)
        {
            String test2 = "damn!";
        }
        return test;
    }
}

