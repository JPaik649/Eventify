package com.example.eventproject;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int category = 0;
    public Button button;
    public static Post currentPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Post testPost = new Post("Testing phase is the worst");
        testPost.setDescription("The fitness gram pacer test is a multistage aerobic capacity test that progressively gets more difficult as it continues.");
        testPost.setTag("Entertainment");
        testPost.setMonth(11);
        testPost.setDay(2);
        testPost.setStartHour(5);
        testPost.setStartMinute(45);
        testPost.setEndHour(9);
        testPost.setEndMinute(00);
        testPost.setLocation("Hillenbrand Hall - Roof");


        button = (Button) findViewById(R.id.ericsButton);
        button.setTag(testPost);
        //use button.setTag(postName); if you want to set a post to a button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPost = (Post)button.getTag();
                openPostActivity();
            }
        });

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


    public static Post getCurrentPost() {
        return currentPost;
    }

}
