package com.example.bubbleprototype.home.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.BubbleColab;
import com.example.bubbleprototype.PlanInfo;
import com.example.bubbleprototype.R;
import com.example.bubbleprototype.RecyclerViewActionListener;
import com.example.bubbleprototype.TagsAdapter;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.data.todo.TodoActivity;
import com.example.bubbleprototype.databinding.FragmentHomeBinding;
import com.example.bubbleprototype.home.CreateCircleActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements RecyclerViewActionListener {

    private FragmentHomeBinding binding;
    private RecyclerView recyclerView;
    private BubbleApplication application;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        application = (BubbleApplication) getActivity().getApplication();
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.circlesview);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(false);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false);
        //I have made my recycler view horizontal, if you want it vertical, just change the horizontal above to vertical.
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<String> circleList = new ArrayList<String>();
        for(int i = 0; i < application.circles.size(); i++){
            circleList.add(application.circles.get(i).name);
        }
        TagsAdapter adapter = new TagsAdapter(circleList, this);
        recyclerView.setAdapter(adapter);
        return rootView;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onViewClicked(int clickedViewId, int clickedItemPosition, String text) {
        System.out.println(text);
        System.out.println("click " + clickedViewId + " " + clickedItemPosition);
        switch (clickedViewId) {
            case R.id.chipView:
                Intent intent = new Intent(requireActivity(), TodoActivity.class);
                intent.putExtra("circle", text);
                startActivity(intent);
                break;
        }
    }

    public void onViewLongClicked(int clickedViewId, int clickedItemPosition, String text) {
        System.out.println(text);
        switch (clickedViewId){
            case R.id.chipView:
                // Application logic when whole item long-clicked
                Intent intent = new Intent(requireActivity(), TodoActivity.class);
                intent.putExtra("circle", text);
                startActivity(intent);
                break;
        }
    }
}