package com.example.tugas4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView rvMovie;
    private ArrayList<MovieModel> list = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvMovie = view.findViewById(R.id.fragmenthome_rv);
        list.addAll(MovieData.getListData());

        showRecyclerList();
        return view;
    }

    private void showRecyclerList() {
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterMovie adapterMovie = new AdapterMovie(getActivity());
        adapterMovie.setMovieModel(list);
        rvMovie.setAdapter(adapterMovie);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
