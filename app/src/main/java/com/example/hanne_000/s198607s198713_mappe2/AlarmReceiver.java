package com.example.hanne_000.s198607s198713_mappe2;

import android.content.Context;
import android.content.Intent;

/**
 * Created by hanne_000 on 22.10.2015.
 */
public class AlarmReceiver extends android.content.BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

    Intent i = new Intent(context, SetPeriodicService.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startService(i);
    }
}
