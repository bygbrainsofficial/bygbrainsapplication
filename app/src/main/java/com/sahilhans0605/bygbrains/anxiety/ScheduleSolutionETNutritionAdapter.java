package com.sahilhans0605.bygbrains.anxiety;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScheduleSolutionETNutritionAdapter extends FragmentStateAdapter {
    public ScheduleSolutionETNutritionAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new ExercisesFragment();
            case 1: return new TipsFragment();
            case 2: return new NutritionFragment();
            default:return new ExercisesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
