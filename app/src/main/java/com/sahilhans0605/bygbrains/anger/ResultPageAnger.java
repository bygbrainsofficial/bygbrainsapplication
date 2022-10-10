package com.sahilhans0605.bygbrains.anger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageAngerBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDisordersBinding;

public class ResultPageAnger extends AppCompatActivity {

    ActivityResultPageAngerBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageAngerBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        int result = getIntent().getIntExtra("yes", 3);
        if (result >= 0 && result <= 7) {
            binding.result.setText("Minimal Clinical Anger");
        } else if (result >= 8 && result <= 11) {
            binding.result.setText("Mild Clinical Anger");
        } else if (result >= 12 && result <= 17) {
            binding.result.setText("Moderate Clinical Anger");
        } else if (result >= 18) {
            binding.result.setText("Severe Clinical Anger");
        }
        binding.speedView.speedTo(result);

    }
}