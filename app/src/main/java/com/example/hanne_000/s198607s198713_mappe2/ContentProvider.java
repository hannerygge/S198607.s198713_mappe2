package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class ContentProvider extends Activity {

    public static String PROVIDER = "com.example.hanne_000.s198607s198613_mappe2";
    public static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER + "/contact");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_provider);
        ContentValues v = new ContentValues();
        v.put("Tittel", "Sult");
        getContentResolver().insert(CONTENT_URI, v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}

