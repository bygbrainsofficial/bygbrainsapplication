package com.sahilhans0605.bygbrains.anxiety;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sahilhans0605.bygbrains.R;

import java.util.List;

public class NestedAdapter extends RecyclerView.Adapter<NestedAdapter.NestedViewHolder> {

    List<NestedModel> list;

    public NestedAdapter(List<NestedModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NestedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nestedanxietyitem, parent, false);
        return new NestedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull NestedViewHolder holder, int position) {
        NestedModel model= list.get(position);
        holder.textViewV.setText(model.getExerciseName());
        holder.imageViewV.setImageResource(model.getImageView());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NestedViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewV;
        TextView textViewV;

        public NestedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewV = itemView.findViewById(R.id.imageView);
            textViewV = itemView.findViewById(R.id.textView);

        }
    }

}
