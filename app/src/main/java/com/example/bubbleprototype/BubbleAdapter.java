package com.example.bubbleprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.data.model.Bubble;

import java.util.ArrayList;

public class BubbleAdapter extends RecyclerView.Adapter<BubbleAdapter.BubbleViewHolder>{
    private ArrayList<Bubble> bubbleList;

    private OnItemClickListener mlistener;
    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mlistener = listener;
    }

    public static class BubbleViewHolder extends RecyclerView.ViewHolder {
        public TextView idea;

        public BubbleViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            idea = itemView.findViewById(R.id.textViewIdea);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
//                        int position = getAbsoluteAdapterPosition();
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position, view);
                        }

                    }
                }
            });
        }
    }

    public BubbleAdapter(ArrayList<Bubble> bubbleList) {
        this.bubbleList = bubbleList;
    }

    @NonNull
    @Override
    public BubbleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bubble_item, parent, false);
        BubbleViewHolder bubviewhold = new BubbleViewHolder(view, mlistener);
        return bubviewhold;
    }

    @Override
    public void onBindViewHolder(@NonNull BubbleViewHolder holder, int position) {
        Bubble bubbleItem = bubbleList.get(position);

        holder.idea.setText(bubbleItem.idea);
    }

    @Override
    public int getItemCount() {
        return bubbleList.size();
    }
}
