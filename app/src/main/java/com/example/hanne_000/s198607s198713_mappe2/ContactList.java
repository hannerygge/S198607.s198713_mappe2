package com.example.hanne_000.s198607s198713_mappe2;

/**
 * Created by Andre on 21.10.2015.
 */

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by hanne_000 on 08.10.2015.
 */
public class ContactList extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactlist);

        //Må hente ut fra databasen og legge i fragmentet

        DBHandler db = new DBHandler(getApplicationContext());


        if(findViewById(R.id.fragment_container) != null)
        {
            if(savedInstanceState != null)
                return;

            ContactView contactFragment = new ContactView();
            contactFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(R.id.fragment_container, contactFragment).commit();

        }

    }



}
