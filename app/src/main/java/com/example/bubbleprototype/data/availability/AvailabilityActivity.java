package com.example.bubbleprototype.data.availability;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bubbleprototype.R;
import com.example.bubbleprototype.data.model.BubbleApplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class AvailabilityActivity extends AppCompatActivity {

    private BubbleApplication application;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_availability);
        application = (BubbleApplication) getApplication();
        //timeslots functionality
        TableLayout slots = findViewById(R.id.tableLayout);
        for (int i = 0; i < 35; i++) {
            final TextView blocks = slots.findViewWithTag("" + (i + 1) + "");
            final int idx = i;
            blocks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Drawable block = blocks.getBackground();
                    Drawable isGreen = ResourcesCompat.getDrawable(getResources(), R.drawable.green_blocks, null);

                    if(block.equals(isGreen)) {
                        blocks.setBackgroundColor(R.drawable.grey_blocks);
                        application.avail.setUserAvail(idx, 0);
                    }
                    else{
                        blocks.setBackgroundColor(R.drawable.green_blocks);
                        application.avail.setUserAvail(idx, 1);
                    }
                }
            });
        }

        //save button functionality
        Button saveButton = findViewById(R.id.saveAvail);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

    }

    public void openDialog(){
        SaveDialog confirmation = new SaveDialog();
        confirmation.show(getSupportFragmentManager(), "availability_confirmation_dialog");
    }

}

