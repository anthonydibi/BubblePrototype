package com.example.bubbleprototype.data.model;

import java.util.ArrayList;
import java.util.List;

public class Colab {
    public List<String> chat;
    public List<Bubble> bubbles;

    public Colab(){
        this.chat = new ArrayList<String>();
        this.bubbles = new ArrayList<Bubble>();
    }
}
