package com.example.bubbleprototype;

import android.view.View;

public interface RecyclerViewFriendsActionListener {
    void onViewClicked(int clickedViewId, int clickedItemPosition, int index, View view);
    void onViewLongClicked(int clickedViewId, int clickedItemPosition, int index, View view);
}