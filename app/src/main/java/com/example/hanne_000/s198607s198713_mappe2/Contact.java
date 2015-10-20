package com.example.hanne_000.s198607s198713_mappe2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Date;


public class Contact extends AppCompatActivity{

    int ID;
    String name;
    String birthday;
    String phonerNr;
    String message;

    public Contact(String n, String bDay, String nr, String m)
    {
        setName(n);
        setBirthday(bDay);
        setPhoneNr(nr);
        setMessage(m);
    }

    public Contact(){

    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNr(String phonerNr) {
        this.phonerNr = phonerNr;
    }

    public String getBirthday() {

        return birthday;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNr() {
        return phonerNr;
    }

    public int getId() { return ID; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact);
    }

}
