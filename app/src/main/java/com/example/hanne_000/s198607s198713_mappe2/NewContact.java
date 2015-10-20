package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;

public class NewContact extends Activity{

    public void createContact(){
        String n = findViewById(R.id.name).toString();
        String bd = findViewById(R.id.DatePicker).toString();
        String t = findViewById(R.id.number).toString();
        String m = findViewById(R.id.name).toString();

        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.addContact(tempContact);
        //toast


    }
}
