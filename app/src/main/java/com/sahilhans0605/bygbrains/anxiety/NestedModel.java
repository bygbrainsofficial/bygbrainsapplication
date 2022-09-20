package com.sahilhans0605.bygbrains.anxiety;

public class NestedModel {
    String exerciseName;
    int imageView;

    public NestedModel(String exerciseName, int imageView) {
        this.exerciseName = exerciseName;
        this.imageView = imageView;
    }

    public NestedModel() {

    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
