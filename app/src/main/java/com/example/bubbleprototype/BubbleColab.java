package com.example.bubbleprototype;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

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
import com.example.bubbleprototype.data.todo.TodoActivity;

import java.util.ArrayList;


public class BubbleColab extends AppCompatActivity {
    private BubbleApplication app;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private RecyclerView recyclerView;
    private BubbleAdapter adapter;
    private LinearLayoutManager layoutManager;
    ArrayList<Bubble> bubbleList;
    public Circle testcircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_colab);

        //get the intent that started this activity and extract the string
//        Intent intent= getIntent();
        Intent intent = getIntent();
//        String message ="Welcome " +  intent.getStringExtra(MainActivity.EXTRA_MESSAGE) + "!";

        //capture the layout's TextView and set the string as its text
//        TextView textView = (TextView) findViewById(R.id.textView2);
//        textView.setText(message);

        // action bar stuff
        ActionBar actionBar = getSupportActionBar();

        actionBar.setTitle("Colab:" + intent.getStringExtra(TodoActivity.EXTRA_MESSAGE));
//        actionBar.setTitle("Colab: " + intent.getStringExtra("circle"));

        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        app = ((BubbleApplication) this.getApplication());
        String message = intent.getStringExtra(TodoActivity.EXTRA_MESSAGE);
        if (message != null) {
            app.curCircle = message;
        }
        bubbleList = new ArrayList<>();
//        for (int i = 0; i < app.circles.size(); i++) {
//            if (message.equals(app.circles.get(i).name)) {
//                testcircle = app.circles.get(i);
//            }
//        }
        for (int i = 0; i < app.circles.size(); i++) {
            if (app.curCircle.equals(app.circles.get(i).name)) {
                testcircle = app.circles.get(i);
            }
        }
//        testcircle = app.circles.get(0);
//
//      //setup adapter for recycler view
        recyclerView = findViewById(R.id.recyclerbubbles);
        layoutManager = new LinearLayoutManager(this);
        adapter = new BubbleAdapter(app.circles.get(0).colab.bubbles);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        adapter.setOnItemClickListener(new BubbleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
//                testcircle.colab.bubbles.add(0,new Bubble((idea)));
                Bubble bub = testcircle.colab.bubbles.get(position);
                bub.votes++;

                Toast.makeText(BubbleColab.this, "this bub: " +
                        bub.votes + " votes", Toast.LENGTH_SHORT).show();
                if (bub.votes == 1) {
                    int color = Color.parseColor("#00F1FF");
                    view.setBackgroundColor(color);
                }
                else if (bub.votes > 1) {
                    int color = Color.parseColor("#8CFF00");
                    view.setBackgroundColor(color);
                }
                else {
                    int color = Color.parseColor("#FFFFFF");
                    view.setBackgroundColor(color);
                }
            }
        });
    }


    // start up action bar with the menu xml
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {

        getMenuInflater().inflate(R.menu.bubble, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // action bar event handlers
    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {

        switch (item.getItemId()){
            case R.id.help:
                displayHelp();
                break;
            case R.id.chat:
                chat();
                break;

            case R.id.finish:
//                Toast.makeText(this, "Finish Clicked", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayHelp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("What is Bubble Colab?");
        builder.setMessage("Bubble Colab is a space for you and your group to collaborate" +
                "on ideas! 1. Type in a suggestion and send it to create a new " +
                "bubble. 2. Tap a bubble to vote on an idea. 3. Touch 'chat' to " +
                "chat with the group or touch 'finish' in the top right to start finalizing your " +
                "groups plans with the top voted option!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void createBubble(View view) {
        EditText enterIdea = (EditText) findViewById(R.id.enterTitle);
        String idea = enterIdea.getText().toString();
        if (!idea.equals("")) {
            testcircle.colab.bubbles.add(0,new Bubble((idea)));
            adapter.notifyItemInserted(0);
        }
        enterIdea.setText("");
    }
    public void chat() {
        Intent intent2 = new Intent(this, Chat.class);
        Intent intent3 = getIntent();
        String message = intent3.getStringExtra(TodoActivity.EXTRA_MESSAGE);
        intent2.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent2);

    }
    public void finish() {

        int largest = 0;
        if (testcircle.colab.bubbles.size() > 0) {
            for (int i = 0; i < testcircle.colab.bubbles.size(); i++) {

                if (testcircle.colab.bubbles.get(i).votes > testcircle.colab.bubbles.get(largest).votes) {
                    largest = i;
                }
            }

//            Toast.makeText(BubbleColab.this, "largest: " + testcircle.colab.bubbles.get(largest).idea +
//                    " with " + testcircle.colab.bubbles.get(largest).votes +
//                    " votes", Toast.LENGTH_SHORT).show();

            Intent intent4 = new Intent(this, CreateEvent.class);
//            Intent intent3 = getIntent();
//            String message = intent3.getStringExtra(TodoActivity.EXTRA_MESSAGE);
            String message = app.curCircle;
            intent4.putExtra("circle", message);
            intent4.putExtra("top", testcircle.colab.bubbles.get(largest).idea);
            startActivity(intent4);

        }


    }


}