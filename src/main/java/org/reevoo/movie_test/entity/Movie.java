package org.reevoo.movie_test.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Document(collection = "movie")
public class Movie implements Serializable {
    @Id
    @Column(name="NAME",nullable = false)
    private String name;

    @Column(name="RELEASE_TIME")
    private Date releaseTime;

    @Column(name="RATING")
    private Float ratings;

    @Column(name="POSTER")
    private Byte poster;

    @Column(name="INTRODUCTION")
    private String introduction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Float getRatings() {
        return ratings;
    }

    public void setRatings(Float ratings) {
        this.ratings = ratings;
    }

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
}
