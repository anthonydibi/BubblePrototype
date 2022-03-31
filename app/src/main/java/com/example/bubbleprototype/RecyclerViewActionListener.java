package com.example.bubbleprototype;

public interface RecyclerViewActionListener {
    void onViewClicked(int clickedViewId, int clickedItemPosition, String text);
    void onViewLongClicked(int clickedViewId, int clickedItemPosition, String text);
}
