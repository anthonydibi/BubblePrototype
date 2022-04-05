package com.example.bubbleprototype;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bubbleprototype.data.availability.SaveDialog;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.model.Circle;
import com.example.bubbleprototype.home.HomeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlanInfo extends AppCompatActivity {
    private BubbleApplication application;
    private String circleName;
    private String eventTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        application = (BubbleApplication) getApplication();
        circleName = application.curCircle;
        eventTitle = application.curEventTitle;


        TextView eventNameBanner = (TextView) findViewById(R.id.eventNameBanner);
        eventNameBanner.setText(eventTitle + " with " + circleName);

        Button silentCancel = findViewById(R.id.silentCancel);
        silentCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        Button cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Circle circle = application.getCircle(circleName);
                int planIndex = -1;
                for (int i = 0; i < circle.events.size(); i++) {
                    if (circle.events.get(i).title.equals(eventTitle)) {
                        planIndex = i;
                        break;
                    }
                }
                if (planIndex != -1) {
                    circle.events.remove(planIndex);
                }
                Intent intent = new Intent(PlanInfo.this, HomeActivity.class);
                startActivity(intent);
            }
        });

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

    public void openDialog(){
        SilentCancelDialog silentCancel = new SilentCancelDialog();
        silentCancel.show(getSupportFragmentManager(), "silent_cancel_dialog");
    }
}