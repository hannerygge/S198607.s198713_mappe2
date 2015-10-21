package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Message extends AppCompatActivity implements Settings.DialogClickListener, View.OnClickListener {

    String StandardMessage; //Must get this from database!

    EditText et;
    Calendar c;
    int hour;
    int minute;
    ImageButton timeButton;
    Button saveButton;


    @Override
    public void onYesClick() {
        return;
    }

    @Override
    public void onNoClick() {
        return;
    }

    @Override
    public void onFinishClick() {
        return;

    }

    public void UpdateOnClick(){
        saveButton = (Button) findViewById(R.id.savestandardsessage);
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                updateStandardMessage(findViewById(R.id.standardmessage).toString());
            }
        });
    }


   /* public void timePickerOnClick(){
        timeButton = (ImageButton) findViewById(R.id.choosetime);
        timeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                DialogFragment dialog = new TimePickerFragment();
                dialog.show(getFragmentManager(), "tekst");
            }
        });
    }*/

    /*public void createMessage(){


        String m = number.getText().toString(); // 12345678;
        String t = message.getText().toString(); //"test";

        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.addContact(tempContact);
        //toast
        Toast.makeText(getApplicationContext(), R.string.new_contact_toast,
                Toast.LENGTH_SHORT).show();
    }
*/


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
        //timePickerOnClick();

        timeButton = (ImageButton) findViewById(R.id.choosetime);
        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        et = (EditText) findViewById(R.id.time);
        timeButton.setOnClickListener(this);


        UpdateOnClick();

        //update time from db

    }

    @Override
    public void onClick(View v){
        showDialog(0);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id){
        return new TimePickerDialog(this, timePickerListener, hour, minute, false);

    }

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener(){
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int min){
            String amPM;
            if(hourOfDay > 12){
                hour = hourOfDay - 12;
                amPM = "PM";
            }
            else{
                hour = hourOfDay;
                amPM = "AM";
            }
            et.setText(hour + " : " + min + " " + amPM);

        }
    };

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

          /*  case R.id.calendar:
                Intent k = new Intent(this, Calendar.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;*/

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
