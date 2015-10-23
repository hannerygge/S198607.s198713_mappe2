package com.example.hanne_000.s198607s198713_mappe2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Widget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews updateViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.widget_layout);

        //Endre under for hva som skal skje i widgeten.
        //Bruke URI mot ContactCP for å hente ut dataene. (må kanskje sorteres slik at den som har bursdag nærmest kommer først.
        String output = "";

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df2 = new SimpleDateFormat("dd-mm-yyyy");
        String Today = df2.format(c.getTime());

        String[] mProjection = {"rowid as _id", "Name", "Birthday", "Phone", "Message"};
        String mSelectionClause = "Birthday = " + Today;
        String[] mSelectionArgs = null;
        String sortOrder = "Name";
        Cursor cur  = context.getContentResolver().query(ContactCP.CONTENT_URI, mProjection,mSelectionClause,mSelectionArgs,sortOrder);

        //Cursor cur = cp.dbh.getBirthdayPeople(Today);
        cur.moveToFirst();
        while(cur.moveToNext()){
            output += cur.getString(cur.getColumnIndex("Name")) + ", ";
        }

        updateViews.setTextViewText(R.id.widgettekst2, output);


        //Uri u  Uri.parse("content://" + PROVIDER + "/Contact");
        //MyCursor test = cp.query(Uri u, String[] projection, String selection, String[] selectionArgs, String sortOrder);

        //--------------------------------------------

        Intent clickIntent = new Intent(context, Widget.class);
        clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        updateViews.setOnClickPendingIntent(R.id.widgettekst, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetIds, updateViews);
    }
}