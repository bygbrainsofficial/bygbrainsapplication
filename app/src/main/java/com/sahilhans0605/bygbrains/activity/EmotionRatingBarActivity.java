package com.sahilhans0605.bygbrains.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.hsalf.smileyrating.SmileyRating;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.ActivityEmotionRatingBarBinding;
import com.sahilhans0605.bygbrains.fragments.HomeFragment;
//https://github.com/sujithkanna/SmileyRating
//https://www.youtube.com/watch?v=cgLQiDECYNw&ab_channel=SabithPkcMnr

public class EmotionRatingBarActivity extends AppCompatActivity {

    ActivityEmotionRatingBarBinding binding;
    int rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmotionRatingBarBinding.inflate(getLayoutInflater());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(binding.getRoot());
        binding.smileRating.setTitle(SmileyRating.Type.GREAT, "Awesome");
        binding.smileRating.setFaceColor(SmileyRating.Type.GREAT, Color.BLUE);
        binding.smileRating.setFaceBackgroundColor(SmileyRating.Type.GREAT, Color.RED);
        binding.smileRating.setSmileySelectedListener(new SmileyRating.OnSmileySelectedListener() {
            @Override
            public void onSmileySelected(SmileyRating.Type type) {
                // You can compare it with rating Type
                if (SmileyRating.Type.GREAT == type) {
                }
                // You can get the user rating too
                // rating will between 1 to 5
                rating = type.getRating();
                Toast.makeText(EmotionRatingBarActivity.this, type.getRating() + "", Toast.LENGTH_LONG).show();
            }
        });

        binding.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EmotionRatingBarActivity.this, rating + "", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EmotionRatingBarActivity.this,HomePage.class);
                startActivity(intent);
            }
        });
    }
}