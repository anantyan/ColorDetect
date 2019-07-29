package com.example.colordetect.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.colordetect.R;
import com.example.colordetect.fragment.DatePickerFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class TwoActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button __btn_tanggal_form;
    EditText __hari_tanggal_form;
    Calendar C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        __btn_tanggal_form = (Button) findViewById(R.id._btn_tanggal_form);
        __btn_tanggal_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "Date Picker");
            }
        });

    }

    //==============================================================================================
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        C = Calendar.getInstance();
        C.set(Calendar.YEAR, year);
        C.set(Calendar.MONTH, month);
        C.set(Calendar.DATE, dayOfMonth);
        String currenDateString = DateFormat.getDateInstance(DateFormat.FULL).format(C.getTime());
        __hari_tanggal_form = (EditText) findViewById(R.id._hari_tanggal_form);
        __hari_tanggal_form.setText(currenDateString);
    }

    //==============================================================================================
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //==============================================================================================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id._action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
