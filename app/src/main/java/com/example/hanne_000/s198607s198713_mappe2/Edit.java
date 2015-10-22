package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


//edit kontakter
public class Edit extends AppCompatActivity implements View.OnClickListener, Settings.DialogClickListener{
    @Override
    public void onFinishClick() {

    }

    @Override
    public void onYesClick() {

    }

    @Override
    public void onNoClick() {

    }
//get user and show data

    EditText editName;
    EditText editNumber;
    EditText editDate;
    EditText editMessage;
    int day;
    int month;
    int year;



    ImageButton editTimeButton;
    Button editButton; // = (Button) findViewById(R.id.edit_button);

    public void onclicksomething(){
        editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //editContact();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);


        editTimeButton = (ImageButton) findViewById(R.id.edit_time_button);
        editName = (EditText) findViewById(R.id.edit_name);
        //editName.setText();
        editNumber = (EditText) findViewById(R.id.edit_number);
        editDate = (EditText) findViewById(R.id.edit_birthday);
        editMessage = (EditText) findViewById(R.id.edit_message);

        InitOnClick();

        editTimeButton.setOnClickListener(this);


    }


    public void InitOnClick(){
        editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // editContact(); //må få inn den kontakten som skal editeres
            }
        });
    }

    public void editContact(Contact contact){


        String n = editName.getText().toString();
        String bd = editDate.getText().toString();
        String t = editNumber.getText().toString();
        String m = editMessage.getText().toString();


        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.editContact(tempContact);
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
            editDate.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };


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
                Intent j = new Intent(this, NewMessage.class);
                //startActivity(j);
                startActivityForResult(j, 555);
                return true;

           /* case R.id.calendar:
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

                DialogFragment dialog = new Settings();
                dialog.show(getFragmentManager(), "test9");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
