package com.example.eventproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InputActivity extends AppCompatActivity {

    Post post;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Button backbutton = (Button) findViewById(R.id.backbutton);
            backbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //put back button code here
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult (myIntent, 0);
                }
            });
        Button submitbutton = (Button) findViewById(R.id.submitbutton);
        reff = FirebaseDatabase.getInstance().getReference();
            submitbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText EventTitle = (EditText) findViewById(R.id.EventTitle);
                    EditText EventLocation = (EditText) findViewById(R.id.EventLocation);
                    EditText EventDate = (EditText) findViewById(R.id.EventDate);
                    EditText EventStart = (EditText) findViewById(R.id.EventStart);
                    EditText EventEnd = (EditText) findViewById(R.id.EventEnd);
                    EditText EventAttendance = (EditText) findViewById(R.id.EventAttendance);
                    EditText EventDescription = (EditText) findViewById(R.id.EventDescription);
                    EditText EventTag = (EditText) findViewById(R.id.EventTag);

                    String title = EventTitle.getText().toString();
                    String location = EventLocation.getText().toString();
                    String datestring = EventDate.getText().toString();
                    String starttimestring = EventStart.getText().toString();
                    String endtimestring = EventEnd.getText().toString();
                    int openSpots = Integer.parseInt(EventAttendance.getText().toString());
                    String description = EventDescription.getText().toString();
                    String tag = EventTag.getText().toString();

                    //date reformat
                    String placeholder = "";
                    placeholder = datestring.substring(0,2);
                    Log.w("InputActivity", placeholder);
                    int month= Integer.parseInt(placeholder);
                    placeholder = datestring.substring(3,5);
                    int day= Integer.parseInt(placeholder);
                    placeholder = datestring.substring(7);
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
                    //tag reformat
                    switch (tag.toLowerCase()) {
                        case "academic":
                            tag = "academic";
                            break;
                        case "athletic":
                            tag = "athletic";
                            break;
                        case "entertainment":
                            tag = "entertainment";
                            break;
                        case "social":
                            tag = "social";
                            break;
                        default:
                            tag="other";
                            break;
                    }

                    //vars to be used
                    //title
                    //location
                    //description
                    //month
                    //day
                    //year
                    //startHour
                    //startMinute
                    //endHour
                    //endMinute
                    //openSpots
                    //tag

                    Post postName = new Post(title);
                    postName.setTitle(title);
                    postName.setLocation(location);
                    postName.setDescription(description);
                    postName.setMonth(month);
                    postName.setDay(day);
                    postName.setYear(year);
                    postName.setStartHour(startHour);
                    postName.setStartMinute(startMinute);
                    postName.setEndHour(endHour);
                    postName.setEndMinute(endMinute);
                    postName.setOpenSpots(openSpots);
                    postName.setTag(tag);
                    reff.child("Post").child(title).setValue(postName);

                    //after pressing submit you will be taken back to homepage
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult (myIntent, 0);
                }
            });
    }
}

