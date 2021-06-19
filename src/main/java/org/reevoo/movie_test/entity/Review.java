package org.reevoo.movie_test.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;


@IdClass(ReviewPK.class)
@Document(collection = "review")
public class Review implements Serializable {
    @Id
    @Column(name="NAME",nullable = false)
    private String name;
    @Id
    @Column(name="REVIEWER")
    private String reviewer;
    @Column(name="CONTENT")
    private String content;
    @Column(name="RATING")
    private Float rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
