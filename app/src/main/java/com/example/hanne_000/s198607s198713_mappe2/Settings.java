package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;

import java.util.Locale;

/**
 * Created by hanne_000 on 19.10.2015.
 */
public class Settings extends DialogFragment {

    Locale locale;

    private DialogClickListener callback;

    interface DialogClickListener {
        public void onYesClick();

        public void onNoClick();

        public  void onFinishClick();
    }

    public void changeLanguage(String lang)
    {
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        locale = new Locale(lang);
        Locale.setDefault(locale);
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config, getActivity().getBaseContext().getResources().getDisplayMetrics());

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            callback = (DialogClickListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Kallende klasse må implementere interfacet!");
        }
    }





    public Dialog onCreateDialog(Bundle savedInstanceState) {

        if(Locale.getDefault().getLanguage().contentEquals("nb"))
        {
            return new AlertDialog.Builder(getActivity()).setTitle("test").setMessage("test1").setPositiveButton("Test2", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            callback.onYesClick();
                        }
                    }
            ).setNegativeButton("test3", new DialogInterface.OnClickListener() {
                        public void onClick (DialogInterface dialog,int whichButton){
                            changeLanguage("en");

                            callback.onFinishClick();

                        }
                    }

            ).

                    create();
        }
        else
        {
            return new AlertDialog.Builder(getActivity()).setTitle("test4").setMessage("test5").setPositiveButton("test6", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int whichButton)
                        {
                            callback.onYesClick();
                        }
                    }
            ).setNegativeButton("test7", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {

                            changeLanguage("nb");
                            callback.onFinishClick();
                        }
                    }

            ).

                    create();
        }



    }




}
