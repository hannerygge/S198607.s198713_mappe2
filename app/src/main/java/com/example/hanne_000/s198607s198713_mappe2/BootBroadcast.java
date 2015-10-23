package com.example.hanne_000.s198607s198713_mappe2;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by hanne_000 on 22.10.2015.
 */
public class BootBroadcast extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, SetPeriodicService.class);
        context.startService(i);
    }
}
