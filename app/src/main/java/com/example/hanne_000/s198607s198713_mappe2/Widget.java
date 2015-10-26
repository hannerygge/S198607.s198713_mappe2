package com.example.hanne_000.s198607s198713_mappe2;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Widget extends AppWidgetProvider {
   @Override
        public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
            RemoteViews updateViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.widget_layout);
            Date date = new Date();
            java.text.DateFormat format = SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM, Locale.getDefault());
            updateViews.setTextViewText(R.id.widgettekst2, "Klokka er: " + format.format(date));
            Context tada = context;
            ContactCP cp = new ContactCP();
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df2 = new SimpleDateFormat("dd-mm-yyyy");
            String Today = df2.format(c.getTime());

            String[] mProjection = {"rowid as _id", "Name", "Birthday", "Phone", "Message"};
            String mSelectionClause = null;//"Birthday = " + Today;
            String[] mSelectionArgs = null;
            String groupby = null;
            String having = null;
            String sortOrder = null;
            Cursor cur = cp.query(ContactCP.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, sortOrder);
            String output = "";
            if(null != cur)
            {
                if(!(cur.getCount() < 1)){
                    while(cur.moveToNext()){
                        output += cur.getString(cur.getColumnIndex("Name"));
                    }
                }
            }
            Intent clickIntent = new Intent(context, Widget.class);
            clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
            updateViews.setOnClickPendingIntent(R.id.widgettekst2, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetIds, updateViews);
        }
    }








        /*super.onUpdate(context, appWidgetManager, appWidgetIds);

        //RemoteViews updateViews = new RemoteViews(context.getApplicationContext().getPackageName(), R.layout.widget_layout);

        //Endre under for hva som skal skje i widgeten.
        //Bruke URI mot ContactCP for å hente ut dataene. (må kanskje sorteres slik at den som har bursdag nærmest kommer først.
        String output = "";
        ContactCP cp = new ContactCP();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df2 = new SimpleDateFormat("dd-mm-yyyy");
        String Today = df2.format(c.getTime());

        String[] mProjection = {"rowid as _id", "Name"};
        String mSelectionClause = null;
        String[] mSelectionArgs = null;
        String sortOrder = null;
        Cursor cur;
        cur = context.getContentResolver().query(cp.CONTENT_URI, mProjection, mSelectionClause, mSelectionArgs, sortOrder);

        if(cur == null) {throw new IndexOutOfBoundsException();}
        if (!(cur.getCount() < 1)){
            cur.moveToFirst();
            while (cur.moveToNext()) {
                output += cur.getString(cur.getColumnIndex("Name")) + ", ";
            }
        } else {
            output = "No Birthdays today";
        }

        //updateViews.setTextViewText(R.id.widgettekst2, output);


        //Uri u  Uri.parse("content://" + PROVIDER + "/Contact");
        //MyCursor test = cp.query(Uri u, String[] projection, String selection, String[] selectionArgs, String sortOrder);

        //--------------------------------------------
/*
        Intent clickIntent = new Intent(context, Widget.class);
        clickIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        clickIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT);
       // updateViews.setOnClickPendingIntent(R.id.widgettekst, pendingIntent);
        //appWidgetManager.updateAppWidget(appWidgetIds, updateViews);
    }
}*/
