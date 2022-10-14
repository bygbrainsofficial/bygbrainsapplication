package com.sahilhans0605.bygbrains.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.activity.AddPostAdmin;
import com.sahilhans0605.bygbrains.databinding.FragmentSocialMediaBinding;

public class SocialMedia extends Fragment {
    FragmentSocialMediaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_media, container, false);
        binding = FragmentSocialMediaBinding.bind(view);
        binding.addPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddPostAdmin.class);
                startActivity(intent);

            }
        });
        return view;
    }
}