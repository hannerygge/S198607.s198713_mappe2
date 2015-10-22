package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import java.util.Locale;

/**
 * Created by hanne_000 on 19.10.2015.
 */
public class Settings extends AppCompatActivity implements SettingsFragment.DialogClickListener{

    Button languageButton;
    @Override
    public void onFinishClick() {

    }

    @Override
    public void onYesClick() {

    }

    @Override
    public void onNoClick() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        onClickLanguageButton();
    }


    public void onClickLanguageButton()
    {
        languageButton = (Button)findViewById(R.id.fragmentbutton);
        languageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new SettingsFragment();
                dialog.show(getFragmentManager(), "Avslutt");
            }
        });

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
                Intent i = new Intent(this, NewMessage.class);
                startActivity(i);
                return true;

          /*  case R.id.calendar:
                Intent k = new Intent(this, Calendar.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;
*/
            case R.id.message:
              /*  Intent l = new Intent(this, Settings.class);
                //startActivity(j);
                startActivityForResult(l, 555);
                */

                Intent intent = new Intent(this, NewMessage.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

}