package com.example.hanne_000.s198607s198713_mappe2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;


//edit kontakter
public class Edit extends Activity implements View.OnClickListener {

    //get user and show data

    EditText editName;
    EditText editNumber;
    EditText editDate;
    EditText editMessage;
    int day;
    int month;
    int year;

    ImageButton editTimeButton;
    Button editButton; // = (Button) findViewById(R.id.edit_button);


    public void onclicksomething(){
        editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                editContact();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);


        editTimeButton = (ImageButton) findViewById(R.id.edit_time_button);
        editName = (EditText) findViewById(R.id.edit_name);
        editNumber = (EditText) findViewById(R.id.edit_number);
        editDate = (EditText) findViewById(R.id.edit_birthday);
        editMessage = (EditText) findViewById(R.id.edit_message);

        InitOnClick();

        editTimeButton.setOnClickListener(this);


    }


    public void InitOnClick(){
        editButton = (Button) findViewById(R.id.edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editContact();
            }
        });
    }

    public void editContact(){
        String n = editName.getText().toString();
        String bd = editDate.getText().toString();
        String t = editNumber.getText().toString();
        String m = editMessage.getText().toString();

        Contact tempContact = new Contact(n,bd,t,m);

        DBHandler db = new DBHandler(getApplicationContext());
        db.editContact(tempContact);
        //toast
        Toast.makeText(getApplicationContext(), R.string.new_contact_toast,
                Toast.LENGTH_SHORT).show();


    }

    public void onClick(View v) {
        showDialog(0);
    }

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        return new DatePickerDialog(this, datePickerListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            editDate.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
                    + selectedYear);
        }
    };



}
