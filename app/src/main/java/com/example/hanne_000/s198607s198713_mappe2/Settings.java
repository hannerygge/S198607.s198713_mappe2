package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Configuration;

import java.util.Locale;

/**
 * Created by hanne_000 on 19.10.2015.
 */
public class Settings extends DialogFragment {

    Locale locale;

    public void changeLanguage(String lang)
    {
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        locale = new Locale(lang);
        Locale.setDefault(locale);
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());

    }


}
