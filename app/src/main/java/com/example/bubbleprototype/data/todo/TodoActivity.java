package com.example.bubbleprototype.data.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.R;
import com.example.bubbleprototype.RecyclerViewActionListener;
import com.example.bubbleprototype.TagsAdapter;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.model.Circle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity implements RecyclerViewActionListener {

    private BubbleApplication application;
    private RecyclerView recyclerView;
    private String currCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo2);
        Intent intent = this.getIntent();
        this.currCircle = intent.getStringExtra("circle");
        if(this.currCircle == null){
            this.currCircle = "";
            findViewById(R.id.colabButton).setVisibility(View.GONE);
            findViewById(R.id.createEventButton).setVisibility(View.GONE); //hide buttons if we arent in a circle
        }
        //System.out.println("Circle: " + this.currCircle);
        application = (BubbleApplication) getApplication();

        recyclerView = (RecyclerView) findViewById(R.id.eventsview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //I have made my recycler view horizontal, if you want it vertical, just change the horizontal above to vertical.
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> eventList = new ArrayList<String>();
        Circle circle = null;
        if (this.currCircle == "") { //if this is the GENERAL to do list
            for (int i = 0; i < application.circles.size(); i++) {
                Circle circleIter = application.circles.get(i);
                for (int j = 0; j < circleIter.events.size(); j++) {
                    eventList.add(circleIter.events.get(j).title + " @ " + circleIter.events.get(j).loc);
                }
            }
        } else { //else, if this is a circle-specific to do list
            for (int i = 0; i < application.circles.size(); i++) {
                if (this.currCircle.equals(application.circles.get(i).name)) {
                    circle = application.circles.get(i);
                }
            }
            //System.out.pr
            for (int i = 0; i < circle.events.size(); i++) {
                eventList.add(circle.events.get(i).title + " @ " + circle.events.get(i).loc);
            }
        }
        TagsAdapter adapter = new TagsAdapter(eventList, this);
        recyclerView.setAdapter(adapter);
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

    @Override
    public void onViewClicked(int clickedViewId, int clickedItemPosition, String text) {
        switch (clickedViewId) {
            case R.id.chipTextView:
                Intent intent = new Intent(this, TodoActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void onViewLongClicked(int clickedViewId, int clickedItemPosition, String text) {
        switch (clickedViewId){
            case R.id.chipTextView:
                // Application logic when whole item long-clicked
                Intent intent = new Intent(this, TodoActivity.class);
                startActivity(intent);
                break;
        }
    }
}