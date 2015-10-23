package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.*;

public class NewContact extends AppCompatActivity implements OnClickListener {


    ImageButton button;
    ImageButton dateButton;
    Calendar c;
    EditText date;
    EditText name;
    EditText number;
    EditText message;
    int day;
    int month;
    int year;



    public void onclicksomething(){
        button = (ImageButton) findViewById(R.id.newcontactbutton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                createContact();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);
        onclicksomething();
        //datePickerOnClick();


        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.testing);
        //getSupportActionBar().setIcon(R.drawable.testing);
        dateButton = (ImageButton) findViewById(R.id.datepickerbutton);
        c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);
        date = (EditText)findViewById(R.id.editdate);
        name = (EditText)findViewById(R.id.name);
        number = (EditText)findViewById(R.id.number);
        message = (EditText)findViewById(R.id.message);
        dateButton.setOnClickListener(this);





    }


    public void createContact(){


        String n = name.getText().toString(); //"test";
        String bd = date.getText().toString(); //"Test";
        String t = number.getText().toString(); // 12345678;
        String m = message.getText().toString(); //"test";


        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.addContact(tempContact);
        //toast
        Toast.makeText(getApplicationContext(), R.string.new_contact_toast,
                Toast.LENGTH_SHORT).show();


    }


    public void onClick(View v) {
        showDialog(0);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            date.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
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
            case R.id.message:
                Intent i = new Intent(this, NewMessage.class);
                startActivity(i);
                return true;

          /*  case R.id.calendar:
                Intent k = new Intent(this, Calendar.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;
*/
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
