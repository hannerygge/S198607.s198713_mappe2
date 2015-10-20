package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;

/**
 * Created by hanne_000 on 19.10.2015.
 */
public class NewContact extends AppCompatActivity{

    int ID;
    String name;
    Date birthday;
    String phonerNr;
    String message;

    public NewContact(String n, Date bDay, String nr, Message m)
    {

    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonerNr(String phonerNr) {
        this.phonerNr = phonerNr;
    }

    public Date getBirthday() {

        return birthday;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getPhonerNr() {
        return phonerNr;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
    }

}
