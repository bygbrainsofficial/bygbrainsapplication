package com.sahilhans0605.bygbrains.anxiety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDisordersBinding;

public class ResultPageDisorders extends AppCompatActivity {

    ActivityResultPageDisordersBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageDisordersBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        int result = getIntent().getIntExtra("yes",3);
        binding.speedView.speedTo(result);

    }
}