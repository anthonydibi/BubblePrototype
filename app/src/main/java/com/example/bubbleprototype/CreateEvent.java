package com.example.bubbleprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.bubbleprototype.data.model.Bubble;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.model.Circle;
import com.example.bubbleprototype.data.model.Colab;
import com.example.bubbleprototype.data.model.Event;
import com.example.bubbleprototype.data.todo.TodoActivity;
import com.example.bubbleprototype.home.HomeActivity;

import java.util.ArrayList;
import java.util.List;

public class CreateEvent extends AppCompatActivity {
    private BubbleApplication app;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public Circle testcircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Intent intent = getIntent();
        // action bar stuff
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Create Event");

        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        app = ((BubbleApplication) this.getApplication());
        String message = intent.getStringExtra("circle");
        String message2 = intent.getStringExtra("top");
        EditText title = (EditText) findViewById(R.id.enterTitle);
        title.setText(message2);
        for (int i = 0; i < app.circles.size(); i++) {
            if (app.curCircle.equals(app.circles.get(i).name)) {
                testcircle = app.circles.get(i);
            }
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void createEvent(View view) {
        Intent intent = new Intent(this, TodoActivity.class);
        EditText titleText = (EditText) findViewById(R.id.enterTitle);
        String title = titleText.getText().toString();

        EditText timeText = (EditText) findViewById(R.id.enterTime);
        String time = timeText.getText().toString();

        EditText locationText = (EditText) findViewById(R.id.enterLocation);
        String location = locationText.getText().toString();

        Event plan = new Event(title, time, location);
        testcircle.events.add(plan);

        Toast.makeText(CreateEvent.this, "Event Created!", Toast.LENGTH_SHORT).show();

        intent.putExtra("circle", app.curCircle);
        startActivity(intent);
    }

}