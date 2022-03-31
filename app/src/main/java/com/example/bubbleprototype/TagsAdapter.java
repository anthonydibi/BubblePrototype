package com.example.bubbleprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsViewHolder> {

    ArrayList<String> arrayList;

    public TagsAdapter(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TagsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_tags_chip, parent, false);

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

        public TagsViewHolder(View view) {
            super(view);

            tagText = view.findViewById(R.id.chipTextView);
        }
    }
}