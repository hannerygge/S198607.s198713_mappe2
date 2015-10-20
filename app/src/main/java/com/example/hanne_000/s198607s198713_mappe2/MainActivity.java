package com.example.hanne_000.s198607s198713_mappe2;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Settings.DialogClickListener{

    Button test;
    Button test1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // onClickTestButton();
        //onClickTest1Button();

        if(findViewById(R.id.contactlistlayout) != null)
        {
            if(savedInstanceState != null)
                return;

          /*

          // Ikke contacts, men info fra DB

            Contacts contactFragment = new Contacts();
            contactFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.contactlistlayout, contactFragment).commit();
*/
        }
    }



    /*public void onClickTestButton()
    {
        test = (Button)findViewById(R.id.testing);
        test.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new DatePickerFragment();
                dialog.show(getFragmentManager(), "Avslutt");
            }
        });

    }
        //Testing av fragmenter
    public void onClickTest1Button()
    {
        test1 = (Button)findViewById(R.id.testing1);
        test1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new TimePickerFragment();
                dialog.show(getFragmentManager(), "Avslutt");
            }
        });

    }*/
    @Override
    public void onYesClick()
    {
        return;
    }

    public  void onFinishClick()
    {
        return;
    }

    @Override
    public void onNoClick()
    {
        return;

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
            case R.id.newcontact:
                Intent i = new Intent(this, NewContact.class);
                startActivity(i);
                return true;

            case R.id.message:
                Intent j = new Intent(this, Message.class);
                //startActivity(j);
                startActivityForResult(j, 555);
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
