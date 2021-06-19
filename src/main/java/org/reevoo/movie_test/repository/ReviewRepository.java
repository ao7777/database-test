package org.reevoo.movie_test.repository;

import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.entity.ReviewPK;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "review", path = "review")
public interface ReviewRepository extends MongoRepository<Review, ReviewPK> {
    @Query(value = "{'name':?0}")
    List<Review> findAllByName(String name);
}
