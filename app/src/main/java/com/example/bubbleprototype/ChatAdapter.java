package com.example.bubbleprototype;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.bubbleprototype.data.model.Bubble;
import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder>{

    private ArrayList<String> chatList;
    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        public TextView msg;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            msg = itemView.findViewById(R.id.textViewChat);
        }
    }

    public ChatAdapter(ArrayList<String> chatList) {
        this.chatList = chatList;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        ChatViewHolder cvh = new ChatViewHolder(view);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        String chatItem = chatList.get(position);
        holder.msg.setText(chatItem);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }
}

