package com.example.hanne_000.s198607s198713_mappe2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.*;
import java.util.Calendar;

/**
 * Created by hanne_000 on 20.10.2015.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    int year;
    int month;
    int day;

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {



    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final java.util.Calendar c = java.util.Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, day, month, year);



    }








}
