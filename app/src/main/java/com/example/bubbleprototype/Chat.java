package com.example.bubbleprototype;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.bubbleprototype.data.todo.TodoActivity;

import java.util.ArrayList;
import java.util.List;

public class Chat extends AppCompatActivity {
    private BubbleApplication app;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager layoutManager;
    ArrayList<String> chatList;
    public Circle testcircle;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        //get the intent that started this activity and extract the string
        Intent intent= getIntent();
        //String message ="Welcome " +  intent.getStringExtra(MainActivity.EXTRA_MESSAGE) + "!";

        //action bar stuff
        ActionBar actionBar = getSupportActionBar();

        //action bar title
        actionBar.setTitle("Chat: " + intent.getStringExtra(BubbleColab.EXTRA_MESSAGE));
//        actionBar.setTitle("Colab: " + intent.getStringExtra("circle"));
        // action bar see icons
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        String message = intent.getStringExtra(BubbleColab.EXTRA_MESSAGE);

        //get reference to the global app data
        app = ((BubbleApplication) this.getApplication());
        for (int i = 0; i < app.circles.size(); i++) {
            if (app.curCircle.equals(app.circles.get(i).name)) {
                testcircle = app.circles.get(i);
            }
        }
        //setup adapter for recycler view
        recyclerView = findViewById(R.id.recyclerchat);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ChatAdapter(app.circles.get(0).colab.chat);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void createText(View view) {
        EditText enterIdea = (EditText) findViewById(R.id.enterChat);
        String msg = enterIdea.getText().toString();
        if (!msg.equals("")) {
//            Circle testcircle = app.circles.get(0);
            testcircle.colab.chat.add(msg);
            adapter.notifyItemInserted(testcircle.colab.chat.size() - 1);
            testcircle.colab.chat.add("no");
            adapter.notifyItemInserted(testcircle.colab.chat.size() - 1);
        }
        enterIdea.setText("");
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        Intent intent = new Intent();
        intent.putExtra("MESSAGE",intent.getStringExtra(BubbleColab.EXTRA_MESSAGE));
        setResult(2, intent);

        super.onBackPressed();
    }


}
