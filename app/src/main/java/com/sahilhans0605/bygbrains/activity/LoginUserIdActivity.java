package com.sahilhans0605.bygbrains.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityLoginUserIdBinding;

public class LoginUserIdActivity extends AppCompatActivity {

    ActivityLoginUserIdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivityLoginUserIdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}