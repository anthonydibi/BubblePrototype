package com.example.bubbleprototype.data.model;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class BubbleApplication extends Application {
    public ArrayList<Circle> circles; //all of the user's created circles
    public ArrayList<User> dummyUsers; //a bunch of fake users that are hardcoded with names/availabilities
    public Availability avail; //the user's availability - should be modified by the edit availability screen
    public ArrayList<Integer> friends; //indices of any friends the user has added - create circle should pull from this, and add friends should add to this
    public String curCircle;

    @Override
    public void onCreate() { //called when app starts
        super.onCreate();
        circles = new ArrayList<Circle>();
        dummyUsers = new ArrayList<User>();
        avail = new Availability();
        friends = new ArrayList<Integer>();
        initializeDummyUsers();
        initializeFriends();
        Circle testCircle = new Circle("Test circle");
        testCircle.events.add(new Event("Test event", "9:30pm", "Some place"));
        circles.add(testCircle);
        curCircle = "";
    }

    private void initializeDummyUsers(){
        dummyUsers.add(new User("Anthony Di Biaggio", this.dummyUsers));
        dummyUsers.add(new User("Roshina Rafee", this.dummyUsers));
        dummyUsers.add(new User("Bharti Devi", this.dummyUsers));
        dummyUsers.add(new User("Michael Allrich", this.dummyUsers));
        dummyUsers.add(new User("James Ehresman-Tsagong", this.dummyUsers));
        dummyUsers.add(new User("Daniel Black", this.dummyUsers));
    }

    private void initializeFriends(){
        friends.add(0);
        friends.add(1);
        friends.add(2);
        friends.add(3);
        friends.add(4);
        friends.add(5);
    }

}
