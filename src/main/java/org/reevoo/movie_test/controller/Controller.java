package org.reevoo.movie_test.controller;

import org.json.JSONObject;
import org.reevoo.movie_test.Result;
import org.reevoo.movie_test.entity.Movie;
import org.reevoo.movie_test.entity.Review;
import org.reevoo.movie_test.entity.User;
import org.reevoo.movie_test.service.MovieService;
import org.reevoo.movie_test.service.ReviewService;
import org.reevoo.movie_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private MovieService movieService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @CrossOrigin
    @RequestMapping("/review")
    public Result<Object> reviewMovie(@RequestBody String json) {
        JSONObject params = new JSONObject(json);
        String name = params.getString("movieName");
        String id = params.getString("userId");
        String content = params.getString("content");
        Float rating = params.getFloat("rating");
        Review review = new Review();
        review.setName(name);
        review.setReviewer(id);
        review.setContent(content);
        review.setRating(rating);
        Movie movie = movieService.findByName(name);
        User user = userService.findById(id);
        if (movie == null || user == null) return new Result<>(0, "失败");
        reviewService.save(review);
        List<Review> reviews = reviewService.findAllByName(name);
        Float ratings = (float) 0;
        for (Review value : reviews) ratings += value.getRating();
        ratings /= reviews.size();
        movie.setRatings(ratings);
        movieService.save(movie);
        return new Result<>(1, "成功");
    }

    @CrossOrigin
    @RequestMapping("/upload")
    public Result<Object> uploadMovie(@RequestBody String json) throws ParseException {
        JSONObject params = new JSONObject(json);
        String name = params.getString("movieName");
        Date releaseTime = simpleDateFormat.parse(params.getString("releaseTime"));
        Byte poster = Byte.valueOf(params.getString("poster"));
        String introduction = params.getString("introduction");
        Movie movie = movieService.findByName(name);
        if (movie != null) return new Result<>(0, "失败");
        movie = new Movie();
        movie.setName(name);
        movie.setReleaseTime(releaseTime);
        movie.setRatings((float) 0);
        movie.setPoster(poster);
        movie.setIntroduction(introduction);
        movieService.save(movie);
        return new Result<>(1, "成功");
    }

    @CrossOrigin
    @RequestMapping("/view")
    public Result<Movie> viewMovie(@RequestParam("movieName") String name) {
        return new Result<>(1, "成功", movieService.findByName(name));
    }
}
