package com.example.user.buttonnavigation;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu2Fragment extends Fragment implements MainView{
    List<KampusModel> kampusModels = new ArrayList<>();
    KampusAdapter adapter;
    public Menu2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu2, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new KampusAdapter(getContext(), kampusModels);
        recyclerView.setAdapter(adapter);
        KampusData data = new KampusData(this,getContext());
        data.setData();
    }

    public void onSuccess(List<KampusModel> kampusModels){
        this.kampusModels.clear();
        this.kampusModels.addAll(kampusModels);
        this.adapter.notifyDataSetChanged();
    }

}
