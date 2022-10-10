package com.sahilhans0605.bygbrains.stress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageAngerBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDisordersBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageStressBinding;

public class ResultPageStress extends AppCompatActivity {

    ActivityResultPageStressBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageStressBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        int result = getIntent().getIntExtra("yes", 3);
        if (result >= 0 && result <= 13) {
            binding.result.setText("Low Stress");
        } else if (result >= 14 && result <= 26) {
            binding.result.setText("Moderate Stress");
        } else if (result >= 27 && result <= 40) {
            binding.result.setText("high perceived stress.");
        }
        binding.speedView.speedTo(result);

    }
}