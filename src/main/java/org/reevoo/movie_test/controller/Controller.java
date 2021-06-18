package org.reevoo.movie_test.controller;

import org.reevoo.movie_test.entity.Movie;
import org.reevoo.movie_test.entity.User;
import org.reevoo.movie_test.service.MovieService;
import org.reevoo.movie_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private MovieService movieService;
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/test")
    public void test(@RequestParam("name") String name) {
        Movie movie = movieService.findByName(name);
        if (movie != null) {
            System.out.println(movie.getReviews().size());
        } else {
            System.out.println("null");
        }
    }
}
