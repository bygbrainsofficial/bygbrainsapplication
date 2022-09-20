package com.sahilhans0605.bygbrains.anxiety;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sahilhans0605.bygbrains.R;

import java.util.ArrayList;
import java.util.List;

public class ExerciseDaysAdapter extends RecyclerView.Adapter<ExerciseDaysAdapter.ExerciseViewHolder> {

    List<ExerciseDaysModel> list;
    Context context;
    List<NestedModel> nestedList= new ArrayList<>();


    public ExerciseDaysAdapter(List<ExerciseDaysModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.exercisetabsample, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        ExerciseDaysModel model = list.get(position);
        holder.textView.setText(model.getDayNumber());
        boolean isExpandable = model.isExpandable;
        holder.relativeLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        if (isExpandable) {
            holder.imageView.setImageResource(R.drawable.ic_baseline_arrow_upward_24);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_baseline_arrow_downward_24);
        }

        NestedAdapter nestedAdapter = new NestedAdapter(nestedList);
        holder.nestedRecyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedRecyclerView.setHasFixedSize(true);
        holder.nestedRecyclerView.setAdapter(nestedAdapter);


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.setExpandable(!model.isExpandable);
                nestedList = model.getItemList();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;
        RecyclerView nestedRecyclerView;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.itemTv);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            relativeLayout = itemView.findViewById(R.id.expandable_layout);
            imageView = itemView.findViewById(R.id.arro_imageview);
            nestedRecyclerView = itemView.findViewById(R.id.child_rv);

        }
    }
}
