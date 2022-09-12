package com.sahilhans0605.bygbrains.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.adapter.CategoryAdapter;
import com.sahilhans0605.bygbrains.adapter.SliderViewAdapter;
import com.sahilhans0605.bygbrains.databinding.FragmentHomeBinding;
import com.sahilhans0605.bygbrains.modelClass.CategoryModel;
import com.sahilhans0605.bygbrains.modelClass.ExplorePost;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<CategoryModel> models;
    FirebaseFirestore database;

    int[] posts = {R.drawable.emotions, R.drawable.awareness, R.drawable.goals, R.drawable.reality, R.drawable.mentalhealth};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        binding = FragmentHomeBinding.bind(view);
        database = FirebaseFirestore.getInstance();
//        Recycler view1....
        models = new ArrayList<>();
        SliderViewAdapter exploreAdapter = new SliderViewAdapter(posts);
        binding.imageSlider.setSliderAdapter(exploreAdapter);
        binding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        binding.imageSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        binding.imageSlider.startAutoCycle();


//Recyceriew2
        CategoryAdapter adapter = new CategoryAdapter(getActivity(), models);

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
        GridLayoutManager layoutManager1= new GridLayoutManager(getActivity(),2);
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