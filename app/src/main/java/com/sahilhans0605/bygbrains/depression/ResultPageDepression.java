package com.sahilhans0605.bygbrains.depression;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDepressionBinding;
import com.sahilhans0605.bygbrains.databinding.ActivityResultPageDisordersBinding;

public class ResultPageDepression extends AppCompatActivity {

     ActivityResultPageDepressionBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultPageDepressionBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        int result = getIntent().getIntExtra("yes", 3);
        if (result >= 0 && result <= 5) {
            binding.result.setText("These ups and downs are considered normal");
        } else if (result >= 6 && result <= 8) {
            binding.result.setText("Mild mood disturbance");
        } else if (result >=9 && result <=11) {
            binding.result.setText("Borderline clinical depression");
        } else if (result >=12 && result <=16) {
            binding.result.setText("Moderate depression");
        } else if (result >=17 && result <=21) {
            binding.result.setText("Severe depression");
        } else if (result >=21) {
            binding.result.setText("Extreme depression");
        }
        binding.speedView.speedTo(result);

    }
}