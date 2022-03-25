package com.example.bubbleprototype.data.model;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class BubbleApplication extends Application {
    public List<Circle> circles; //all of the user's created circles
    public List<User> dummyUsers; //a bunch of fake users that are hardcoded with names/availabilities
    public Availability avail; //the user's availability - should be modified by the edit availability screen
    public List<Integer> friends; //indices of any friends the user has added - create circle should pull from this, and add friends should add to this

    public void initApplication(){
        circles = new ArrayList<Circle>();
        dummyUsers = new ArrayList<User>();
        avail = new Availability();
        friends = new ArrayList<Integer>();
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
