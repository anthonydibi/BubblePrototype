package com.example.bubbleprototype.home.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bubbleprototype.R;
import com.example.bubbleprototype.TagsAdapter;
import com.example.bubbleprototype.data.model.BubbleApplication;
import com.example.bubbleprototype.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

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
        TagsAdapter adapter = new TagsAdapter(circleList);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}