package com.example.hanne_000.s198607s198713_mappe2;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
public class MainActivity extends AppCompatActivity implements Settings.DialogClickListener {

    ContactList list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHandler dbh = new DBHandler(this);
        list = new ContactList();

    }

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


        MyCursor test = cp.query(uri, mProjection, selection, mSelectionArgs, sortOrder);

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







    @Override
    public void onYesClick() {
        return;
    }

    public void onFinishClick() {
        return;
    }

    @Override
    public void onNoClick() {
        return;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/


        switch (item.getItemId()) {
            case R.id.newcontact:
                Intent i = new Intent(this, NewContact.class);
                startActivity(i);
                return true;

            case R.id.message:
                Intent j = new Intent(this, Message.class);
                //startActivity(j);
                startActivityForResult(j, 555);
                return true;

           /* case R.id.calendar:
                Intent k = new Intent(this, Calendar.class);
                //startActivity(j);
                startActivityForResult(k, 555);
                return true;
*/
            case R.id.settings:
              /*  Intent l = new Intent(this, Settings.class);
                //startActivity(j);
                startActivityForResult(l, 555);
                */

                DialogFragment dialog = new Settings();
                dialog.show(getFragmentManager(), "test9");

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
