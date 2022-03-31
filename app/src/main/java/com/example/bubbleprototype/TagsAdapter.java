package com.example.bubbleprototype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsViewHolder> {

    ArrayList<String> arrayList;
    private RecyclerViewActionListener mListener;

    public TagsAdapter(ArrayList<String> arrayList, RecyclerViewActionListener mListener) {
        this.arrayList = arrayList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_tags_chip, parent, false);
        final TagsViewHolder holder = new TagsViewHolder(layoutView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), holder.tagText.getText().toString());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), holder.tagText.getText().toString());
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onViewClicked(view.getId(), holder.getAdapterPosition(), holder.tagText.getText().toString());
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                System.out.println(holder.tagText.getText());
                mListener.onViewLongClicked(view.getId(), holder.getAdapterPosition(), holder.tagText.getText().toString());
                return false;
            }
        });
        return new TagsAdapter.TagsViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull final TagsViewHolder holder, final int position) {
        holder.tagText.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class TagsViewHolder extends RecyclerView.ViewHolder {
        public TextView tagText;
        public RelativeLayout itemView;

        public TagsViewHolder(View view) {
            super(view);
            tagText = view.findViewById(R.id.chipTextView);
            itemView = view.findViewById(R.id.chipView);
        }
    }
}