package com.taxiapp.bitspilani.taxiapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.Timestamp;
import com.taxiapp.bitspilani.CommonDBOperation.Database;
import com.taxiapp.bitspilani.pojo.Booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserBookingActivity extends AppCompatActivity implements
        View.OnClickListener {

    static Database dB = new Database();
    Button btnDatePicker, btnTimePicker, submitBookingRequest;
    EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    String srcSelected, destSelected, carTypeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_booking);

        //spinner for source
        final Spinner spinnerSrc = (Spinner) findViewById(R.id.spinnerSrc);

        String[] stationsSrc = new String[]{
                "Select source", "Delhi","Pilani","Jaipur","Noida","Ghaziabad","Sikar","Chandigarh"
        };

        final List<String> srcList = new ArrayList<>(Arrays.asList(stationsSrc));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> srcArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,srcList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        srcArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSrc.setAdapter(srcArrayAdapter);

        spinnerSrc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Log.v("item", (String) parent.getItemAtPosition(position));

                // On selecting a spinner item
                srcSelected = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + srcSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //spinner for destination
        final Spinner spinnerDest = (Spinner) findViewById(R.id.spinnerDest);

        String[] stationsDest = new String[]{
                "Select destination", "Delhi","Pilani","Jaipur","Noida","Ghaziabad","Sikar","Chandigarh"
        };

        final List<String> destList = new ArrayList<>(Arrays.asList(stationsDest));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> destArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,destList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        destArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDest.setAdapter(destArrayAdapter);

        spinnerDest.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Log.v("item", (String) parent.getItemAtPosition(position));

                // On selecting a spinner item
                destSelected = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + destSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        //spinner for cartype
        final Spinner spinnerCarType = (Spinner) findViewById(R.id.spinnerCarType);

        String[] carTypes = new String[]{
                "Select car type", "Micro", "Sedan", "SUV"
        };

        final List<String> carTypesList = new ArrayList<>(Arrays.asList(carTypes));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> carTypesArrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_spinner_item,carTypesList){
            @Override
            public boolean isEnabled(int position){
                if(position == 0)
                {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                }
                else
                {
                    return true;
                }
            }
            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if(position == 0){
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                }
                else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };

        carTypesArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCarType.setAdapter(carTypesArrayAdapter);

        spinnerCarType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                //Log.v("item", (String) parent.getItemAtPosition(position));

                // On selecting a spinner item
                carTypeSelected = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + carTypeSelected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        btnDatePicker = (Button) findViewById(R.id.btn_date);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtDate = (EditText) findViewById(R.id.in_date);
        txtTime = (EditText) findViewById(R.id.in_time);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);

        submitBookingRequest = (Button) findViewById(R.id.submitBookingRequest);
        submitBookingRequest.setOnClickListener(this);

    }

    class DateInfo {
        int day, month, year;
    }

    class  TimeInfo {
        int hour, mins;
    }

    final DateInfo dateInfo = new DateInfo();
    final TimeInfo timeInfo = new TimeInfo();

    @Override
    public void onClick(View v) {

        final String tagDatePicker = "DatePicker";
        String tagTimePicker = "TimePicker";

        if (v == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            dateInfo.day = dayOfMonth;
                            dateInfo.month = monthOfYear + 1;
                            dateInfo.year = year;
                           // Log.v(tagDatePicker, dateInfo.day + "/" + dateInfo.month + "/" + dateInfo.year);
                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();


        }

        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            timeInfo.hour = hourOfDay;
                            timeInfo.mins = minute;
                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }

        if (v == submitBookingRequest) {

            Date selectedDate = new Date(dateInfo.year - 1900, dateInfo.month - 1, dateInfo.day, timeInfo.hour, timeInfo.mins);
            Date currentDate = new Date(mYear - 1900, mMonth, mDay, mHour, mMinute);

            int dateDifference = selectedDate.compareTo(currentDate);

            if(srcSelected.equalsIgnoreCase(destSelected)) {
                Toast.makeText(getApplicationContext(),"Source and Destination can not be same", Toast.LENGTH_SHORT).show();
            }
            else if(!srcSelected.equalsIgnoreCase("Pilani") && !destSelected.equalsIgnoreCase("Pilani")) {
                Toast.makeText(getApplicationContext(), "Either source or destination must be Pilani", Toast.LENGTH_SHORT).show();
            }
            else if( dateDifference == 0 || dateDifference < 0) {
                Toast.makeText(getApplicationContext(), "Booking date or/and time invalid", Toast.LENGTH_SHORT).show();
            }
            else {
                Booking booking = new Booking(srcSelected, destSelected,
                        new Timestamp(new Date(dateInfo.year - 1900, dateInfo.month - 1, dateInfo.day, timeInfo.hour, timeInfo.mins)),
                        carTypeSelected, "null");

                Toast.makeText(getApplicationContext(), "Booking added successfully! Wait for Admin to confirm.", Toast.LENGTH_LONG).show();
                dB.getFirestoreInstance().collection("AkhileshUserActivityBookings").document(booking.getId()).set(booking);
            }
        }
    }

}
