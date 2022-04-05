package com.example.bubbleprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.data.model.BubbleApplication;

import java.util.ArrayList;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.TagsViewHolder> {

    ArrayList<Integer> arrayList;
    private RecyclerViewFriendsActionListener mListener;
    private BubbleApplication application;
    private static int friendIndex = 0;

    public FriendsAdapter(RecyclerViewFriendsActionListener mListener, BubbleApplication application) {
        this.mListener = mListener;
        this.application = application;
        this.arrayList = application.friends;
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_friends_chip, parent, false);
        final TagsViewHolder holder = new TagsViewHolder(layoutView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), Integer.parseInt(holder.indexHack.getText().toString()), view);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), Integer.parseInt(holder.indexHack.getText().toString()), view);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), Integer.parseInt(holder.indexHack.getText().toString()), view);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //System.out.println(holder.tagText.getText());
                mListener.onViewLongClicked(view.getId(), holder.getAdapterPosition(), Integer.parseInt(holder.indexHack.getText().toString()), view);
                return false;
            }
        });
        return new FriendsAdapter.TagsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TagsViewHolder holder, final int position) {
        String text = application.dummyUsers.get(application.friends.get(position)).name;
        holder.tagText.setText(text);
        holder.indexHack.setText(Integer.toString(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TagsViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public RelativeLayout itemView;
        public TextView indexHack;

        public TagsViewHolder(View view) {
            super(view);
            indexHack = view.findViewById(R.id.indexHack);
            tagText = view.findViewById(R.id.chipTextView);
            itemView = view.findViewById(R.id.chipView);
        }
    }
}