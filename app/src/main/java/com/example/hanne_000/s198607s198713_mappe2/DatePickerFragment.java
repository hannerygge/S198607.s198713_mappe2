package com.example.hanne_000.s198607s198713_mappe2;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

/**
 * Created by hanne_000 on 20.10.2015.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    TextView tvdisplaydate;
    DatePicker dpResult;
    int year;
    int month;
    int day;
    private DialogClickListener callback;
    DatePicker.OnDateChangedListener dateListener;

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {


        final java.util.Calendar c = java.util.Calendar.getInstance();
        year = c.get(java.util.Calendar.YEAR);
        month = c.get(java.util.Calendar.MONTH);
        day = c.get(java.util.Calendar.DAY_OF_MONTH);

    }


    interface DialogClickListener {
        public void onYesClick();

        public void onNoClick();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dateView();
        try {
            callback = (DialogClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Kallende klasse må implementere interfacet!");
        }
    }

    public static DatePickerFragment newInstance(int Title) {
        DatePickerFragment frag = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putInt("tittel", Title);
        frag.setArguments(args);
        return frag;
    }


    public void dateView()
    {
        tvdisplaydate = (TextView) getActivity().findViewById(R.id.tvDate);
        dpResult = (DatePicker) getActivity().findViewById(R.id.dpicker);


        tvdisplaydate.setText(new StringBuilder().append(month + 1).append("-").append(day).append("-").append(year));
        dpResult.init(year, month, day, dateListener);
    }

}
