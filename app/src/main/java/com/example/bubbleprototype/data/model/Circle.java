package com.example.bubbleprototype.data.model;

import java.util.ArrayList;
import java.util.List;

public class Circle {
    public String name;
    public ArrayList<Integer> members; //This should be a list of indices into the friends attribute of BubbleApplication
    public Colab colab;
    public ArrayList<Event> events; //list of all current events for the circle

    public Circle(String name){
        this.name = name;
        members = new ArrayList<Integer>();
        colab = new Colab();
        events = new ArrayList<Event>();
    }
}
