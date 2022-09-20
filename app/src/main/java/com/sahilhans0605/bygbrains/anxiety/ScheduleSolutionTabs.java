package com.sahilhans0605.bygbrains.anxiety;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.sahilhans0605.bygbrains.anxiety.ScheduleSolutionETNutritionAdapter;
import com.sahilhans0605.bygbrains.databinding.ActivityScheduleSolutionTabsBinding;

public class ScheduleSolutionTabs extends AppCompatActivity {

    ActivityScheduleSolutionTabsBinding binding;
    ScheduleSolutionETNutritionAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleSolutionTabsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter= new ScheduleSolutionETNutritionAdapter(this);
        binding.viewPager2.setAdapter(adapter);
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.getTabAt(position).select();
            }
        });


    }
}