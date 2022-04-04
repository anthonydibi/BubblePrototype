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
    public String curEventTitle;

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
        testCircle.members.add(0);
        testCircle.members.add(1);
        testCircle.members.add(2);
        curCircle = "";
    }

    private void initializeDummyUsers(){
        dummyUsers.add(new User("Anthony Di Biaggio", this.dummyUsers));
        dummyUsers.get(0).setAvail(0);
        dummyUsers.get(0).setAvail(3);
        dummyUsers.get(0).setAvail(10);
        dummyUsers.add(new User("Roshina Rafee", this.dummyUsers));
        dummyUsers.get(1).setAvail(0);
        dummyUsers.add(new User("Bharti Devi", this.dummyUsers));
        dummyUsers.add(new User("Michael Allrich", this.dummyUsers));
        dummyUsers.add(new User("James Ehresman-Tsagong", this.dummyUsers));
        dummyUsers.add(new User("Daniel Black", this.dummyUsers));
    }

    public Circle getCircle(String name){
        for(int i = 0; i < circles.size(); i++){
            if(circles.get(i).name.equals(name)){
                return circles.get(i);
            }
        }
        return null;
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
