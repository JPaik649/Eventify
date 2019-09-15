package com.example.eventproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static int category = 0;
    public Button button1;
    public Button button2;
    public Button button3;
    public static Post currentPost;
    public List<Post> pL;
    public static AttendingEvent events;
    public String childNames[];

    DatabaseReference postRef = FirebaseDatabase.getInstance().getReference("Post");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        events = new AttendingEvent();

        int x = 0;
        Post[] post;

        Post testPost1 = new Post("Testing phase is the worst");
        testPost1.setDescription("The fitness gram pacer test is a multistage aerobic capacity test that progressively gets more difficult as it continues.");
        testPost1.setTag("Entertainment");
        testPost1.setMonth(11);
        testPost1.setDay(2);
        testPost1.setStartHour(5);
        testPost1.setStartMinute(45);
        testPost1.setEndHour(9);
        testPost1.setEndMinute(00);
        testPost1.setLocation("Hillenbrand Hall - Roof");

        Post testPost2 = new Post("What is love?");
        testPost2.setDescription("Baby don't hurt me. Baby don't hurt me. No more. Then it repeats that again but I'm not typing that.");
        testPost2.setTag("Other");
        testPost2.setMonth(9);
        testPost2.setDay(15);
        testPost2.setStartHour(6);
        testPost2.setStartMinute(15);
        testPost2.setEndHour(7);
        testPost2.setEndMinute(30);
        testPost2.setLocation("Wiley Dining Court");

        Post testPost3 = new Post("Ultimate Frisbee");
        testPost3.setDescription("Have you ever wanted to throw a frisbee around in a competitive way. Look no further!");
        testPost3.setTag("Sports");
        testPost3.setMonth(10);
        testPost3.setDay(9);
        testPost3.setStartHour(8);
        testPost3.setStartMinute(00);
        testPost3.setEndHour(9);
        testPost3.setEndMinute(45);
        testPost3.setLocation("Engineering Fountain");


        //initiates all the buttons for posts
        button1 = findViewById(R.id.postButton1);
        //use button.setTag(postName); if you want to set a post to a button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPost = (Post)button1.getTag();
                openPostActivity();
            }
        });

        button2 = findViewById(R.id.postButton2);
        //use button.setTag(postName); if you want to set a post to a button
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPost = (Post)button2.getTag();
                openPostActivity();
            }
        });

        button3 = findViewById(R.id.postButton3);
        //use button.setTag(postName); if you want to set a post to a button
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPost = (Post)button3.getTag();
                openPostActivity();
            }
        });

        //adds all the post info to the buttons
        //setPost1(pL.get(0));
        setPost2(testPost2);
        setPost3(testPost3);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInputActivity();
            }
        });

    }

    public void openInputActivity() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    public void openPostActivity(){
        Intent intent = new Intent(this, PostActivity.class);
        startActivity(intent);
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

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()) {
            case R.id.All:
                category = 0;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Academic:
                category = 1;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Athletic:
                category = 2;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Entertainment:
                category = 3;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Social:
                category = 4;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Other:
                category = 5;
                Toast.makeText(this, "" + category, Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void setPost1(Post post) {
        ((TextView)findViewById(R.id.postTitle1)).setText(post.getTitle());
        ((TextView)findViewById(R.id.postTag1)).setText("Tag: " + post.getTag());
        ((TextView)findViewById(R.id.postLocation1)).setText(post.getLocation());
        String dateAndTime;
        dateAndTime = PostActivity.getMonth(post.getMonth());
        dateAndTime += " " + post.getDay();
        dateAndTime += "  |  " + post.getStartHour() + ":" ;
        int minute = post.getStartMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        dateAndTime += " - " + post.getEndHour() + ":";
        minute = post.getEndMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        ((TextView)findViewById(R.id.postDateAndTime1)).setText(dateAndTime);
        button1.setTag(post);
    }

    private void setPost2(Post post) {
        ((TextView)findViewById(R.id.postTitle2)).setText(post.getTitle());
        ((TextView)findViewById(R.id.postTag2)).setText("Tag: " + post.getTag());
        ((TextView)findViewById(R.id.postLocation2)).setText(post.getLocation());
        String dateAndTime;
        dateAndTime = PostActivity.getMonth(post.getMonth());
        dateAndTime += " " + post.getDay();
        dateAndTime += "  |  " + post.getStartHour() + ":" ;
        int minute = post.getStartMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        dateAndTime += " - " + post.getEndHour() + ":";
        minute = post.getEndMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        ((TextView)findViewById(R.id.postDateAndTime2)).setText(dateAndTime);
        button2.setTag(post);
    }

    private void setPost3(Post post) {
        ((TextView)findViewById(R.id.postTitle3)).setText(post.getTitle());
        ((TextView)findViewById(R.id.postTag3)).setText("Tag: " + post.getTag());
        ((TextView)findViewById(R.id.postLocation3)).setText(post.getLocation());
        String dateAndTime;
        dateAndTime = PostActivity.getMonth(post.getMonth());
        dateAndTime += " " + post.getDay();
        dateAndTime += "  |  " + post.getStartHour() + ":" ;
        int minute = post.getStartMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        dateAndTime += " - " + post.getEndHour() + ":";
        minute = post.getEndMinute();
        if(Integer.toString(minute).length() == 1) {
            dateAndTime += 0;
        }
        dateAndTime += minute;
        ((TextView)findViewById(R.id.postDateAndTime3)).setText(dateAndTime);
        button3.setTag(post);
    }

    public static Post getCurrentPost() {
        return currentPost;
    }

    public static AttendingEvent getEvents() {
        return events;
    }
}
