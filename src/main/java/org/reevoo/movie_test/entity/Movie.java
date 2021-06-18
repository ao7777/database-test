package org.reevoo.movie_test.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    private String name;
    private Date releaseTime;
    private Float ratings;
    private Byte poster;
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
