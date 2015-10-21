package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Andre on 21.10.2015.
 */
public class ContactView extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    LoaderManager loadermanager;
    CursorLoader cursoorLoader;
    SimpleCursorAdapter mAdapter;
    String TAG = "Loader";

    //skal ut!
    /*public void getList() {
        ContactCP cp = new ContactCP();
        java.util.Calendar c = Calendar.getInstance();

        Uri uri = cp.CONTENT_URI;

        String selection = "WHERE Birthday > " + c.toString();

        String[] mProjection = new String[]{
                "Name",
                "Birthday"
        };
        String[] mSelectionArgs = new String[]{""};

        String sortOrder = "ORDER BY Birthday";


        Cursor test = cp.query(uri, mProjection, selection, mSelectionArgs, sortOrder);

        if (null == test) {
            //Noe gikk galt
            return;
        } else if (test.getCount() < 1) {
            //Returnerte ingenting o.o
            return;
        }
        else{
            if(test != null)
            {
                while(test.moveToNext()){
                    test.getString(test.getColumnIndex("Name"));
                    test.getString(test.getColumnIndex("Birthday"));

                }
            }
            else{
                //if something went wrong
                return;
            }
        }

    }*/



    public ContactView(){

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
