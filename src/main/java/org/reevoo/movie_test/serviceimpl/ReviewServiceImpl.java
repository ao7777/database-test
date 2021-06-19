package org.reevoo.movie_test.serviceimpl;

import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.repository.ReviewRepository;
import org.reevoo.movie_test.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> findAllByName(String name) {
        return reviewRepository.findAllByName(name);
    }

    @Override
    public void save(Review review) {
        reviewRepository.insert(review);
    }
}
