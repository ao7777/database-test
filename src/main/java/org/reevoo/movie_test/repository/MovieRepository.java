package org.reevoo.movie_test.repository;

import java.util.Optional;

import org.reevoo.movie_test.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, String> {
    Optional<Movie> findByName(String name);
}
