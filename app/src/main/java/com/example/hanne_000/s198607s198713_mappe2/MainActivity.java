package com.example.hanne_000.s198607s198713_mappe2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/


        switch (item.getItemId()) {
            case R.id.endreenkontakt:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.test:
                Intent j = new Intent(this, MainActivity.class);
                //startActivity(j);
                startActivityForResult(j, 555);
                return true;
/*
            case R.id.test1:
                Intent k = new Intent(this, MainActivity.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;

            case R.id.test2:
                Intent l = new Intent(this, MainActivity.class);
                //startActivity(j);
                startActivityForResult(l, 555);
                return true;
*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
