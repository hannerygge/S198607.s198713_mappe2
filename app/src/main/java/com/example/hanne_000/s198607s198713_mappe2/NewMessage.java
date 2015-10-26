package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
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

/**
 * Created by hanne_000 on 22.10.2015.
 */
public class NewMessage extends AppCompatActivity implements View.OnClickListener{

    EditText etMessage;
    EditText et;
    Calendar c;
    int hour;
    int minute;
    ImageButton timeButton;
    ImageButton saveButton;



    public void updateOnClick(){
        saveButton = (ImageButton) findViewById(R.id.savestandardsessage);
        saveButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createMessage();
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

    public void createMessage(){


        String m = etMessage.getText().toString(); // get melding;
        String t = et.getText().toString(); //get tidspunkt



        Message melding = new Message( m,t);
        melding.setID(1);

        DBHandler db = new DBHandler(getApplicationContext());
        db.editMessage(melding);
        //toast
        Toast.makeText(getApplicationContext(), R.string.edit_message_toast,
                Toast.LENGTH_SHORT).show();
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
        etMessage = (EditText) findViewById(R.id.standardmessage);
        timeButton.setOnClickListener(this);

        updateOnClick();

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
                Intent i = new Intent(this, NewContact.class);
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
                Intent intent = new Intent(this, Settings.class);
                startActivity(intent);


                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

}
