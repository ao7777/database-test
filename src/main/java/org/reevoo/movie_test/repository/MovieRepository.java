package org.reevoo.movie_test.repository;

import java.util.Optional;

import org.reevoo.movie_test.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
    @Query(value = "{'name':?0}")
    Optional<Movie> findByName(String name);
}
