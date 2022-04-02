package com.example.bubbleprototype.data.model;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class BubbleApplication extends Application {
    public List<Circle> circles; //all of the user's created circles
    public List<User> dummyUsers; //a bunch of fake users that are hardcoded with names/availabilities
    public Availability avail; //the user's availability - should be modified by the edit availability screen
    public List<Integer> friends; //indices of any friends the user has added - create circle should pull from this, and add friends should add to this

    @Override
    public void onCreate() { //called when app starts
        super.onCreate();
        circles = new ArrayList<Circle>();
        dummyUsers = new ArrayList<User>();
        avail = new Availability();
        friends = new ArrayList<Integer>();
        circles.add(new Circle("testcircle1"));
        circles.get(0).events.add(new Event("Test plannnn", "nine o clocky", "here"));
        circles.add(new Circle("testcircle2"));
        circles.get(1).events.add(new Event("Test plan2", "ten o clock", "other place"));
        initializeDummyUsers();
    }

    private void initializeDummyUsers(){
        dummyUsers.add(new User("Anthony Di Biaggio", this.dummyUsers));
        dummyUsers.add(new User("Roshina Rafee", this.dummyUsers));
        dummyUsers.add(new User("Bharti Devi", this.dummyUsers));
        dummyUsers.add(new User("Michael Allrich", this.dummyUsers));
        dummyUsers.add(new User("James Ehresman-Tsagong", this.dummyUsers));
        dummyUsers.add(new User("Daniel Black", this.dummyUsers));
    }

}
