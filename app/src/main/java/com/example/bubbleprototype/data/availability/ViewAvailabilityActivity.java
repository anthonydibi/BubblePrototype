package com.example.bubbleprototype.data.availability;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.bubbleprototype.R;
import com.example.bubbleprototype.data.model.Availability;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.model.Circle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewAvailabilityActivity extends AppCompatActivity {

    private BubbleApplication application;

    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        Intent intent = this.getIntent();
        String circleName = intent.getStringExtra("circle");
        setContentView(R.layout.activity_view_availability);
        application = (BubbleApplication) getApplication();
        Circle circle = application.getCircle(circleName);
        ArrayList<int[]> avails = new ArrayList<>();
        avails.add(application.avail.userAvail);
        for(int i = 0; i < circle.members.size(); i++){
            avails.add(application.dummyUsers.get(application.friends.get(circle.members.get(i))).avail);
        }
        float[] mergedAvail = Availability.merge(avails);
        for(int i = 0; i < mergedAvail.length; i++){
            System.out.println(mergedAvail[i]);
        }
        //timeslots functionality
        TableLayout slots = findViewById(R.id.tableLayout);
        for (int i = 0; i < 35; i++) {
            final TextView block = slots.findViewWithTag("" + (i + 1) + "");
            float lerp = mergedAvail[i];
            int color = Color.HSVToColor(new float[]{lerp * 120, .9f, .9f});
            block.setBackgroundColor(color);
        }
        //save button functionality
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
}