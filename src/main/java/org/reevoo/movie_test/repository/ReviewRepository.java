package org.reevoo.movie_test.repository;

import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.entity.ReviewPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, ReviewPK> {
    List<Review> findAllByName(String name);
}
