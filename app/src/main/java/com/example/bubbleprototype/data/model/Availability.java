package com.example.bubbleprototype.data.model;

import android.util.Log;

import java.util.List;

public class Availability {
    public int[] userAvail;

    public Availability(){
        this.userAvail = new int[35];
    }

    public static float[] merge(List<int[]> avails) {
        int firstLength = avails.get(0).length;
        for (int[] ls : avails) {
            if (firstLength != ls.length) {
                Log.d("AVAILERROR", "Incorrect arguments to availability merge");
                return null;
            }
        }
        float[] result = new float[firstLength];
        for (int i = 0; i < firstLength; i++) {
            int availabilityCount = 0;
            for (int[] ls : avails) {
                availabilityCount += ls[i];
            }
            result[i] = ((float) availabilityCount) / avails.size();
        }
        return result;
    }
}
