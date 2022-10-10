package com.sahilhans0605.bygbrains.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDepressionBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDisordersBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageSleepBinding;

public class ResultPageSleep extends AppCompatActivity {

    ActivityResultPageSleepBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageSleepBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        int result = getIntent().getIntExtra("yes", 3);
        if (result >= 0 && result <= 9) {
            binding.result.setText("Your sleep is in great shape. Keep doing what you’re doing and spread the word! ");
        } else if (result >= 10 && result <= 18) {
            binding.result.setText("Your sleep is in good shape, but there are still many steps you can take to make it even better ");
        } else if (result >= 19 && result <= 27) {
            binding.result.setText("You have some sleep problems. It’s important to examine your sleep habits and see how you can make changes. ");
        } else if (result >= 18 && result <= 36) {
            binding.result.setText("Your sleep problems seem to be severe. You should definitely seek help");
        }
        binding.speedView.speedTo(result);

    }
}