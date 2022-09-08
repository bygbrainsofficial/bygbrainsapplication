package com.sahilhans0605.bygbrains.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sahilhans0605.bygbrains.R;
import com.sahilhans0605.bygbrains.modelClass.ExplorePost;

public class SliderViewAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<SliderViewAdapter.Holder> {

    int[] posts;

    public SliderViewAdapter(int[] posts) {
        this.posts = posts;
    }

    @Override
    public SliderViewAdapter.Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.postexplorerow, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewAdapter.Holder viewHolder, int position) {

        viewHolder.imageView.setImageResource(posts[position]);
    }

    @Override
    public int getCount() {
        return posts.length;
    }

    public class Holder extends com.smarteist.autoimageslider.SliderViewAdapter.ViewHolder {
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.toppost);

        }
    }

}