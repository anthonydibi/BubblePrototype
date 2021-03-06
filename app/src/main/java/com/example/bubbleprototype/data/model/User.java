package com.example.bubbleprototype.data.model;

import java.util.List;

public class User {
    public String name;
    public int[] avail;
    public int index;

    public User(String name, List<User> dummyUsers){
        this.name = name;
        avail = new int[35];
        for(int i = 0; i < 35; i++){
            avail[i] = 0;
        }
        this.index = dummyUsers.size() - 1;
    }

    public void setAvail(int index){
        this.avail[index] = 1;
    }
}
