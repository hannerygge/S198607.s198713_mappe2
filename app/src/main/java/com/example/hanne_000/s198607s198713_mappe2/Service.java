package com.example.hanne_000.s198607s198713_mappe2;


import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Service extends android.app.Service{

    String message;
    String number;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        //Toast.makeText(getApplicationContext(),"I MinService", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);

       // Bundle bundle = intent.getExtras();



    }
}
