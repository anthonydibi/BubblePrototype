package com.example.bubbleprototype.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.FriendsAdapter;
import com.example.bubbleprototype.R;
import com.example.bubbleprototype.RecyclerViewActionListener;
import com.example.bubbleprototype.RecyclerViewFriendsActionListener;
import com.example.bubbleprototype.TagsAdapter;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.model.Circle;
import com.example.bubbleprototype.data.todo.TodoActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class CreateCircleActivity extends AppCompatActivity implements RecyclerViewFriendsActionListener {

    private RecyclerView recyclerView;
    private BubbleApplication application;
    private ArrayList<Integer> friendsSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.friendsSelected = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_circle);
        application = (BubbleApplication) getApplication();

        recyclerView = (RecyclerView) findViewById(R.id.friendsView);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //I have made my recycler view horizontal, if you want it vertical, just change the horizontal above to vertical.
        recyclerView.setLayoutManager(layoutManager);
        FriendsAdapter adapter = new FriendsAdapter(this, application);
        recyclerView.setAdapter(adapter);
        findViewById(R.id.finalizeCircleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String circleName = ((EditText)findViewById(R.id.circleNameText)).getText().toString();
                Circle newCircle = new Circle(circleName);
                for(int i = 0; i < friendsSelected.size(); i++){
                    newCircle.members.add(friendsSelected.get(i));
                }
                application.circles.add(newCircle);
                Intent intent = new Intent(CreateCircleActivity.this, HomeActivity.class);
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

    public void onViewClicked(int clickedViewId, int clickedItemPosition, int index, View view) {
        switch (clickedViewId) {
            case R.id.chipView:
                System.out.println(index);
                friendsSelected.add(index);
                int color = Color.parseColor("#00FF00");
                view.setBackgroundColor(color);
                break;
        }
    }

    public void onViewLongClicked(int clickedViewId, int clickedItemPosition, int index, View view) {
        //System.out.println(text);
        switch (clickedViewId){
            case R.id.chipView:
                // Application logic when whole item long-clicked
                int color = Color.parseColor("#00FF00");
                view.setBackgroundColor(color);
                friendsSelected.add(index);
                break;
        }
    }
}