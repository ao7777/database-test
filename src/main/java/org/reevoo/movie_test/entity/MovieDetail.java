package org.reevoo.movie_test.entity;

import java.util.List;

public class MovieDetail {
    private Byte poster;//海报
    private String introduction;//介绍
    private List<Review> reviews;//评分

    public Byte getPoster() {
        return poster;
    }

    public void setPoster(Byte poster) {
        this.poster = poster;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
