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
