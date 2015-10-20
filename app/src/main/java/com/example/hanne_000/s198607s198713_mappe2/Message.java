package com.example.hanne_000.s198607s198713_mappe2;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Message extends AppCompatActivity{

    String StandardMessage; //Must get this from database!
    TimePicker dp; //get from db

    Button button;
    public void UpdateOnClick(){
        button = (Button) findViewById(R.id.SaveStandardMessage);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                updateStandardMessage(findViewById(R.id.StandardMessage).toString());
            }
        });
    }

    public void updateStandardMessage(String message)
    {
        StandardMessage = message;

        //update database
        //update time
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        UpdateOnClick();
        //update time from db

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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




        switch (item.getItemId()) {
            case R.id.newcontact:
                Intent i = new Intent(this, Contact.class);
                startActivity(i);
                return true;

            case R.id.calendar:
                Intent k = new Intent(this, Calendar.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;

            case R.id.settings:
              /*  Intent l = new Intent(this, Settings.class);
                //startActivity(j);
                startActivityForResult(l, 555);
                */

                DialogFragment dialog = new Settings();
                dialog.show(getFragmentManager(), "test9");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
