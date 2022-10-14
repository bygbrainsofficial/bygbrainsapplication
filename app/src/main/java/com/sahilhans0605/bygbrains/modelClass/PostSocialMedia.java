package com.sahilhans0605.bygbrains.modelClass;

public class PostSocialMedia {
    String description;
    String purl;
    String id;
    String postId;

    public PostSocialMedia(String description, String purl, String id, String postId) {
        this.description = description;
        this.purl = purl;
        this.id = id;
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
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
}
