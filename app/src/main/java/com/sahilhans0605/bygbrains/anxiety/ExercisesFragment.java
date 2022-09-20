package com.sahilhans0605.bygbrains.anxiety;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.FragmentExercisesBinding;

import java.util.ArrayList;
import java.util.List;

public class ExercisesFragment extends Fragment {
    FragmentExercisesBinding binding;
    List<ExerciseDaysModel> modelList;
    ExerciseDaysAdapter adapter;
    List<NestedModel> nestedModelList1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exercises, container, false);
        modelList = new ArrayList<>();
        adapter = new ExerciseDaysAdapter(modelList, getContext());
        binding = FragmentExercisesBinding.bind(view);
        binding.exerciseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        nestedModelList1 = new ArrayList<>();
        nestedModelList1.add(new NestedModel("Relax by breathing", R.drawable.awareness));
        nestedModelList1.add(new NestedModel("Hero pose", R.drawable.avatarmentalhealth));
        nestedModelList1.add(new NestedModel("Anulom VIlom", R.drawable.avatarmentalhealth));
        nestedModelList1.add(new NestedModel("Corpe pose", R.drawable.avatarmentalhealth));
        nestedModelList1.add(new NestedModel("setu bandh", R.drawable.avatarmentalhealth));

        modelList.add(new ExerciseDaysModel("Day1", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day2", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day3", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day4", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day5", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day6", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day7", nestedModelList1));
        modelList.add(new ExerciseDaysModel("Day8", nestedModelList1));

        adapter = new ExerciseDaysAdapter(modelList, getContext());
        binding.exerciseRecyclerView.setAdapter(adapter);

        return view;
    }
}