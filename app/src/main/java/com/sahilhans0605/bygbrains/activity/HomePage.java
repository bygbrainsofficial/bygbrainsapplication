package com.sahilhans0605.bygbrains.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationBarView;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.databinding.HomePageBinding;
import com.sahilhans0605.bygbrains.fragments.CalendarFragment;
import com.sahilhans0605.bygbrains.fragments.HomeFragment;
import com.sahilhans0605.bygbrains.fragments.ProfileFragment;

public class HomePage extends AppCompatActivity {

    HomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = HomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeFragment = getSupportFragmentManager().beginTransaction();
        homeFragment.replace(R.id.frameLayout, new HomeFragment());
       homeFragment.commit();
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {
                    case R.id.home:
                        transaction.replace(R.id.frameLayout, new HomeFragment());
                        break;
                    case R.id.calendar:
                        transaction.replace(R.id.frameLayout, new CalendarFragment());
                        break;
                    case R.id.profile:
                        transaction.replace(R.id.frameLayout,new ProfileFragment());
                        break;
                }
                transaction.commit();

                return true;
            }

        });
    }
}