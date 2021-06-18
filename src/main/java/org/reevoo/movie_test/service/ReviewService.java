package org.reevoo.movie_test.service;

import org.reevoo.movie_test.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllByName(String name);

    void save(Review review);
}
