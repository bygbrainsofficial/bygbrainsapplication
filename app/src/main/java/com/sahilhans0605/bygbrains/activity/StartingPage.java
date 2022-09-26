package com.sahilhans0605.bygbrains.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.sahilhans0605.bygbrains.databinding.ActivityStartingPageBinding;

public class StartingPage extends AppCompatActivity {

    ActivityStartingPageBinding binding;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartingPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            Intent intent = new Intent(StartingPage.this, EmotionRatingBarActivity.class);
            startActivity(intent);
            finishAffinity();
        }
        binding.getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartingPage.this,UserDetails.class);
                startActivity(intent);
            }
        });

//        binding.login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(StartingPage.this,OTPSignIn.class);
//                startActivity(intent);
//            }
//        });
    }
}