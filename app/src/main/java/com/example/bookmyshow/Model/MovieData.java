package com.example.bookmyshow.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieData {


    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("is_new")
    @Expose
    private Integer isNew;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("like_percent")
    @Expose
    private Integer likePercent;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getLikePercent() {
        return likePercent;
    }

    public void setLikePercent(Integer likePercent) {
        this.likePercent = likePercent;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MovieData(Integer id, String image, Integer isNew, String rating, Integer likePercent, Integer voteCount, String title, String language, String type) {
        this.id = id;
        this.image = image;
        this.isNew = isNew;
        this.rating = rating;
        this.likePercent = likePercent;
        this.voteCount = voteCount;
        this.title = title;
        this.language = language;
        this.type = type;
    }
}
