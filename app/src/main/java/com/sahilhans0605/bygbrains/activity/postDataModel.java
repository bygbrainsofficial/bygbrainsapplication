package com.sahilhans0605.bygbrains.activity;

public class postDataModel {
    String postDescription;
    String s;
    String id;
    String postId;
    String postDate;

    public postDataModel() {
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public postDataModel(String postDescription, String s, String id, String postId, String postDate) {
        this.postDescription = postDescription;
        this.s = s;
        this.id = id;
        this.postId = postId;
        this.postDate = postDate;
    }
}
