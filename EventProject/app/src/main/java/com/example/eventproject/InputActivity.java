package com.example.eventproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button submitbutton = (Button) findViewById(R.id.submitbutton);
            submitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText EventTitle = (EditText) findViewById(R.id.EventTitle);
                    EditText EventLocation = (EditText) findViewById(R.id.EventLocation);
                    EditText EventDate = (EditText) findViewById(R.id.EventLocation);
                    EditText EventStart = (EditText) findViewById(R.id.EventStart);
                    EditText EventEnd = (EditText) findViewById(R.id.EventEnd);
                    EditText EventAttendance = (EditText) findViewById(R.id.EventAttendance);
                    EditText EventDescription = (EditText) findViewById(R.id.EventDescription);

                    String title = EventTitle.getText().toString();
                    String location = EventLocation.getText().toString();
                    String datestring = EventDate.getText().toString();
                    String starttimestring = EventStart.getText().toString();
                    String endtimestring = EventEnd.getText().toString();
                    String attendance = EventAttendance.getText().toString();
                    String description = EventDescription.getText().toString();

                    //date reformat
                    String placeholder = "";
                    placeholder = datestring.substring(0,2);
                    int month= Integer.parseInt(placeholder);
                    placeholder = datestring.substring(3,5);
                    int day= Integer.parseInt(placeholder);
                    placeholder = datestring.substring(6,10);
                    int year = Integer.parseInt(placeholder);
                    //start time reformat
                    placeholder = starttimestring.substring(0,2);
                    int startHour = Integer.parseInt(placeholder);
                    placeholder = starttimestring.substring(3,5);
                    int startMinute = Integer.parseInt(placeholder);
                    //end time reformat
                    placeholder = endtimestring.substring(0,2);
                    int endHour = Integer.parseInt(placeholder);
                    placeholder = endtimestring.substring(3,5);
                    int endMinute = Integer.parseInt(placeholder);
                }
            });
    }
}

