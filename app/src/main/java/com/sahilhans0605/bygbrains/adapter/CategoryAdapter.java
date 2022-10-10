package com.sahilhans0605.bygbrains.adapter;

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
import com.sahilhans0605.bygbrains.anger.DisordersQuestionsAnger;
import com.sahilhans0605.bygbrains.anxiety.DisordersQuestionsAnxiety;
import com.sahilhans0605.bygbrains.depression.DisordersQuestionsDepression;
import com.sahilhans0605.bygbrains.modelClass.CategoryModel;
import com.sahilhans0605.bygbrains.sleep.DisordersQuestionsSleep;
import com.sahilhans0605.bygbrains.stress.DisordersQuestionsStress;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    ArrayList<CategoryModel> categoryModels;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> categoryModels) {
        this.context = context;
        this.categoryModels = categoryModels;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categoriesdisordersrow, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        CategoryModel model = categoryModels.get(position);
        holder.textView.setText(model.getCategoryName());
        Glide.with(context).load(model.getCategoryImage()).into(holder.imageView);
        if (holder.textView.getText().toString().equals("Anxiety")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DisordersQuestionsAnxiety.class);
                    context.startActivity(intent);
                }
            });
        }else  if (holder.textView.getText().toString().equals("Stress")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DisordersQuestionsStress.class);
                    context.startActivity(intent);
                }
            });
        }else  if (holder.textView.getText().toString().equals("Sleep")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DisordersQuestionsSleep.class);
                    context.startActivity(intent);
                }
            });
        }else  if (holder.textView.getText().toString().equals("Depression")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DisordersQuestionsDepression.class);
                    context.startActivity(intent);
                }
            });
        } else  if (holder.textView.getText().toString().equals("Anger")) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DisordersQuestionsAnger.class);
                    context.startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categoryImage);
            textView = itemView.findViewById(R.id.categoryName);
        }
    }
}
