package org.reevoo.movie_test.serviceimpl;

import org.reevoo.movie_test.entity.Movie;
import org.reevoo.movie_test.repository.MovieRepository;
import org.reevoo.movie_test.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie findByName(String name) {
        return movieRepository.findByName(name).orElse(null);
    }

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }
}
