package com.sahilhans0605.bygbrains.anxiety;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.modelClass.CategoryModel;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    Context context;
    ArrayList<CategoryModel> categoryModels;

    public ScheduleAdapter(Context context, ArrayList<CategoryModel> categoryModels) {
        this.context = context;
        this.categoryModels = categoryModels;
    }


    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedule_disorders_sample, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        CategoryModel model = categoryModels.get(position);
        holder.textView.setText(model.getCategoryName());
        Glide.with(context).load(model.getCategoryImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ScheduleSolutionTabs.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImages);
            textView = itemView.findViewById(R.id.categoryNames);
        }
    }
}
