package org.reevoo.movie_test.service;

import org.reevoo.movie_test.entity.Movie;

public interface MovieService {
    Movie findByName(String name);

    void save(Movie movie);
}
