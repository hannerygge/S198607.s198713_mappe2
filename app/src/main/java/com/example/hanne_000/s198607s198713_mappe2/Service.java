package com.example.hanne_000.s198607s198713_mappe2;


import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.telephony.*;
import android.widget.Toast;

public class Service extends IntentService{

    String message;
    String number;

    public Service(){
        super("Service");
    }
    @Override
    protected void onHandleIntent(Intent intent) {


        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    public void sendSMS(String number, String message){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, message, null, null);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {



        //Toast.makeText(getApplicationContext(),"I MinService", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);

       // Bundle bundle = intent.getExtras();



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
