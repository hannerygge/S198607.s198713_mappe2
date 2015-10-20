package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewContact extends Activity{

    Button button;
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
    }


    public void createContact(){
        String n = findViewById(R.id.name).toString();
        String bd = findViewById(R.id.DatePicker).toString();
        String t = findViewById(R.id.number).toString();
        String m = findViewById(R.id.name).toString();

        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.addContact(tempContact);
        //toast
        Toast.makeText(getApplicationContext(), R.string.new_contact_toast,
                Toast.LENGTH_SHORT).show();


    }
}
