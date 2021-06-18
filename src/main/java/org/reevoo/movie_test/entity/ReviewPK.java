package org.reevoo.movie_test.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReviewPK implements Serializable {
    private String name;
    private String reviewer;
}
