package com.example.bubbleprototype.data.availability;

import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.bubbleprototype.R;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AvailabilityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        final TableLayout slots = (TableLayout) findViewById(R.id.tableLayout);
        final Button saveButton = (Button) findViewById(R.id.saveAvail);

        for (int i = 0; i < 35; i++) {
            final TextView blocks = (TextView) slots.findViewWithTag(i + 1);
            blocks.setBackgroundColor(R.drawable.grey_blocks);
            blocks.setClickable(false);
            blocks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    blocks.setBackgroundColor(R.drawable.green_blocks);
                    blocks.setClickable(true);
                }
            });
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: create save confirmation message with edit button and save button
            }
        });

    }
}

