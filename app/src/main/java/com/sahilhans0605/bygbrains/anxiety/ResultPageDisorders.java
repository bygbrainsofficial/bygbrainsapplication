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
        int result = getIntent().getIntExtra("yes", 3);
        if (result >= 0 && result <= 11) {
            binding.result.setText("low anxiety");
        } else if (result >= 12 && result <= 17) {
            binding.result.setText("Moderate Anxiety");
        } else if (result >= 18) {
            binding.result.setText("potentially concerning levels of anxiety");
        }
        binding.speedView.speedTo(result);

    }
}