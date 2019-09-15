package com.example.eventproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class PostActivity extends AppCompatActivity {

    private Button joinEvent;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        //updates all of the info of the post
        title = MainActivity.getCurrentPost().getTitle();
        ((TextView)findViewById(R.id.postTitle)).setText(title);
        ((TextView)findViewById(R.id.postDescription)).setText(MainActivity.getCurrentPost().getDescription());
        ((TextView)findViewById(R.id.postLocation)).setText(MainActivity.getCurrentPost().getLocation());
        ((TextView)findViewById(R.id.postTag)).setText(MainActivity.getCurrentPost().getTag());
        String dateAndTime;
        dateAndTime = getMonth(MainActivity.getCurrentPost().getMonth());
        dateAndTime += " " + MainActivity.getCurrentPost().getDay();
        dateAndTime += "  |  " + MainActivity.getCurrentPost().getStartHour() + ":" ;
        int minute = MainActivity.getCurrentPost().getStartMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        dateAndTime += " - " + MainActivity.getCurrentPost().getEndHour() + ":";
        minute = MainActivity.getCurrentPost().getEndMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        ((TextView)findViewById(R.id.postDateAndTime)).setText(dateAndTime);
        if(MainActivity.getCurrentPost().getCount() == 1)
        {
            ((TextView) findViewById(R.id.postCount)).setText("1 person has signed up");
        } else {
            ((TextView) findViewById(R.id.postCount)).setText(MainActivity.getCurrentPost().getCount() + " people have signed up");
        }

        //deals with the button on the post for joining the event
        joinEvent = findViewById(R.id.joinEventButton);
        if(MainActivity.getEvents().checkEvent(title)) {
            joinEvent.setBackgroundColor(getResources().getColor(R.color.red));
            joinEvent.setText("Leave event");
        }
        joinEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!MainActivity.getEvents().checkEvent(title)) {
                    joinEvent.setBackgroundColor(getResources().getColor(R.color.red));
                    joinEvent.setText("Leave event");
                    MainActivity.getEvents().addEvent(title);
                    MainActivity.getCurrentPost().changeCount(1);
                    if(MainActivity.getCurrentPost().getCount() == 1)
                    {
                        ((TextView) findViewById(R.id.postCount)).setText("1 person has signed up");
                    } else {
                        ((TextView) findViewById(R.id.postCount)).setText(MainActivity.getCurrentPost().getCount() + " people have signed up");
                    }
                } else {
                    joinEvent.setBackgroundColor(getResources().getColor(R.color.green));
                    joinEvent.setText("Join Event");
                    MainActivity.getEvents().removeEvent(title);
                    MainActivity.getCurrentPost().changeCount(-1);
                    if(MainActivity.getCurrentPost().getCount() == 1)
                    {
                        ((TextView) findViewById(R.id.postCount)).setText("1 person has signed up");
                    } else {
                        ((TextView) findViewById(R.id.postCount)).setText(MainActivity.getCurrentPost().getCount() + " people have signed up");
                    }
                }
            }
        });
    }

    //converts the int of a month to a string
    public static String getMonth(int month) {
        String output;
        switch (month) {
            case 1:
                output = "January";
                break;
            case 2:
                output = "February";
                break;
            case 3:
                output = "March";
                break;
            case 4:
                output = "April";
                break;
            case 5:
                output = "May";
                break;
            case 6:
                output = "June";
                break;
            case 7:
                output = "July";
                break;
            case 8:
                output = "August";
                break;
            case 9:
                output = "September";
                break;
            case 10:
                output = "October";
                break;
            case 11:
                output = "November";
                break;
            case 12:
                output = "December";
                break;
            default:
                output = "Invalid Month";
                break;
        }
        return output;
    }

}
