package com.example.hanne_000.s198607s198713_mappe2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class Message extends AppCompatActivity {

    int ID;
    String message;
    String date;

    public Message( String m, String d){


        setMessage(m);
        setDate(d);
    }

    public Message(){

    }



    public void setDate(String date) {
        this.date = date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {

        return date;
    }

    public int getID() {
        return ID;
    }

    public String getMessage() {
        return message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
    }
}
