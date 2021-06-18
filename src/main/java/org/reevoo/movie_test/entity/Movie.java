package org.reevoo.movie_test.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    @Id
    private String name;
    private Date releaseTime;
    private Float ratings;
    private Byte poster;
    private String introduction;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "name")
    private List<Review> reviews;

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        updateRatings();
    }

    private void updateRatings() {
        for (Review review : this.getReviews()) this.ratings += review.getRating();
        this.ratings /= this.getReviews().size();
    }
}
