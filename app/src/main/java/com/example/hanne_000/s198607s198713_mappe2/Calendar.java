package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by hanne_000 on 19.10.2015.
 */
public class Calendar extends Activity {

    TextView tvdisplaydate;
    DatePicker dpResult;
    int year;
    int month;
    int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        dateView();
    }

    public void dateView()
    {
        tvdisplaydate = (TextView)findViewById(R.id.tvDate);
        dpResult = (DatePicker)findViewById(R.id.dpicker);

        final java.util.Calendar c = java.util.Calendar.getInstance();
        year = c.get(java.util.Calendar.YEAR);
        month = c.get(java.util.Calendar.MONTH);
        day = c.get(java.util.Calendar.DAY_OF_MONTH);

        //tvdisplaydate.setText(new StringBuilder().append(month + 1).append("-").append(day).append("-").append(year));
        dpResult.init(year, month, day, null);
    }


}
