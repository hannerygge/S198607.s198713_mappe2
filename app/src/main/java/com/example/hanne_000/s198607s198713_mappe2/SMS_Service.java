package com.example.hanne_000.s198607s198713_mappe2;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class SMS_Service extends Service {

    String message;
    String number;

    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(getApplicationContext(), "I com.example.andre.service.MinService",
                Toast.LENGTH_SHORT).show();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent i = new Intent(this, Result.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, i, 0);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("Tittel")
                .setContentText("Tekst")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent).build();

        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);

        return super.onStartCommand(intent, flags, startId);
    }
    /*@Override
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
    }*/
}
