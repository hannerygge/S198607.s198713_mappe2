package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


//edit kontakter
public class Edit extends Activity {

    //get user and show data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        InitOnClick();
    }

    Button button;
    public void InitOnClick(){
        button = (Button) findViewById(R.id.newcontactbutton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editContact();
            }
        });
    }

    public void editContact(){
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


}
