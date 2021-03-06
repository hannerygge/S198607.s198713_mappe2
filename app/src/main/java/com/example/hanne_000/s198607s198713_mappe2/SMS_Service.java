package com.example.hanne_000.s198607s198713_mappe2;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SMS_Service extends Service {

    String message;
    String number;
    String timeSent = "";

    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
       // Toast.makeText(getApplicationContext(), "SMS_Service running",
           //     Toast.LENGTH_SHORT).show();

        /*NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, i, 0);

        Notification noti = new Notification.Builder(this)
                .setContentTitle("Tittel")
                .setContentText("Tekst")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pIntent).build();

        noti.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(0, noti);*/

        DBHandler dbh = new DBHandler(getApplicationContext());
        Cursor time = dbh.getStandardMessageAndTime(1);
        time.moveToFirst();
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("h:mm a");
        String now = df.format(c.getTime());

        //Toast.makeText(getApplicationContext(), "time-object-count: " + time.getCount() + ", " + (!(now.equals(timeSent))),
          //      Toast.LENGTH_SHORT).show();

        if((!(time.getCount() < 1)) && !(now.equals(timeSent))) {

            if (now.equals(time.getString(time.getColumnIndex("Time")))) {

                SimpleDateFormat df2 = new SimpleDateFormat("dd-mm-yyyy");
                String Today = df2.format(c.getTime());

              //  Toast.makeText(getApplicationContext(), "Now is the time!",
                //        Toast.LENGTH_SHORT).show();

                Cursor cur = dbh.getBirthdayPeople(Today);

                if (cur.getCount() <= 1) {
                    cur.moveToFirst();
                    while (cur.moveToNext()) {
                        String CursorNumber = cur.getString(cur.getColumnIndex("Phone"));
                        String CursorMessage = cur.getString(cur.getColumnIndex("Message"));
                        if(CursorMessage == null || CursorMessage.equals(""))
                            sendSMS(CursorNumber, time.getString(time.getColumnIndex("Message"))); //if the message is blank or null we use the standard message.
                        sendSMS(CursorNumber, CursorMessage); //custom message
                    }
                    //Create a notification instead?
                    Toast.makeText(getApplicationContext(), "Birthday messages has been sent!",
                            Toast.LENGTH_SHORT).show();
                    timeSent = df.format(c.getTime());

                }


            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
    public void sendSMS(String number, String message){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(number, null, message, null, null);
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
