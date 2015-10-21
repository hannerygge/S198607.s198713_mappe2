package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewContact extends AppCompatActivity implements Settings.DialogClickListener{


    Button button;
    Button dateButton;
    public void onclicksomething(){
        button = (Button) findViewById(R.id.newcontactbutton);
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
        datePickerOnClick();

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setLogo(R.drawable.testing);
        //getSupportActionBar().setIcon(R.drawable.testing);
    }


    public void createContact(){
        String n = "test"; //findViewById(R.id.name).toString();
        String bd = "Test"; //findViewById(R.id.DatePicker).toString();
        String t = "1234"; //findViewById(R.id.number).toString();
        String m = "test"; //findViewById(R.id.message).toString();

        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.addContact(tempContact);
        //toast
        Toast.makeText(getApplicationContext(), R.string.new_contact_toast,
                Toast.LENGTH_SHORT).show();


    }

    public void datePickerOnClick(){
        dateButton = (Button) findViewById(R.id.datepickerbutton);
        dateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment dialog = new DatePickerFragment();
                dialog.show(getFragmentManager(), "tekst");
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
            case R.id.message:
                Intent i = new Intent(this, Message.class);
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

                DialogFragment dialog = new Settings();
                dialog.show(getFragmentManager(), "test9");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }


    }

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
}
