package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by Andre on 21.10.2015.
 */
public class ContactView extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    LoaderManager loadermanager;
    CursorLoader cursorLoader;
    SimpleCursorAdapter mAdapter;
    String TAG = "Loader";
    ContactCP cp = new ContactCP();


    public ContactView()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.liste, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        DBHandler db = new DBHandler(getActivity().getApplicationContext());

        super.onActivityCreated(savedInstanceState);
        loadermanager=getActivity().getLoaderManager();
        String[] uiBindFrom = {"Name"};
        int[] uiBindTo = {0};

        Cursor query = db.getAllContacts();

        mAdapter = new SimpleCursorAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, query, uiBindFrom, uiBindTo, 0);


        ListView l = (ListView)getActivity().findViewById(R.id.listview);
        l.setAdapter(mAdapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //Toast.makeText(getActivity().getBaseContext(), arg2 + "Klikket", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(arg1.getContext(), Edit.class);
                startActivity(i);
            }
        });
        loadermanager.initLoader(0, null, this);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {"0", "Name"};
        cursorLoader = new CursorLoader(getActivity().getBaseContext(), cp.CONTENT_URI, projection, null, null, null);
        return cursorLoader;
    }



    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if(mAdapter != null && cursor != null)
            mAdapter.swapCursor(cursor);
        else
            Log.v(TAG, "OnLoadFinished: mAdapter is null");

    }

    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
        if(mAdapter != null)
            mAdapter.swapCursor(null);
        else
            Log.v(TAG, "OnLoadFinished: mAdaper is null");

    }
}