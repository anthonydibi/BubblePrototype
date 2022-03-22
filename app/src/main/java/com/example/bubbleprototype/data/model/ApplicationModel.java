package com.example.bubbleprototype.data.model;

import android.app.Application;

public class ApplicationModel extends Application {

    private String someVariable;

    public String getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(String someVariable) {
        this.someVariable = someVariable;
    }
}
