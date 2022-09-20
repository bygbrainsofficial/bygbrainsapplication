package com.sahilhans0605.bygbrains.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.anxiety.ScheduleAdapter;
import com.sahilhans0605.bygbrains.databinding.FragmentCalendarBinding;
import com.sahilhans0605.bygbrains.modelClass.CategoryModel;

import java.util.ArrayList;

public class CalendarFragment extends Fragment {

    FragmentCalendarBinding binding;
    ArrayList<CategoryModel> models;
    FirebaseFirestore database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        binding = FragmentCalendarBinding.bind(view);
        database = FirebaseFirestore.getInstance();
        models = new ArrayList<>();
        ScheduleAdapter adapter = new ScheduleAdapter(getActivity(), models);
        database.collection("Categories").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                models.clear();
                for (DocumentSnapshot snapshot : value.getDocuments()) {
                    CategoryModel model = snapshot.toObject(CategoryModel.class);
                    model.setCategoryId(snapshot.getId());
                    models.add(model);
                }
                adapter.notifyDataSetChanged();
            }
        });
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(RecyclerView.VERTICAL);
        binding.categoryRecyclerView.setLayoutManager(layoutManager1);
        binding.categoryRecyclerView.setAdapter(adapter);
        binding.categoryRecyclerView.setHasFixedSize(false);
        binding.categoryRecyclerView.setNestedScrollingEnabled(false);
        ViewCompat.setNestedScrollingEnabled(binding.categoryRecyclerView, false);
        binding.categoryRecyclerView.smoothScrollToPosition(binding.categoryRecyclerView.getAdapter().getItemCount());


        return view;
    }
}